package com.example.demo.utils;

/**
 * 数据源切换工具
 * @author zengd
 * @version 1.0
 * @date 2023/1/13 10:53
 */
public class DataSourceUtil {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "db1";

    private static final ThreadLocal<String> DB = ThreadLocal.withInitial(() -> DEFAULT_DS);

    public static void setDb(String db) {
        DB.set(db);
    }

    public static String getDb() {
        return DB.get();
    }

    public static void remove() {
        DB.remove();
    }
}
