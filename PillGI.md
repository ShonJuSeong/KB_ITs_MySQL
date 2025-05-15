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

