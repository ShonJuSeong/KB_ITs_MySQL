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



