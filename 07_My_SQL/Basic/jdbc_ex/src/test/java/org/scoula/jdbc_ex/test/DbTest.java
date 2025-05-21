package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {

    //단위 테스트하려고 함.
    //기능 단위 --> 메서드 단위
    //메서드 하나씩 테스트 할 수 있음
    //단위 테스트(Unit test, 유닛테스트)
    //JUnit 5
    //본 코드를 하기 전에 테스트를 충분히 거치고 난 후
    //리팩토링하여 본코드를 하면 에러율 낮아지고, 효과적으로 코딩 가능
    //TDD방법론

    @Test  // 필수 / 메서드마다 필수
    @DisplayName("DB연결 테스트 결과") // 선택사항
    public void test1() throws ClassNotFoundException, SQLException {

        Connection con = null;

        // 1. 드라이버설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버설정성공..");

        // 2. 데이터베이스연결
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String user = "scoula";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("2. db연결성공.");

        // con에 연결이 성공하면 연연결 통로에 해당하는 객체가
        // 메모리에 생김 (주소를 가짐.)
        // com에 연결이 실패하면 연결통로에해당하는 객체가
        // 메모리에 안생김(null)을 가짐
//        Assertions.assertNull(con); // Assertion : 보증하다)
    }
}
