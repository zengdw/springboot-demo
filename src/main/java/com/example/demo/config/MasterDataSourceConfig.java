package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author zengd
 * @version 1.0
 * @date 2023/1/11 14:23
 */
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.master"},
        sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
    @Bean("masterDataSource")
    @Qualifier
    @ConfigurationProperties("spring.datasource.master")
    public DataSource dataSource() {
        return new HikariDataSource();
    }

    @Bean("masterSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/xml/master/*.xml"));
        return factory.getObject();
    }
}
