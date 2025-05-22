# 개인 필기  

## issues 4
## 가장 많이 사용하는 내장함수
### 1. 문자열  
Concept, upper, lower, replace  

### 2. 수학  
Round, ceil, floor()  

### 3. 날짜/시간  
now, date, year  

### 4. 집계함수  
Sum, count, avg, max, min  

### 5. 조건함수
if, innull, case  

VARCHAR
DATE
FLOAT
DOUBLE
INT
DECIMAL : 고정 소수점 // EX)앞은 7자리, 소수점 뒤에 정확히 두자리 까지 하겠다 (7,2) // 
뒤에 소수점이 마음대로 붙기도 함. SO, 정확하게 안됨.
--> 금융권 데이터는 (소수점의 자리수를 표현하는)FLOAT, DOUBLE 중 뭘 쓸까? -> 느리지만 정확한 DECIMAL를 씀.
--
숫자 데이터 형식 중 많이 쓰는 타입들 특이한 타입들 
TINYINT -> 한자리 숫자를 사용할 때, 1BYTE만 차지해서 자주 씀.
엄청나게 긴 논문 같은건 TEXT형식 중 LONGTEXT를 쓰기도 함.
BLOB -> 텍스트 뿐 아니라, 이미지, 동영상 등 
LONGBLOB은 4GB까지 저장 가능

ENUM
SET
Gender ENUM(1, 2, 3, 4)
-> 하나의 값만 컬럼에 넣을 수 있음.
SET(, , , ) 여러개의 값을 컬러멩 넣을 수 있음.


- insert
- DATETIME 
- TIMESTAMP ->
- YEAR

##### 문자열 함수
- 대문자 소문자 서로 바꾸기
- ID : abc12 일 떄, 무조건 ABC12로 자동변환해서 내부적으로 변환해서 비교함.
- -> UPPER(대문자로바꿈) / LOWER

##### 날짜 및 시간 함수
- 다른 건 몰라도 NOW 하나는 알아둬라 


### 정규화

## 조인, 집합

집합은 just 합하는 것.
UNION, UNION ALL, NOT IN, IN

조인은
 inner join
 left join
 right join

 먼저쓴게 lift고, 나중에 쓴게 right다.

서브쿼리 및 기타 내용 

---
## 5. 19.월
데이터형식   
CHAR(n) / VARCHAR(n)  두개 구분은 아주 기본.

CHAR  
TEXT  
BLOB  
ENUM  
SET  

### 날짜
NOW 정말 많이 씀

### 집합  -> 실무에서 사용빈도는 적지만 쉬운 것이니 알아둘 것.
UNION : 단순 합침  
UNION ALL : 중복제거 후 합침  
/ NOT IN / IN

#### JOIN 
1. INNER JOIN (TABLE1 ∩ TABLE2)
2. LEFT JOIN (TABLE1 ∋ TABLE2)
3. RIGHT JOIN! (TABLE1 ∈ TABLE2)
4. [image](https://github.com/user-attachments/assets/7d6b98f8-c44f-4a61-8cd2-a2daa00a8063)


///

#### 문법
AS 
NAME AS
ON

## 강사님 필기
👍 뷰

MySQL 8에서 **기본 테이블(Base Table)**을 삭제(DROP TABLE)하더라도, 해당 테이블을 기반으로 만든 **뷰(View)**는 자동으로 삭제되지 않음.

⸻

1. 테이블 삭제 시 뷰는 사라지지 않는다
• DROP TABLE 원본테이블명; 명령을 실행해도, 그 테이블을 참조하고 있던 뷰(CREATE VIEW ...)는 데이터베이스에 그대로 남아 있음
• 하지만 그 뷰는 “깨진 상태(broken view)“가 되어 사용할 수 없음
• 이후 그 뷰를 사용하려고 하면 다음과 같은 에러가 발생

ERROR 1356 (HY000): View '뷰이름' references invalid table(s) or column(s) or function(s) or definer/invoker of view lack rights to use them

⸻

2. 뷰를 확인하려면

SHOW FULL TABLES IN 데이터베이스명 WHERE TABLE_TYPE = 'VIEW';

⸻

3. 뷰를 다시 사용하려면
• 뷰가 참조하는 원본 테이블이 존재해야함.
• 테이블을 복원하거나, 뷰를 다시 정의(CREATE OR REPLACE VIEW) 해야함.

⸻

4. 뷰를 함께 정리하려면
• 뷰를 먼저 삭제한 후, 테이블을 삭제하는 것이 안전
• 또는, 의존 관계를 분석할 수 있음.
1. SHOW CREATE VIEW 뷰이름; 으로 어떤 테이블을 참조하는지 확인
2. DROP VIEW 뷰이름;
3. DROP TABLE 테이블이름;

⸻

## 복합키
※ 권장사항은 아님  
두개 이상의 column을 결합, 하나의 pk/uk 구성
-> 복합키가 pk가 될 수 있음.
-> 하나가 unique, null이 안되는 경우
-> 여러개 컬럼을 결합 했을 대, pk조건에 만족하는 경우

userid / productid / price / buytbl  
apple, 100, 1000, 2025-05-19  
apple, 200, 2000, 2025-05-20  

memeber userid(pk) - apple, ice
board boardid(pk), userid(fk) - 1: apple, 2: ice, 3: apple

외래키 옵션 조선 / 제약 조건
ON DELETE CASCATE // ON UPDATE CASCADE

ALTER TABLE buyTBL
ADD CONSTRAINT FK_userTBLbuyTBL
FOREIGN KEY(userID)
REFERENCES

# 정규화


## 인덱스 
###  SQL에서 **인덱스(index)**란, 테이블의 검색 속도를 빠르게 하기 위한 데이터 구조. 책의 목차처럼, 원하는 데이터를 빠르게 찾을 수 있게 도와주는 장치


### 🔹 인덱스가 필요한 이유
SELECT에서 WHERE, ORDER BY, JOIN 등을 사용할 때 성능 향상  

수천, 수만 건이 넘는 데이터에서 검색 속도가 수십 배 빨라질 수 있음
| 종류                                   | 설명                                       |
| ------------------------------------ | ---------------------------------------- |
| **기본 인덱스** (Primary Index)           | 기본키(Primary Key)에 자동으로 생성되는 인덱스          |
| **고유 인덱스** (Unique Index)            | 중복을 허용하지 않는 컬럼에 생성됨 (예: 주민번호)            |
| **보조 인덱스** (Secondary Index)         | 일반 컬럼에 수동으로 생성함                          |
| **복합 인덱스** (Composite Index)         | 여러 컬럼을 묶어서 하나의 인덱스로 만든 것                 |
| **클러스터형 인덱스** (Clustered Index)      | 테이블 자체가 인덱스로 구성됨 (MySQL InnoDB에서 기본키 기준) |
| **비클러스터형 인덱스** (Non-Clustered Index) | 인덱스와 테이블이 분리되어 있음 (보통 보조 인덱스 형태)         |


## JDBC Java Database Connectivity
-
-- 데이터 베이스와 연결해서 입출력을 지원  
-- 데이터 베이스 관리시스템(DBMS) 종류와 상관없이 동일하게 사용할 수 있는 클래스와 인터페이스로 구성  


