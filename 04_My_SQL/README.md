# 04. SQL 고급-조인

## 둘 이상의 테이블을 연결해서 데이터를 조회하는 방식. 보통 테이블들이 **공통된 컬럼(예: ID, 회원번호 등)**을 기준으로 연결되어 있을 때 사용

| 조인 종류        | 설명                                                                |
| ------------ | ----------------------------------------------------------------- |
| `INNER JOIN` | 양쪽 테이블에 모두 존재하는 데이터만 조회                                           |
| `LEFT JOIN`  | 왼쪽 테이블의 모든 데이터를 가져오고, 오른쪽 테이블에 없으면 NULL                           |
| `RIGHT JOIN` | 오른쪽 테이블의 모든 데이터를 가져오고, 왼쪽 테이블에 없으면 NULL                           |
| `FULL JOIN`  | 두 테이블의 모든 데이터를 가져오며, 한 쪽에 없으면 NULL (MySQL은 직접 지원 X, `UNION`으로 구현) |
| `CROSS JOIN` | 곱집합 (모든 경우의 수 조합)                                                 |


## ✅ MySQL 제약조건 정리표
| 제약조건                    | 설명                                           | 예시 코드 예                                          |
| ----------------------- | -------------------------------------------- | ------------------------------------------------ |
| **`NOT NULL`**          | 해당 컬럼은 **절대 NULL 값이 들어올 수 없음**               | `name VARCHAR(20) NOT NULL`                      |
| **`UNIQUE`**            | **중복된 값 금지**, 모든 값이 유일해야 함                   | `email VARCHAR(100) UNIQUE`                      |
| **`PRIMARY KEY`**       | 각 레코드 식별용 **고유값**, `NOT NULL + UNIQUE` 성질 가짐 | `id INT PRIMARY KEY`                             |
| **`AUTO_INCREMENT`**    | 숫자 자동 증가 (주로 `PRIMARY KEY`에 사용)              | `id INT AUTO_INCREMENT PRIMARY KEY`              |
| **`DEFAULT`**           | 값이 없을 때 **기본값 자동 설정**                        | `status VARCHAR(10) DEFAULT 'active'`            |
| **`CHECK`**             | 조건을 만족해야 저장됨 (MySQL 8.0 이상에서 지원)             | `age INT CHECK (age >= 0 AND age <= 120)`        |
| **`FOREIGN KEY`**       | 다른 테이블의 `PRIMARY KEY`를 참조 → 테이블 간 관계 설정      | `FOREIGN KEY(userId) REFERENCES usertbl(userID)` |
| **복합키 (Composite Key)** | 여러 컬럼을 조합해서 기본키로 사용                          | `PRIMARY KEY (userId, prodName)`                 |
