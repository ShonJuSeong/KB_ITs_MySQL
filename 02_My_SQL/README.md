# 	2. 데이터베이스 모델링, MySQL 유틸리티 사용법
## ① 데이터베이스 모델링이란?
#### 🔹 왜 데이터베이스 모델링이 필요할까?  
예를 들어,   
쇼핑몰 웹사이트를 만든다고 할 때,  
상품 정보는 어디에?  
고객 정보는 어떻게 저장?  
주문은 누구의 주문?  
고객과 주문은 어떻게 연결?  
이런 것들을 무계획으로 만들면 나중에 데이터가 꼬이고, 수정이 어렵고, 느려지고, 오류.  
그래서 먼저, 설계도를 그림. 이것이 바로 데이터베이스 모델링.  

#### 🔹 데이터베이스 모델링의 단계  
|단계	|설명|	예시|
|:----:|:----:|:----:|
|1. 개념적 모델링	|사람 눈에 보이게 개념만 정리	|"회원", "게시글", "댓글" 같은 단어로 구성|
|2. 논리적 모델링	|어떤 테이블이 필요하고, 어떻게 연결될지 정의|	ERD(엔터티 관계 다이어그램) 그림 그리기|
|3. 물리적 모델링|	실제로 DB에서 사용할 수 있게 테이블, 컬럼, 데이터타입까지 결정|	CREATE TABLE SQL로 테이블 생성|  
  
#### 🔹 핵심 요소 3가지
|요소|	뜻|	예시|
|:----:|:----:|:----:|
|엔터티(Entity)	|데이터를 저장할 대상 (테이블)	|사용자(User), 게시글(Post)|
|속성(Attribute)|	엔터티의 성질 (컬럼)	|이름(name), 나이(age), 제목(title)|
|관계(Relationship)|	엔터티 간의 연결	|사용자 1명이 게시글 여러 개 작성 가능 (1:N)|
  
#### 🔹 대표적인 모델링 도구  
ERD(E-R 다이어그램): Entity-Relationship Diagram  

사각형(엔터티), 타원(속성), 선(관계) 으로 구성  

대표 도구: MySQL Workbench, dbdiagram.io, Draw.io  
  
  
    
#### 🔹 예시 (블로그 모델링)  
[User]───<writes>───[Post]───<has>───[Comment]  
User 테이블: id, name, email  

Post 테이블: id, title, content, user_id  

Comment 테이블: id, content, post_id  


      
## ② MySQL 유틸리티 사용법
#### 🔧 1. 자주 쓰는 MySQL 유틸리티 명령어
|도구 이름	|설명|	사용 예|
|------|:----:|:----:|
|mysql	|MySQL에 접속하는 CLI 도구|	mysql -u root -p|
|mysqldump	|데이터베이스 백업|	mysqldump -u root -p dbname > backup.sql|
|mysqladmin	|MySQL 서버 상태 확인 및 관리|	mysqladmin -u root -p status|
|mysqlshow	|DB/테이블 구조 확인	|mysqlshow -u root -p|
|mysqlimport|	CSV 등 외부 데이터| import	mysqlimport --local -u root -p dbname file.csv|
|mysqlpump|	병렬 백업 도구 (mysqldump보다 빠름)|	mysqlpump -u root -p dbname > dump.sql|

#### 📌 참고: MySQL Workbench로 할 수 있는 유틸리티 기능
GUI 환경에서 유틸리티 기능:

|기능|	설명|
|:----:|:----:|
|Data Export|	mysqldump 기반 백업|
|Data Import	|SQL 또는 CSV import|
|Server Status|	mysqladmin처럼 상태 확인|
|Query Stats	|Slow query, connections 확인|
Users and Privileges	|사용자 관리|


#### 🌸 ### 예시) 카페에서 고객이 메뉴를 주문하고 결제하는 시스템을 만드는 경우

##### ✅ 개념적 모델링 :  
✔️ 목적: "어떤 업무 개념이 있는지?"를 파악  
✔️ 형태: 업무 중심 + 관계 위주  


- 주요 개체(엔티티) : 고객 (Customer), 메뉴 (Menu), 주문 (Order)  
- 관계(Relationship) : 고객은 주문을 한다,  주문은 메뉴를 포함한다  
  
##### ✅ 논리적 모델링  
✔️ 목적: 개념을 구조화(테이블 형태)  
✔️ 형태: 엔티티 → 테이블, 속성 → 컬럼    

  
- 고객 테이블 (Customer) : 고객 ID (PK), 이름, 전화번호
- 메뉴 테이블 (Menu) : 메뉴 ID (PK), 메뉴명, 가격
- 주문 테이블 (Order) : 주문 ID (PK), 고객 ID (FK), 주문 일시
- 주문 상세 테이블 (OrderItem) : 주문 ID (FK), 메뉴 ID (FK), 수량

##### ✅ 물리적 모델링  
✔️ 목적: 실제 DB에 맞게 구현(mysql8이면 이 버전에 맞게 구현)   
✔️ 형태: 성능, 저장 공간 크기, 타입 고려하여 데이터 타입 설정, 인덱스 추가, 제약조건 정의  


CREATE TABLE Customer (  
  customer_id INT AUTO_INCREMENT PRIMARY KEY,  
  name VARCHAR(50),  
  phone VARCHAR(20)  
);  
  
CREATE TABLE Menu (  
  menu_id INT AUTO_INCREMENT PRIMARY KEY,  
  name VARCHAR(100),  
  price DECIMAL(6,2)  
);  
  
CREATE TABLE Order (  
  order_id INT AUTO_INCREMENT PRIMARY KEY,  
  customer_id INT,  
  order_date DATETIME,  
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)  
);  
  
CREATE TABLE OrderItem (  
  order_id INT,  
  menu_id INT,  
  quantity INT,   
  PRIMARY KEY (order_id, menu_id),  
  FOREIGN KEY (order_id) REFERENCES `Order`(order_id),  
  FOREIGN KEY (menu_id) REFERENCES Menu(menu_id)  
);   





