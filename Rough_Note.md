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


## 테이블 문법
DROP DATABASE   
CREATE DATABASE  
USE DATABASE  
  
usertbl 만들기   
DROP TABLE IF EXISTS usertbl;  
CREATE TABLE usertbl(....)  

buytbl
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl(
....
FOREIGN KEY(userid) REFERENCES usertbl(USERID)
-> 외래키로 usertbl의 USERID를 사용
)
