# 1. DBMS 개요, 설치, 전체 운영 실습
## DBMS란?  
DBMS(Database Management System, 데이터베이스 관리 시스템)는 데이터베이스를 생성하고,  
관리하고, 데이터를 효율적으로 저장·조회·수정·삭제할 수 있도록 도와주는 소프트웨어

🔹 DBMS가 필요한 이유  
컴퓨터에 저장된 데이터를 그냥 파일로 관리하면:  
데이터 중복 발생  
일관성 유지 어려움  
여러 사용자가 동시에 접근하면 충돌 발생  
➡ 이런 문제를 해결하기 위해 DBMS가 등장.  

  
🔹 DBMS의 주요 기능
|기능	|설명|
|:----:|:----:|
|✅ 데이터 정의 (DDL)|	테이블 생성/수정/삭제 (예: CREATE, ALTER, DROP)|
|✅ 데이터 조작 (DML)|	데이터 추가/조회/수정/삭제 (예: INSERT, SELECT, UPDATE, DELETE)|
|✅ 데이터 제어 (DCL)	|권한 관리, 보안 설정 (예: GRANT, REVOKE)|
|✅ 트랜잭션 관리|	데이터 일관성 유지 (예: COMMIT, ROLLBACK)|
|✅ 동시성 제어|	여러 사용자가 동시에 접근할 때 충돌 방지|


🔹 DBMS의 종류  
관계형 DBMS (RDBMS): 표 형태로 데이터를 관리  
예: MySQL, Oracle, PostgreSQL, MS SQL Server  

비관계형 DBMS (NoSQL): 비정형 데이터를 유연하게 처리  
예: MongoDB, Redis, Cassandra  
