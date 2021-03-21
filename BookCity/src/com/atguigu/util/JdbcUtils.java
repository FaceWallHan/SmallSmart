package com.atguigu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource source;
    private static ThreadLocal<Connection> coonLocal=new ThreadLocal<>();
    static {
        Properties properties = new Properties();
        try {
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            source= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn=coonLocal.get();
        if (conn==null){
            conn=source.getConnection();
            coonLocal.set(conn);
            conn.setAutoCommit(false);
        }
        return conn;
    }
    /**
     * 提交事务，并关闭释放连接
     * */
    public static void commitAndClose() {
        Connection connection = coonLocal.get();
        if (connection!=null){
            try {
                connection.commit();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        coonLocal.remove();
    }
    public static void rollBackAndClose() {
        Connection connection = coonLocal.get();
        if (connection!=null){
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        coonLocal.remove();
    }
//    public static void close(Connection connection){
//        DbUtils.closeQuietly(connection);
//    }
}
