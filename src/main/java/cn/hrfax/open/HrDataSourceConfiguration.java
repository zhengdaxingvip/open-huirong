package cn.hrfax.open;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//
//@Configuration
//public class HrDataSourceConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource newDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "secondDatasource")
//    @ConfigurationProperties(prefix = "spring.second-datasource")
//    public DataSource secondDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
