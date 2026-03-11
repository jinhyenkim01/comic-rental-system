# 만화책 대여 관리 시스템

Java와 MySQL을 사용한 콘솔 기반 만화책 대여 관리 시스템입니다.

## 프로젝트 개요

이 프로젝트는 다음과 같은 기능을 제공합니다:
- 만화책 등록, 조회, 수정, 삭제 (CRUD)
- 회원 등록 및 관리
- 만화책 대여/반납 시스템
- 대여 기록 조회

## 기술 스택

- **언어**: Java 17+
- **데이터베이스**: MySQL 8.0
- **JDBC**: MySQL Connector/J
- **빌드 도구**: Maven

## 실행 방법

### 사전 준비사항

- Java 17 이상 설치
- MySQL 8.0 이상 설치 및 실행

### 데이터베이스 설정

1. MySQL에 접속하여 스키마 생성:
   ```sql
   source schema.sql
   ```

2. `db.properties` 파일에서 DB 연결 정보를 본인 환경에 맞게 수정:
   ```properties
   db.url=jdbc:mysql://localhost:3306/comic_rental?serverTimezone=UTC&characterEncoding=UTF-8
   db.username=root
   db.password=your_password_here
   ```

### 빌드 및 실행

```bash
mvn compile exec:java
```

## 데이터베이스 구조

### comic 테이블 (만화책)
- `id`: 만화책 ID (Primary Key, Auto Increment)
- `title`: 제목
- `volume`: 권수
- `author`: 작가
- `is_rented`: 대여 중 여부
- `reg_date`: 등록일

### member 테이블 (회원)
- `id`: 회원 ID (Primary Key, Auto Increment)
- `name`: 이름
- `phone`: 전화번호
- `reg_date`: 등록일

### rental 테이블 (대여 기록)
- `id`: 대여 ID (Primary Key, Auto Increment)
- `comic_id`: 만화책 ID (Foreign Key)
- `member_id`: 회원 ID (Foreign Key)
- `rental_date`: 대여일
- `return_date`: 반납일

## 라이선스

이 프로젝트는 교육용으로 제작되었습니다.

---

**개발 팀**: aibe5_Team2
**개발 기간**: 2024.03
