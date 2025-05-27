## 1. JUnit 라이브러리를 이용해서 다음과 같이 출력되도록 프로그래밍하시오.  
- 프로젝트명 : jdbc_ex (임의로 변경 가능)    
- 패키지명  : org.scoula.jdbc_ex.test  
- 클래스명  : JUnitCycleTest  
![image](https://github.com/user-attachments/assets/568a8776-7954-4c13-9ceb-bcb9249f76d3)


## 2. Lombok 라이브러리를 이용하여 다음을 구현하시오.  
- 패키지명: org.scoula.jdbc_ex.domain  
- 클래스명: UserVO  

- 필드 정의  
• String id, String password, String name, String role  
- 기본 생성자와 모든 필드를 매개변수로 받는 생성자를 제공해야 한다.  
- 각 필드에 대한 getter와 setter 메서드를 제공해야 한다.  
- 객체 상태를 쉽게 출력할 수 있도록 toString() 메서드도 제공되어야 한다.  
- Lombok 라이브러리를 사용하여 필요한 메서드를 자동 생성하되, 수동 작성은 하지 않는다.  

## 3. 다음 조건을 따르는 UserDaoImpl.java를 구현하시오.  
- 패키지명: org.scoula.jdbc_ex.dao  
- UserDao 인터페이스에 각 CRUD 기능이 추상 메서드로 정의되어 있음.  
- UserDaoImpl.java는 UserDao.java를 구현하여 프로그래밍함.  
- UserDaoImpl.java의 각 메서드는 JDBCUtil.java 파일의 getConnection() 메서드를 호출하여 DB 연결을 수행하고 JDBC 3단계부터 구현함.  
- UserDao.java  

## 4. 다음과 같이 실행되도록 UserMain.java를 구현하시오.  
패키지명: org.scoula.jdbc_ex  
파일명: UserMain.java  

- DB 처리는 UserDaoImpl.java의 각 메서드를 호출하여 사용함.  
- SQL문에 들어갈 데이터는 Scanner를 이용하여 키보드로 입력하여 사용함.  
