# 07 Basic 문제 풀이--
### [MySQL]
1. MySQL Workbench - 데이터베이스 생성 CREATE DATABASE jdbc_ex; -- 데이터베이스명: jdbc_ex  
2. 사용자 생성 : CREATE USER 'scoula'@'%' IDENTIFIED BY '1234';  
3. 사용자에게 jdbc_ex 사용권한 부여 및 users 테이블 정의

### [Intelli J]
1. intellij Datasource 기능 설정 -> 우상단 드럼통 -> Data Source -> MySQL
2. port / user / password / Database 명 일치  -> apply (이전에 Test Connection)
3. test폴더 -> ConncetionTest클래스 생성
4. resource폴더 -> application.properties ->
```java
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/jdbc_ex
id=scoula
password=1234
```
5. JDBCUtil 클래스 작성

