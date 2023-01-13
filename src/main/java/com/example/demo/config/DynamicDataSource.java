package com.example.demo.config;

import com.example.demo.utils.DataSourceUtil;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author zengd
 * @version 1.0
 * @date 2023/1/13 10:52
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceUtil.getDb();
    }
}
