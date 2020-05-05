package gdut.QG.QGFish.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
    c3p0连接池工具类
        配置文件：JDBCUtils.properties
 */
public class JDBCUtils {
    //配置文件的属性
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //注册驱动
    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("JDBCUtil.properties");
            pro.load(is);
            //设置值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象Connection
     * @return Connection
     * @throws SQLException
     * @date 2020-04-24
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源ResultSet，Statement，Connection
     * @param rs
     * @param stmt
     * @param conn
     * @date 2020-04-24
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
