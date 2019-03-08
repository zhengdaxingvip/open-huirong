package cn.hrfax.open;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
@MapperScan({"cn.hrfax.open.mapper"})
public class OpenApplication {


    @Value("${server.port}")
    private Integer port;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("classpath:sqlmap/mappers/*.xml")
    private String mapperLocation;

    private HikariDataSource dataSource;

    private DataSourceTransactionManager transactionManager;

    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private ResourcePatternResolver resourceResolver;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMapperLocation() {
        return mapperLocation;
    }

    public String[] getMapperLocations() {
        String[] mapperLocations = new String[1];
        mapperLocations[0] = getMapperLocation();
        return mapperLocations;
    }

    @PostConstruct
    public void init() {
        try {
            log.info("Init datasource: url: {}", url);
            dataSource = new HikariDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            transactionManager = new DataSourceTransactionManager();
            transactionManager.setDataSource(dataSource);
            log.info("Init done");
        } catch (Throwable t) {
            log.error("Init error", t);
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            log.info("Close {}", url);
            dataSource.close();
            log.info("Close {} done", url);
        } catch (Throwable t) {
            log.error("Destroy error", t);
        }
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactory sqlSessionFactory=null;
        if (sqlSessionFactory == null) {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            Configuration config = new org.apache.ibatis.session.Configuration();
            config.setMapUnderscoreToCamelCase(true);            sqlSessionFactoryBean.setConfiguration(config);
            sqlSessionFactoryBean.setDataSource(dataSource);
            List<Resource> resources = new ArrayList<>();
            if (this.getMapperLocations() != null) {
                for (String mapperLocation : this.getMapperLocations()) {
                    try {
                        Resource[] mappers = resourceResolver.getResources(mapperLocation);
                        resources.addAll(Arrays.asList(mappers));
                    } catch (IOException e) {
                        //log.error("IOException", e);
                        return null;
                    }
                }
            }
            Resource[] arr = resources.toArray(new Resource[resources.size()]);
            sqlSessionFactoryBean.setMapperLocations(arr);
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        }
        return sqlSessionFactory;
    }



    public static void main(String[] args) {
        SpringApplication.run(OpenApplication.class, args);
    }
}
