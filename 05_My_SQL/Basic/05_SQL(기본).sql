use tabledb;
DROP DATABASE IF EXISTS tabledb; -- -> IF를 쓰는 이유는 안정성 때문에 예외처리.alter
CREATE DATABASE tabledb;

USE tabledb;

DROP TABLE IF EXISTS usertbl;
-- 1번
CREATE TABLE usertbl(
	userID		CHAR(8)	NOT NULL PRIMARY KEY,
    name		VARCHAR(10) NOT NULL,
	birthyear	INT NOT NULL NULL DEFAULT -1,
	addr		CHAR(2) NULL,
    mobile1		CHAR(3) NULL,
    mobile2		CHAR(8) NULL,
    height		SMALLINT NULL DEFAULT 170,
    mDate		DATE NULL
);
-- 2번
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl(
	num			INT			AUTO_INCREMENT UNIQUE PRIMARY KEY,
    userID		CHAR(8) 	NOT NULL,
    prodName 	CHAR(6) 	NOT NULL,
	groupName	CHAR(4) 	NULL,
    price		INT 		NOT NULL,
    amount		SMALLINT 	NOT NULL,
    FOREIGN KEY (userID) REFERENCES usertbl (userID));

-- 4번
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

USE tabledb;
SELECT * FROM usertbl;
-- 5번
-- ○ 순서: userid, prodName, groupName, price, amount
 INSERT INTO buytbl VALUES ('KBS', '운동화', NULL, 30, 2 );
 INSERT INTO buytbl VALUES ('KBS', '노트북', '전자', 1000, 1 );
 INSERT INTO buytbl VALUES ('JYP', '모니터', '전자', 200, 1);
SELECT * FROM buytbl;
    -- 순서 오류 -> 
 INSERT INTO buytbl VALUES (NULL, 'KBS', '운동화', NULL, 30, 2 );
 INSERT INTO buytbl VALUES (NULL, 'KBS', '노트북', '전자', 1000, 1 );
 INSERT INTO buytbl VALUES (NULL, 'JYP', '모니터', '전자', 200, 1);
    --  > 이건 괜찮
 SELECT * FROM buytbl;
 
 -- 6번 다음 컬럼을 가지는 usertbl을 정의하세요.
DROP TABLE IF EXISTS buytbl;
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
	userID			CHAR(8) NOT NULL,
    name			VARCHAR(10) NOT NULL,
    birthyear		INT NOT NULL,
    CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID)
);
SHOW TABLES;
DESC usertbl;
SELECT * FROM usertbl;
    
-- 7번 다음 컬럼을 가지는 prodTbl을 정의하세요.
DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodTbl (
	prodCode	CHAR(3) NOT NULL,
    prodID		CHAR(4) NOT NULL,
    prodDate	DATETIME NOT NULL,
    proCur		CHAR(10) NULL,
CONSTRAINT PK_prodTbl_prodCode_prodID
PRIMARY KEY (prodCode, prodID)
);

SELECT * FROM usertbl AND buytbl;


-- DROP TABLE IF EXISTS buytbl;
-- DROP TABLE IF EXISTS usertbl;
-- CREATE TABLE usertbl (
-- 	userID 		CHAR(8) 	NOT NULL,
-- 	name 		VARCHAR(10) NOT NULL,
-- 	birthYear 	INT 		NOT NULL,
-- CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID)
-- );

--     SHOW TABLES; -- 테이블 목록보기
--     DESC TABLES; -- 테이블 구조보기

USE SQLDB;

CREATE VIEW v_userbuytbl
AS
SELECT U.userid, U.name, B.prodName, U.addr, 
	CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
	INNER JOIN buytbl B
	ON U.userid = B.userid;

SELECT * FROM v_userbuytbl WHERE name = '김범수';
    
