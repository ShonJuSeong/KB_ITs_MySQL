package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.util.Properties;

public class JDBCUtil {
    // 1. 드라이버 설정, 2. db연결 이용해서  연결하는 것까지
    // --> Connection con; <--- con을 리턴!
    static Connection conn = null;
    public static Connection getConnection() {
        if (conn != null) return conn;

        try {
            Properties prop = new Properties();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

