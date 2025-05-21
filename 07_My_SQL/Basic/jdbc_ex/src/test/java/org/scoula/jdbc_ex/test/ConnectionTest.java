// Unit5를 이용하여 데이터 베이스에 접속하는 JDBC 코드를 테스트하세요.
package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    Connection con = null;
    @Test
    @DisplayName("jdbc_ex 연결")
    public void testConnection() throws ClassNotFoundException, SQLException {
        // 1. 드라이버설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버설정성공..");

        // 2. 데이터베이스연결
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String user = "scoula";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("2. db연결성공.");

        //3. 데이터베이스 연결 해제
        con.close();
        System.out.println("3. db연결해제.");

    }
    //ConnectionTest 클래스의 testConnection2 메서드에서 JDBCUtil 클래스 기능을 테스트 하세요.
    @Test
    @DisplayName("jdbc_ex 연결")
    public void testConnection2() throws SQLException {
        try(Connection con = JDBCUtil.getConnection()){
        System.out.println("DB연결 성공");
        }
    }
}
