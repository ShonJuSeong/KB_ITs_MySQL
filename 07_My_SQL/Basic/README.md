# 07 Basic 문제 풀이--
### [MySQL]
1. MySQL Workbench - 데이터베이스 생성 CREATE DATABASE jdbc_ex; -- 데이터베이스명: jdbc_ex  
2. 사용자 생성 : CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';  
3. 사용자에게 jdbc_ex 사용권한 부여 및 users 테이블 정의

### [Intelli J]
1. intellij Datasource 기능 설정 -> 우상단 드럼통 -> Data Source -> MySQL
2. port / user / password / Database 명 일치  -> apply (이전에 Test Connection)
3. test폴더 -> ConncetionTest클래스 생성 ★ DB연결
4. resource폴더 -> application.properties   ★  사용자 연결
```java
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/jdbc_ex
id=scoula
password=1234
```
5. JDBCUtil 클래스 작성 ★ 네트워크 연결 확인 및 테스트

---------------------------------------------------------
## application.properties // 목적: DB 접속 정보를 외부에 분리하여 보관

##  JDBCUtil.java // 목적: JDBC 연결을 재사용 가능한 유틸리티 메서드로 제공.

##  ConnectionTest.java // 목적: JDBC 연결이 잘 작동하는지 JUnit을 이용해 테스트.

## 🔁 3. 전체 흐름
```text
1. 테스트 코드 실행
   ↓
2. testConnection() → 직접 연결
   또는  
   testConnection2() → JDBCUtil.getConnection() 호출  
   ↓  
3. JDBCUtil  
   - application.properties 읽음  
   - 드라이버 로딩  
   - DriverManager 통해 연결 객체 생성  
   ↓  
4. 테스트 성공 여부 확인  
```


## 🔍 정리
| 항목         | 내용                                                   |
| ---------- | ---------------------------------------------------- |
| **재사용성**   | `JDBCUtil`로 분리하여 코드 중복 제거 및 유지보수 편의성 향상              |
| **유연성**    | 접속 정보를 `application.properties`로 외부화하여 보안 및 설정 변경 용이 |
| **테스트 구조** | JUnit으로 각각의 방식(직접 연결, 유틸 활용) 테스트 가능                  |
| **자원 해제**  | `try-with-resources` 또는 `close()`로 자원 누수 방지          |
