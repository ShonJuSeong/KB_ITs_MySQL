# 7. Java 연동 JDBC 프로그래밍    
### JDBC는 Java Database Connectivity의 약자로, **Java에서 데이터베이스에 연결하고 조작할 수 있도록 해주는 API(인터페이스 모음)**

| 항목      | 설명                                                    |
| ------- | ----------------------------------------------------- |
| 정식 명칭   | Java Database Connectivity                            |
| 역할      | Java 애플리케이션과 데이터베이스 간의 연결 다리 역할                       |
| 사용 목적   | SQL을 Java 코드로 실행하여 DB 조작 (조회, 삽입, 수정, 삭제 등)           |
| 지원 DBMS | MySQL, Oracle, MariaDB, PostgreSQL 등 거의 모든 관계형 데이터베이스 |

| 구성 요소                                 | 설명                           |
| ------------------------------------- | ---------------------------- |
| **DriverManager**                     | JDBC 드라이버를 관리하고, DB와의 연결을 생성 |
| **Connection**                        | 데이터베이스와의 실제 연결 객체            |
| **Statement** / **PreparedStatement** | SQL문을 실행하기 위한 객체             |
| **ResultSet**                         | SELECT 결과를 저장하는 객체           |


### ✅ JDBC 사용 흐름 (순서)
####  1. JDBC 드라이버 로드
Class.forName("com.mysql.cj.jdbc.Driver");  
####  2. DB 연결
Connection conn = DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/db명", "사용자명", "비밀번호");  
####  3. SQL 실행
Statement stmt = conn.createStatement();  
ResultSet rs = stmt.executeQuery("SELECT * FROM 테이블명");  
####  4. 결과 처리
while (rs.next()) {    
    System.out.println(rs.getString("컬럼명"));    
}    
####  5. 자원 해제
rs.close();  
stmt.close();  
conn.close();  

#### ✅ 전체 코드 예시

```java
import java.sql.*;

public class JDBCExample {  
    public static void main(String[] args) {  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로드  
            Connection conn = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/testdb", "user", "1234");  

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM members");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

![image](https://github.com/user-attachments/assets/a00f71c6-d3ef-4b8a-8c2d-508c8124c839)

--
## JUnit / Java + Unit(단위)
자바 프로그래밍 언어를 위한 단위 테스트(Unit Test) 프레임워크  
즉, 자바 코드의 특정 메서드나 클래스가 의도한 대로 작동하는지 자동으로 검사하는 도구
## TDD	(Test-Driven Development)
테스트 주도 개발을 의미. 개발을 할 때 코드보다 테스트를 먼저 작성하는 방식의 개발 방법론

| 어노테이션                | 설명                    |
| -------------------- | --------------------- |
| `@Test`              | 테스트 메서드임을 표시          |
| `@BeforeEach`        | 각 테스트 전에 실행되는 초기화 메서드 |
| `@AfterEach`         | 각 테스트 후에 실행되는 정리 메서드  |
| `@BeforeAll`         | 전체 테스트 실행 전 1회 실행     |
| `@AfterAll`          | 전체 테스트 후 1회 실행        |
| `@DisplayName("이름")` | 테스트에 이름 붙이기 (가독성 향상)  |
| `@Disabled`          | 테스트 일시적으로 실행 제외       |

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator cal = new Calculator();
        int result = cal.add(2, 3);
        assertEquals(5, result);  // 예상값과 실제값 비교
    }
}
```
