package com.jiespace.config;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@ComponentScan(basePackages={"com.codingapi.tx.*","com.jiespace.*"})
@ImportResource(locations = {"classpath*:dubbo_provider.xml"})
public class LcnConfig implements TxManagerTxUrlService {

    @Autowired
    private Environment env;

    /**
     * 获取代理连接池
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource", ignoreUnknownFields = false)
    public DataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    /**
     * 注入LCN的代理连接池
     * @return
     */
    @Bean("transactionManager")
    public PlatformTransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public String getTxUrl() {
        return env.getProperty("tx.manager.url");
    }
}
