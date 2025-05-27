package org.scoula.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    // ✅ DB 접속 정보
    private static final String URL = "jdbc:mysql://localhost:3306/travel_db?serverTimezone=Asia/Seoul";
    private static final String USER = "root";       // ← 본인 DB 계정
    private static final String PASSWORD = "1234";   // ← 본인 DB 비밀번호

    private static Connection conn;

    // ✅ Connection 객체 반환 (싱글톤 방식)
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("💥 JDBC 연결 실패:");
            e.printStackTrace();
        }
        return conn;
    }

    // ✅ Connection 자원 해제
    public static void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.err.println("💥 JDBC 종료 실패:");
            e.printStackTrace();
        }
    }
}
