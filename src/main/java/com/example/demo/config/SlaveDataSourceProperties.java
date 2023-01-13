package com.example.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zengd
 * @version 1.0
 * @date 2023/1/13 9:49
 */
@ConfigurationProperties(prefix = "spring.datasource.slave")
public class SlaveDataSourceProperties extends DataSourceProperties {
}
