

# 04. SQL 고급-조인
## ✅ 왜 JOIN을 써야 하는가?
## JOIN을 쓰는 이유는 한마디로 **“서로 다른 테이블에 있는 관련된 데이터를 함께 보기 위해서”**

#### 둘 이상의 테이블을 연결해서 데이터를 조회하는 방식. 보통 테이블들이 **공통된 컬럼(예: ID, 회원번호 등)**을 기준으로 연결되어 있을 때 사용
#### 주로 공통된 키(Primary key & Foreign key) 를 기준으로 데이터를 연결.

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

![Image](https://github.com/user-attachments/assets/c393900f-b2e0-46c1-99ca-e91937febaec)  
## 🔍테이블 예제
### 📄employees 테이블
| emp\_id | name    | dept\_id |
| ------- | ------- | -------- |
| 1       | Alice   | 10       |
| 2       | Bob     | 20       |
| 3       | Charlie | 10       |
| 4       | David   | NULL     |

### 📄departments 테이블
| dept\_id | dept\_name  |
| -------- | ----------- |
| 10       | HR          |
| 20       | Engineering |
| 30       | Marketing   |

### 📘 INNER JOIN 예제
```sql
SELECT e.emp_id, e.name, d.dept_name
FROM employees e
INNER JOIN departments d ON e.dept_id = d.dept_id;
```
#### 결과
| emp\_id | name    | dept\_name  |
| ------- | ------- | ----------- |
| 1       | Alice   | HR          |
| 2       | Bob     | Engineering |
| 3       | Charlie | HR          |

### 📘 LEFT JOIN 예제
```sql
SELECT e.emp_id, e.name, d.dept_name
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.dept_id;
```
#### 결과
| emp\_id | name    | dept\_name  |
| ------- | ------- | ----------- |
| 1       | Alice   | HR          |
| 2       | Bob     | Engineering |
| 3       | Charlie | HR          |
| 4       | David   | NULL        |
##### 📌 설명: employees 테이블의 모든 행이 출력되고, 일치하지 않는 부서는 NULL로 표시

#### 📘 RIGHT JOIN 예제
```sql
SELECT e.emp_id, e.name, d.dept_name
FROM employees e
RIGHT JOIN departments d ON e.dept_id = d.dept_id;
```
#### 결과
| emp\_id | name    | dept\_name  |
| ------- | ------- | ----------- |
| 1       | Alice   | HR          |
| 2       | Bob     | Engineering |
| 3       | Charlie | HR          |
| NULL    | NULL    | Marketing   |


#### 요약정리 
| 조인 종류           | 기준 테이블        | 결과                        |
| --------------- | ------------- | ------------------------- |
| INNER JOIN      | 양쪽            | 양쪽 테이블 모두에 있는 데이터만        |
| LEFT JOIN       | 왼쪽(employees) | 왼쪽 전체 + 오른쪽 일치하는 데이터      |
| RIGHT JOIN      | 오른쪽(depts)    | 오른쪽 전체 + 왼쪽 일치하는 데이터      |
| FULL OUTER JOIN | 양쪽            | 양쪽 전체 + NULL (MySQL은 미지원) |
| SELF JOIN       | 자기자신          | 같은 테이블 내 연결               |
| CROSS JOIN      | 둘 다           | 두 테이블의 모든 조합 (곱집합)        |
  
#### 셀프/크로스
| JOIN 종류        | 설명                | 적절한 테이블 조건                              |
| -------------- | ----------------- | --------------------------------------- |
| **SELF JOIN**  | 자기 테이블 내부에서 관계 연결 | **상하 관계**, 자기 참조 컬럼 필요 (예: manager\_id) |
| **CROSS JOIN** | 두 테이블의 모든 조합 반환   | **서로 아무 관계가 없어도 됨**                     |


## ✅ 1. SELF JOIN (자기자신 조인)
### 🔹 개념
자기 테이블 안에서 행 간 관계가 있는 경우 자기 자신을 조인.  
예: 직원 테이블에서 "상사-부하" 관계.  
#### 📄 예제 테이블: employees
| emp\_id | name    | manager\_id |
| ------- | ------- | ----------- |
| 1       | Alice   | NULL        |
| 2       | Bob     | 1           |
| 3       | Charlie | 1           |
| 4       | David   | 2           |

#### 📘 SELF JOIN SQL 예제
```sql
SELECT 
  e.emp_id AS employee_id,
  e.name AS employee_name,
  m.name AS manager_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;
```
#### 결과
| employee\_id | employee\_name | manager\_name |
| ------------ | -------------- | ------------- |
| 1            | Alice          | NULL          |
| 2            | Bob            | Alice         |
| 3            | Charlie        | Alice         |
| 4            | David          | Bob           |
##### 📌 설명: employees 테이블을 두 번 사용하여 manager_id와 emp_id를 비교

## ✅ 2. CROSS JOIN (카티션 곱)
### 🔹 개념
#### 두 테이블의 모든 조합을 반환합니다. 조인 조건이 필요 없음

#### 📄 예제 테이블
#### 📄 colors
| color\_id | color |
| --------- | ----- |
| 1         | Red   |
| 2         | Blue  |

#### 📄 sizes
| size\_id | size   |
| -------- | ------ |
| A        | Small  |
| B        | Medium |

#### 📘 CROSS JOIN SQL 예제
SELECT c.color, s.size
FROM colors c
CROSS JOIN sizes s;

#### 결과
| color | size   |
| ----- | ------ |
| Red   | Small  |
| Red   | Medium |
| Blue  | Small  |
| Blue  | Medium |

#### 📌 설명: 2 * 2 = 4개의 모든 조합이 출력
보통 상품 옵션 조합(색상 + 사이즈) 같은 경우에 사용
