## 1. 프로젝트 개요
- 관광지 정보를 담고 있는 travel.csv 파일을 데이터베이스로 임포트
- 각 관광지의 이미지 파일 정보를 데이터베이스로 임포트  
  - travel-image 폴더에 준비됨  
  - 파일명: 관광지no-순번.jpg  
  - 예: 007-4.jpg

## 2. 다음과 같이 프로젝트를 만드세요.
- 프로젝트: travelapp
- 빌드툴: Gradle
- 기존 프로젝트에서 파일 복사  
  - org.scoula.database.JDBCUtil.java  
  - resources/application.properties
- 의존성 설정  
  - opencsv  
  - mysql-connector-j  
  - lombok

## 3. travel.csv 파일을 읽어 다음과 같이 출력하는 클래스를 정의하세요.
- 정의 클래스: org.scoula.CSVTest1.java

## 4. travel.csv를 읽어 TravelVO 객체로 변환하여 다음과 같이 출력하세요.
- 정의 클래스:  
  - org.scoula.travel.domain.TravelVO.java  
  - org.scoula.CSVTest2.java

## 5. travel.csv 파일을 데이터베이스로 임포트하기 위한 테이블을 정의하세요.
- 관광지 정보를 위한 테이블: tbl_travel
- 관광지 이미지 파일을 위한 테이블: tbl_travel_image

## 6. TravelDao 인터페이스와 구현체 TravelDaoImpl을 정의하세요.
- void insert(TravelVO travel);  
  - TravelVO를 테이블에 저장한다.
- void insertImage(TravelImageVO image);  
  - TravelImageVO를 테이블에 저장한다.

## 7. TravelDao를 이용하여 travel.csv에 있는 데이터를 tbl_travel에 저장하세요.
- 정의 클래스: org.scoula.travel.dataimport.ImportTravelData.java

## 8. TravelDao를 이용하여 관광지 이미지 정보를 tbl_travel_image에 저장하세요.
- 정의 클래스: org.scoula.travel.dataimport.ImportImageData.java

## 9. TravelDao에 다음 기능을 추가하고 구현하세요.
- 전체 데이터 건수 얻기
- 권역 목록 얻기
- 전체 목록 얻기
- 페이지별 목록 얻기
- 특정 권역의 목록 얻기
- 관광지 정보 하나 얻기  
  - Join을 이용해서 해당 이미지 정보를 같이 추출하기  
  - Optional로 리턴하기
