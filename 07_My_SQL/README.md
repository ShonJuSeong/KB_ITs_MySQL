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

---------------------------------------------------------------------------------------------------------------
## ✅ 1. main vs test: 왜 나누는가?

| 구분                   | 목적                                |
| -------------------- | --------------------------------- |
| `src/main/java`      | 애플리케이션 **실제 실행 코드** (비즈니스 로직 포함)  |
| `src/test/java`      | **테스트 전용 코드** (예: 단위 테스트, 통합 테스트) |
| `src/main/resources` | 애플리케이션 설정 파일, DB config 등 (운영용)   |
| `src/test/resources` | 테스트용 설정, 테스트 데이터 등                |

### 🔍 왜 구분하는가?
- 운영용 코드와 테스트 코드를 분리해서 유지보수가 쉽고 안정성 확보 가능
- maven, gradle 빌드시 test는 제외하거나 따로 테스트 전용으로 실행 가능
- 테스트 코드는 배포 대상이 아니기 때문에 main과 분리하는 게 표준

## ✅ 2. 패키지 및 클래스의 용도 설명
### 📦 common 패키지
- 공통 유틸 클래스, 설정 등 여러 클래스에서 공유하는 기능  
- 예: JDBCUtil  
→ DB 연결, 닫기 등의 반복되는 작업을 처리하는 클래스

```java
public class JDBCUtil {
    public static Connection getConnection() { ... }
    public static void close() { ... }
}
```

### 📦 dao (Data Access Object)    
- DB와 직접 통신하는 계층  
- 쿼리를 실행하고 데이터를 주고받는 로직 담당  
- DAO는 "데이터 접근을 추상화"해서 비즈니스 로직과 DB 코드를 분리해줌
```java
public class UserDao {
    public List<User> findAll() { ... }
    public void insert(User user) { ... }
}
```

### 📦 domain (또는 model, entity)
- 실제 데이터 구조를 표현하는 클래스
- 예: User, Product, Order 등
- DB 테이블과 1:1 매핑되는 경우가 많음
```java
public class User {
    private String id;
    private String name;
    private String role;
}
``` 

### 📦 test (테스트 전용 패키지)
- JUnit으로 기능별 단위 테스트 클래스 작성
- 예: CrudTest, ConnectionTest, DbTest
- → @Test 붙여서 실제 기능이 잘 동작하는지 확인

```java
@Test
@DisplayName("회원 추가 테스트")
void insertUser() { ... }
```

- ### ✅ 예시 흐름
1. UserDao (DAO) → DB에 접근해서 User 데이터를 가져옴
2. User (Domain) → UserDao가 반환한 데이터를 표현
3. JDBCUtil (Common) → DB 연결을 도와줌
4. CrudTest (Test) → UserDao.insert()가 잘 작동하는지 테스트함

- ### ✅ 결론
| 구성 요소        | 역할 요약            |
| ------------ | ---------------- |
| `main`       | 실제 프로그램 실행 코드    |
| `test`       | 단위/통합 테스트 코드     |
| `common`     | 유틸리티, 공통 기능 클래스  |
| `dao`        | 데이터베이스와 통신하는 로직  |
| `domain`     | 데이터를 표현하는 모델 클래스 |
| `test (패키지)` | 테스트를 위한 클래스      |


