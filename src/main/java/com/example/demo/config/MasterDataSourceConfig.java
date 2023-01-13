package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 主数据库配置
 * @author zengd
 * @version 1.0
 * @date 2023/1/11 14:23
 */
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.master"},
        sqlSessionFactoryRef = "masterSqlSessionFactory")
@EnableConfigurationProperties(MasterDataSourceProperties.class)
public class MasterDataSourceConfig {
    @Bean("masterDataSource")
    @Qualifier
    public DataSource dataSource(MasterDataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean("masterSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/xml/master/*.xml"));
        return factory.getObject();
    }
}
