-- 1-1번 현재 서버에 존재하는 데이터베이스 확인
SHOW DATABASES; 

-- 1-2번 현재 데이터 베이스를 employees로 설정하기
USE employees; 

-- 1-3번 employees 데이터베이스의 테이블 목록보기
SHOW TABLES; 

-- 1-4번 employees 테이블의 열 목록 출력하기
DESCRIBE employees; 

-- 2-1번 titles 테이블의 데이터 출력하기
SELECT * FROM titles; 

-- 2-2번 employees 테이블에서 first_name  컬럼만 출력하기
SELECT first_name FROM employees; 

-- 2-3번 employees 테이블에서 first_name  컬럼, last_name 컬럼, gender 컬럼 출력하기
SELECT first_name, last_name, gender FROM employees; 

-- 3번 employees 테이블 출력 시 다음과 같이 나오도록 쿼리를 작성하세요. (4page)
SELECT first_name '이름', gender '성별', hire_date '회사 입사일' FROM employees; 

-- 5-1번 usertbl 테이블에서 이름이 '김경호' 인 행을 출력하세요.
use sqldb;
SELECT * FROM usertbl WHERE name = '김경호';

-- 5-2번 usertbl 테이블에서 생년이 1970 이상이고 키가 182이상인 데이터를 출력하세요
SELECT userID, Name FROM usertbl WHERE birthYear >= 1970 OR height >= 182;

-- 6-1번 usertbl 테이블에서 키가 180~183 범위인데이터를출력하세요.
SELECT name, height FROM usertbl WHERE height >= 180 AND height <= 183;

-- 6-2번 usertbl 테이블에서 주소가'경남' 또는 '전남' 또는'경북'인 데이터를 출력하세요.
SELECT name, addr FROM usertbl WHERE addr = '경남' OR addr = '전남' OR addr = '경북'; 

-- 6-3번 usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력하세요.
SELECT name, height, addr FROM usertbl WHERE name LIKE '김%';

-- 7번 usertbl에서 김경호보다 큰 사람들의 이름과 키를 출력하세요. * 서브쿼리를 이용하여 쿼리를 작성하세요.
SELECT name, height FROM usertbl WHERE height > (SELECT height FROM usertbl WHERE Name = '김경호');

-- 8-1번 usertbl을 mDate의 오름차순으로 정렬하여 출력하세요.
SELECT name, mDate FROM usertbl ORDER BY mDate;

-- 8-2번 usertbl을 mDate의 내림차순으로 정렬하여 출력하세요.
SELECT name, mDate FROM usertbl ORDER BY mDate DESC;

-- 8-3번 usertbl을 height의 내림차순으로 정렬하고,
-- 동률인 경우 name의 내림차순으로 정렬하여 출력하세요.alter
SELECT name, mDate FROM usertbl ORDER BY mDate DESC, name DESC;

-- 9번(10page) usertbl의 주소지를 중복없이 오름차순으로 출력하세요. 
SELECT DISTINCT addr FROM usertbl;

-- 10-1번 국가코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하세요.
USE world;
SELECT * FROM city WHERE CountryCode = 'KOR' ORDER BY Population DESC;

-- 10-2번 city 테이블에서 국가코드와 인구수를 출력하라, 정렬은 국가코드별로 오름차순으로, 동일한 코드(국가)안에
-- 서는 인구 수의 역순으로 표시하세요. 
SELECT CountryCode, Population FROM city ORDER BY CountryCode, Population DESC;

-- 10-3번 city 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요.
SELECT COUNT(*) AS '국가코드가 KOR인 도시 개수' FROM city WHERE CountryCode = 'KOR';

-- 10-4번 city 테이블에서 국가코드가 'KOR', 'CHN', 'JPN'인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode IN ('KOR', 'CHN', 'JPN');

-- 10-5번 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode = 'KOR' AND Population >= 1000000;

-- 10-6번 국가코드가 'KOR'인 도시 인구수가 많은 순서로 상위 10개만 표시하세요.
SELECT * FROM city WHERE CountryCode = 'KOR' ORDER BY Population DESC LIMIT 10;

-- 10-7번 city 테이블에서 국가코드가 'KOR'이고, 인구가 100만 이상 500만 이하인 도시를 찾으세요.
SELECT * FROM city WHERE CountryCode = 'KOR' AND Population BETWEEN 1000000 AND 5000000;
