package org.scoula.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbTest {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1. 드라이버설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1. 드라이버설정성공..");

            // 2. 데이터베이스연결
            String url = "jdbc:mysql://localhost:3306/jdbc_ex";
            String user = "scoula";
            String password = "1234";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("2. db연결성공.");

            // 3. SQL 문객체생성
            String sql = "insert into users values ('win', 'win', 'win', 'USER')";
            ps = con.prepareStatement(sql);
            System.out.println("3. sql문객체생성성공.");

            // 4. SQL 문실행및결과출력
            int result = ps.executeUpdate();
            System.out.println("4. sql문전송성공, 결과>> " + result);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버로드실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("DB실패: " + e.getMessage());
        } finally {
            // 자원해제
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("자원해제실패: " + e.getMessage());
            }
        }
    }
}