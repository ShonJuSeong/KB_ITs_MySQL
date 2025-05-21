# 6. 인덱스, 사용자 관리
### 📌 1. 인덱스란?
#### ● 사전적 정의:
##### 인덱스는 데이터베이스 테이블에서 데이터 검색 속도를 높이기 위해 사용하는 자료구조
#### ● 비유:
##### 책의 목차(Index) → 어떤 페이지에 내용이 있는지 빠르게 찾을 수 있음
##### DB의 인덱스 → 어떤 행(row)이 어느 위치에 있는지 빠르게 찾아줌

#### ● 인덱스가 없을 때  
SELECT * FROM employees WHERE emp_no = 10001;  
테이블 전체를 처음부터 끝까지 하나씩 확인함 → Full Table Scan  
데이터가 수백만 건이라면 매우 느림   


| 인덱스 종류                            | 중복 허용  | 특징 및 용도                                                   | 예시 쿼리                                                     |
| --------------------------------- | ------ | --------------------------------------------------------- | --------------------------------------------------------- |
| 🔹 **기본 인덱스** (Basic, Non-Unique) | O      | - 일반적인 인덱스<br>- 자주 조회되는 열에 사용                             | `CREATE INDEX idx_name ON employees(name);`               |
| 🔹 **고유 인덱스** (UNIQUE)            | ✕      | - 중복값 허용 안 함<br>- 이메일, 주민번호 등에 사용                         | `CREATE UNIQUE INDEX idx_email ON users(email);`          |
| 🔹 **기본키 인덱스** (PRIMARY KEY)      | ✕      | - 테이블에 1개만 존재<br>- 자동으로 UNIQUE + NOT NULL 포함              | `id INT PRIMARY KEY` (테이블 생성 시 자동)                        |
| 🔹 **복합 인덱스** (Composite)         | O 또는 ✕ | - 여러 열을 조합하여 인덱스 생성<br>- 다중 조건 검색 시 유리<br>- **순서 중요**     | `CREATE INDEX idx_name_dept ON employees(name, dept_id);` |
| 🔹 **클러스터형 인덱스** (Clustered)      | ✕      | - **실제 데이터가 인덱스 순서대로 저장됨**<br>- MySQL InnoDB에서 기본키가 해당됨   | (별도 작성 안 함, PRIMARY KEY 자동 적용됨)                           |
| 🔹 **비클러스터형 인덱스** (Non-clustered) | O      | - 인덱스는 따로, 데이터는 따로 저장<br>- 보조 인덱스                         | `CREATE INDEX idx_salary ON employees(salary);`           |
| 🔹 **전체 텍스트 인덱스** (FULLTEXT)      | O      | - 긴 텍스트에서 **검색어 기반 조회**용<br>- 뉴스/게시글 제목 등                 | `CREATE FULLTEXT INDEX idx_title ON articles(title);`     |
| 🔹 **공간 인덱스** (SPATIAL)           | O      | - 좌표, 위치정보(GIS 데이터) 검색용<br>- `GEOMETRY`, `POINT` 등 자료형 전용 | `CREATE SPATIAL INDEX idx_location ON maps(loc);`         |
