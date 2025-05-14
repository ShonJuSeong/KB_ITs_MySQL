# 3. SQL 기본  



## SQL 명령어 분류
### ✅ SQL 명령어 분류
|분류	|이름|	설명|
|:----:|:----:|:----:|
|DDL|	Data Definition Language	|테이블 정의/수정/삭제 (CREATE, DROP, ALTER, TRUNCATE)|
|DML|	Data Manipulation Language|	데이터 조작 (SELECT, INSERT, UPDATE, DELETE)|
|DCL|	Data Control Language	|권한 관리 (GRANT, REVOKE)|
|TCL|	Transaction Control Language|	트랜잭션 제어 (COMMIT, ROLLBACK, SAVEPOINT)|

-------------------------------------------------------------------------------------------
### 🔷 1. DDL (Data Definition Language)
👉 데이터를 담을 틀을 만드는 명령어  
즉, 테이블이나 데이터베이스를 만들고/바꾸고/삭제할 때 사용.  

#### ✅ 대표 명령어  
|명령어	|설명|	예시|
|:----:|:----:|:----:|
|CREATE|	새 데이터베이스나 테이블 만들기|	CREATE TABLE usertbl (...);|
|DROP	|테이블/데이터베이스 완전 삭제 (복구 불가❌)|	DROP TABLE usertbl;|
|ALTER	|테이블 구조 변경 (컬럼 추가/삭제 등)	|ALTER TABLE usertbl ADD age INT;|
|TRUNCATE|	테이블 안의 데이터 전부 삭제 (테이블은 남음)|	TRUNCATE TABLE usertbl;|

💡 DDL은 대부분 "틀(형식)"을 다루는 거라 한 번 실행하면 되돌릴 수 없음  
즉, ROLLBACK 안 됨  

### 🔷 2. DML (Data Manipulation Language)
👉 실제 데이터를 넣고, 수정하고, 삭제하는 명령어  

#### ✅ 대표 명령어
|명령어|	설명	|예시|
|:---:|:---:|:---:|
|SELECT	|데이터를 조회 (읽기)|	SELECT * FROM usertbl;|
|INSERT|	데이터 삽입 (추가)	|INSERT INTO usertbl (name, age) VALUES ('철수', 25);|
|UPDATE|	데이터 수정|	UPDATE usertbl SET age = 26 WHERE name = '철수';|
|DELETE|	데이터 삭제	|DELETE FROM usertbl WHERE name = '철수';|

💡 DML은 ROLLBACK이 가능함 (되돌릴 수 있음)
즉, COMMIT 하기 전까지는 "실제로 반영 안 된 상태"

### 🔷 3. DCL (Data Control Language)
👉 사용자에게 권한을 주거나 빼앗는 명령어

#### ✅ 대표 명령어
|명령어	|설명	|예시|
|:---:|:---:|:---:|
|GRANT|	사용자에게 특정 권한 부여|	GRANT SELECT ON usertbl TO user1;|
|REVOKE|	사용자 권한 회수	|REVOKE SELECT ON usertbl FROM user1;|

💡 예를 들어 어떤 사람이 특정 테이블을 읽을 수 있게 허락하거나 금지하는 기능.  

### 🔷 4. TCL (Transaction Control Language)  
👉 데이터 변경 작업을 저장하거나 되돌리는 명령어  

#### ✅ 대표 명령어
|명령어	|설명|	예시|
|:---:|:---:|:---:|
|COMMIT	|변경 내용을 확정 저장|	COMMIT;|
|ROLLBACK|	되돌리기, COMMIT 전 상태로 복구|	ROLLBACK;|
|SAVEPOINT|	되돌릴 지점을 저장 (부분 ROLLBACK 가능)|	SAVEPOINT sp1;|
  
💡 COMMIT을 하면 완전히 저장됨 → 더 이상 ROLLBACK 안 됨  

#### ✅ 요약 정리 표  
|분류|뜻| 주요 역할 |대표 명령어|ROLLBACK 가능?|
|:---:|:---:|:---:|:---:|:---:|
|DDL	|Data Definition Language|	테이블 만들고 구조 바꾸기	|CREATE, DROP, ALTER, TRUNCATE|	❌|
|DML	|Data Manipulation Language	|데이터 추가/조회/수정/삭제	|SELECT, INSERT, UPDATE, DELETE|	⭕|
|DCL	|Data Control Language|	사용자 권한 관리	|GRANT, REVOKE|	⭕|
|TCL	|Transaction Control Language	|데이터 변경 저장/취소|	COMMIT, ROLLBACK, SAVEPOINT	|⭕|


#### ✅ DML = CRUD (Create, Read, Update, Delete)
|동작	|설명|명령어	|예시|
|:----:|:----:|:----:|:----:|
|Create	|새로운 데이터 만들기|INSERT |INTO	INSERT INTO usertbl (name) VALUES ('홍길동');|
|Read|데이터 조회|	SELECT	|SELECT * FROM usertbl;|
|Update	|	기존 데이터 수정|UPDATE	|UPDATE usertbl SET height=180 WHERE name='홍길동';|
|Delete	|	데이터 삭제|DELETE |FROM	DELETE FROM usertbl WHERE name='홍길동';|  
 ##### ※ 나머지 DDL, DCL, TCL은 구조, 권한, 트랜잭션을 담당해서 CRUD와 직접 관련은 없음

#### ✅ 데이터 삭제 3가지 방식 비교
|명령어	|복구 가능 여부|	설명|
|:----:|:----:|:----:|
|DROP	|❌ 복구 불가|	테이블 전체 삭제, 구조도 날아감|
|DELETE	|✅ 복구 가능|	행 단위 삭제, ROLLBACK 가능|
|TRUNCATE	|❌ 복구 불가|	전체 데이터 삭제, 빠름, DDL이므로 롤백 안 됨|
