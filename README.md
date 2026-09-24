# 🚀 Spring Boot 개발환경 설정 및 테스트

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![VS Code](https://img.shields.io/badge/VS_Code-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 👤 작성자 정보

* **학번:** `20231018`
* **이름:** `이환희`

---

## 📅 주차별 수업 및 실습 내용

### 📌 2주차: Spring Boot 개발 환경 구축 및 기초 URL 매핑

#### 🛠️ 실습 내용

1. **웹 트렌드 분석 및 프레임워크 이해**
   * **Spring Boot의 등장:** 기존 Spring Framework(2004년)의 높은 XML 설정 장벽을 개선하여 자동 환경 설정 및 단순 서블릿 관리 기능 제공 (2014년 등장)
   * **전자정부 표준프레임워크(eGov):** 국내 공공기관 주요 프레임워크로, 최근 5.x 버전부터 Spring Boot 지원 시작
   * **개발 환경:** 기존 Eclipse/IntelliJ 대신 **VS Code** 기반으로 개발 환경 구성

2. **VS Code 기반 Spring Boot 개발 환경 설정**
   * **JDK 설치:** Java 25 LTS (최소 Java 17 이상 권장) 설치 및 `settings.json` 환경변수(`java.jdt.ls.java.home`) 경로 추가
   * **VS Code 필수 확장 모듈:** `Extension Pack for Java`, `Spring Boot Extension Pack` 설치
   * **Spring Initializr 프로젝트 생성:** `Ctrl` + `Shift` + `P` ➡️ Spring Maven Project 생성 (Java, Jar, Spring Boot 3.3.x)
   * **의존성(Dependencies) 추가:** `Spring Boot DevTools`, `Lombok`, `Spring Web`, `Spring Web Services`, `Thymeleaf`, `Spring Data JPA`, `MySQL Driver`

3. **스프링 부트 동작 구조 및 메인 페이지 실행**
   * **서버 및 아키텍처:** 내장 톰캣(Apache Tomcat, 8080 포트) 기반 실행 및 `DispatcherServlet`(Front Controller)을 통한 요청/응답 처리
   * **MVC 패턴 적용:** Controller(흐름 제어) ↔ Model(데이터 전달) ↔ View(Thymeleaf 템플릿 엔진 렌더링)
   * **기본 화면 구동:** `src/main/resources/templates/index.html` 생성 후 localhost:8080 메인 페이지 호출 확인

4. **URL 매핑 및 Controller/Thymeleaf 연동**
   * **`DemoController.java` 작성:** `@Controller`, `@GetMapping("/hello")` 어노테이션을 이용해 URL 경로 매핑 및 `Model` 객체로 데이터 전달 (`model.addAttribute("data", "반갑습니다.")`)
   * **`hello.html` 작성:** Thymeleaf 문법 `<p th:text="${data}"></p>` 사용을 통한 동적 데이터 바인딩 테스트

#### ✏️ [과제 실습] 4개 기술 영역 완성 및 상세 페이지 구현
`/hello2` 매핑 추가:** 컨트롤러에 5개 속성 변수 추가 및 `hello2.html`을 통한 화면 출력 완료

### 💬 느낀점

처음 다뤄보는 Spring Boot와 VS Code의 확장 환경이 익숙지 않았지만, Spring Initializr를 통해 복잡한 XML 설정 없이 손쉽게 웹 프로젝트 생태계를 구축할 수 있어 흥미로웠습니다. 특히 DispatcherServlet과 Thymeleaf가 연동되어 컨트롤러에서 전달한 데이터가 HTML에 동적으로 렌더링되는 과정을 직접 확인하며 웹 MVC 아키텍처의 흐름을 명확하게 이해할 수 있었습니다.

<img width="559" height="243" alt="image" src="https://github.com/user-attachments/assets/4d6a7b90-6fc6-442b-a4b4-d2b2d466fda5" />\
<hr />
<img width="566" height="264" alt="image" src="https://github.com/user-attachments/assets/1feb1dfd-31db-412b-9aa6-fb342180e3b1" />
<hr />
<img width="569" height="449" alt="image" src="https://github.com/user-attachments/assets/001071ef-98b3-4961-a44b-5ae382fbbebb" />

<hr />

### 📌 3주차: Spring Boot 기반 개인 포트폴리오(프론트엔드) 구축

#### 🛠️ 실습 내용

1. **웹 트렌드 분석 및 프레임워크 이해**
   * **웹 호스팅 및 견적 분석:** 일반 웹 호스팅(카페24, 아임웹 등)과 맞춤형 VPS/클라우드 호스팅의 차이 이해 및 고객 요구사항별 최적 호스팅 환경 파악
   * **스프링 부트 기술 스택 적합성:** 맞춤형 웹 서비스 개발 및 VPS/클라우드 환경(예: Cafe24 VPS, Java 21, Spring Boot 3.5 기준)에서의 스프링 부트 구조(MVC 및 API 방식) 및 Tomcat WAS/MySQL 연동 구조 이해

2. **개인 포트폴리오 템플릿(Bootstrap 5) 이식**
   * **템플릿 다운로드 및 설정:** TemplateMo 578 (`First Portfolio`, Bootstrap 5 기반 원페이지 템플릿) 활용
   * **정적 자원 및 템플릿 정렬:** `index.html`은 `src/main/resources/templates/` 경로로 이동하고, 정적 자원(`css/`, `js/`, `images/`, `fonts/`)은 `src/main/resources/static/` 하위로 구조화
   * **Thymeleaf URL 매핑 적용:** `index.html` 상단에 `<html xmlns:th="http://www.thymeleaf.org">` 선언 및 상대경로 자원들을 Thymeleaf 문법(`th:href="@{/...}"`, `th:src="@{/...}"`)으로 전환

3. **프로필 수정 및 접근성/버그 개선**
   * **네비게이션 메뉴 한글화:** 네비바 항목(홈페이지, 소개, 기술, 프로젝트, 연락처) 한글화 및 CSS 수정(`--menu-font-size` 조정)을 통한 가시성 확보
   * **HTML 접근성 및 버그 수정:** 개발자 도구(F12)를 통해 Form 요소의 `<label for="...">`와 `<input id="...">` 불일치 버그를 수정하여 스크린 리더 접근성 및 입력창 포커싱 개선
   * **프로필 섹션 커스텀:** Hero 섹션 내 프로필 이미지(`profile.png`) 교체 및 개인 소개 키워드 설정

4. **기술/경험(Services) 섹션 및 정적 상세 페이지 구현**
   * **기술 분야 재구성:** 4가지 관심 분야(웹, AI, 보안, 게임 등)로 세부 영역 재구성 및 Bootstrap Icons(CDN/최신 아이콘 코드)을 통한 시각화
   * **정적 상세 페이지 추가:** 컨트롤러 연동 없이 바로 접근 가능한 `src/main/resources/public/` 경로에 정적 파일(`detailed_web.html` 등)을 생성하여 서비스 상세 연결 구현
   * **외부 링크 보안 처리:** Target 백링크 사용 시 `target="_blank" rel="noopener noreferrer"` 속성을 추가하여 피싱 예방 및 보안 강화

#### ✏️ [과제 실습] 4개 기술 영역 완성 및 상세 페이지 구현
* **기술/경험 아이콘 및 내용 완성:** 웹, AI, 보안, 게임 등 4개 영역의 아이콘 및 설명글 업데이트
* **세부 페이지 추가:** `detailed_web.html`을 참고하여 상세 페이지 작성 및 연동 링크 구축

### 💬 느낀점

<div align="center">
<p>
  <img src="https://github.com/user-attachments/assets/919d250e-3d72-43cd-82ed-90fad87874e0" width="600" alt="Lighthouse 성능 측정 결과 1" />
</p>
<p>
  <img src="https://github.com/user-attachments/assets/36e09ffc-c53a-4f7c-a4c3-9f736c9b083f" width="600" alt="Lighthouse 성능 측정 결과 2" />
</p>
<hr />
<p>
  <img src="https://github.com/user-attachments/assets/599d07a8-efcb-4bb8-ac40-07bd3a51213e" width="800" alt="분석 결과 1" /><br />
  <img src="https://github.com/user-attachments/assets/b9a27816-0476-4030-95ec-26965af8cab2" width="800" alt="분석 결과 2" /><br />
  <img src="https://github.com/user-attachments/assets/7143043c-6440-4f0a-8dbf-79b4a3ec1a55" width="800" alt="분석 결과 3" /><br />
  <img src="https://github.com/user-attachments/assets/d45ef1ee-9025-4558-ad9e-4b2d824414dd" width="800" alt="분석 결과 4" />
</p>

</div>

<hr />

### 📌 4주차: Spring Boot 데이터베이스 연동 및 테스트

#### 🛠️ 실습 내용

1. **MySQL 데이터베이스 및 JPA 이해**
   * **데이터베이스 트렌드 분석:** Oracle, MySQL과 같은 관계형 데이터베이스(RDB)가 여전히 널리 사용되고 있으며, PostgreSQL, MariaDB, SQLite 등의 오픈소스 DBMS도 함께 활용되고 있음을 학습
   * **MySQL 이해:** 오픈소스 기반의 관계형 데이터베이스로 게시판, 블로그, CMS 등 다양한 웹 서비스에서 활용되는 MySQL의 특징과 활용 분야를 학습
   * **JPA(Java Persistence API):** 객체지향 프로그래밍의 객체와 데이터베이스 테이블을 매핑하는 ORM 기술로, SQL을 직접 작성하지 않고 Java 코드와 메서드를 통해 데이터의 조회·수정·생성·삭제가 가능함을 학습
   * **Hibernate:** JPA의 대표적인 구현체로 데이터베이스와 객체 사이의 매핑 및 영속성 관리를 담당하는 구조를 이해

2. **Spring Boot와 MySQL 데이터베이스 연동**
   * **MySQL 설치 및 데이터베이스 생성:** MySQL Server를 설치하고 `root` 계정을 설정한 후 `spring` 데이터베이스를 생성
   * **MySQL Connector 설정:** `pom.xml`에서 `mysql-connector-j` 의존성을 확인하고 Spring Boot 프로젝트에서 MySQL에 접근할 수 있도록 설정
   * **데이터베이스 접속 정보 설정:** `application.properties`에 데이터베이스 URL, 사용자 계정, 비밀번호, JDBC 드라이버 및 JPA 관련 설정을 추가
   * **데이터베이스 연결 확인:** Spring Boot 프로젝트 실행 후 HikariPool의 연결 완료 메시지를 확인하여 MySQL과 정상적으로 연결되는지 테스트
   * **VS Code MySQL 확장 활용:** VS Code의 데이터베이스 확장 기능을 사용하여 `spring` 데이터베이스에 직접 접속하고 테이블과 데이터를 확인

3. **Spring Boot 프로젝트 계층 구조 분리**
   * 기존 하나의 폴더에서 동작하던 프로젝트를 기능과 역할에 따라 여러 계층으로 분리
   * **Domain(Model):** 데이터베이스 테이블과 매핑되는 엔티티 객체를 관리
   * **Controller:** 사용자의 요청을 받아 처리하고 결과를 반환하는 흐름을 담당
   * **Service:** 데이터 가공 및 주요 비즈니스 로직을 처리
   * **Repository:** 데이터베이스에 접근하고 데이터를 조회·저장하는 기능을 담당
   * **View:** 기존 `templates` 폴더를 유지하여 사용자에게 화면을 출력
   * 계층별 역할을 분리하여 코드의 관리와 유지보수가 용이하도록 프로젝트 구조를 변경

4. **JPA를 활용한 데이터베이스 테스트 페이지 구현**
   * `TestDB.java` 엔티티 클래스를 생성하고 `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column` 등의 JPA 어노테이션을 사용하여 데이터베이스 테이블과 Java 객체를 연결
   * `TestRepository.java`에서 `JpaRepository`를 상속하여 데이터베이스 제어 기능을 구현
   * `TestService.java`에서 Repository와 연동하여 이름으로 데이터를 조회하는 서비스 로직을 작성
   * Controller에서 `/testdb` URL을 매핑하고 Service를 통해 조회한 데이터를 Model에 전달
   * Thymeleaf 기반 `testdb.html`에서 전달받은 데이터의 ID와 이름을 화면에 출력하여 데이터베이스 연동을 확인

5. **데이터 추가 및 다수 사용자 출력 테스트**
   * VS Code의 MySQL 확장 기능을 이용하여 `testdb` 테이블에 사용자 데이터를 직접 INSERT
   * Spring Boot의 `/testdb` 페이지에서 데이터베이스에 저장된 사용자 정보를 조회하여 정상적으로 출력되는지 확인
   * `JpaRepository`에서 제공하는 `findAll()`, `findById()`, `save()`, `deleteById()`, `count()` 등의 메서드를 학습하여 데이터베이스의 기본적인 CRUD 작업 방식을 이해
   * Thymeleaf의 `th:each` 문법을 활용하여 데이터베이스에서 조회한 여러 사용자를 반복 출력하는 기능을 구현

#### ✏️ [과제 실습] 사용자 정보 수정 및 출력하기

* 기존 `TestDB` 엔티티에 나이와 성별 컬럼을 추가하여 데이터베이스 구조 확장
* MySQL 확장 기능을 활용하여 각 사용자의 정보를 직접 추가
* `INSERT` 문을 활용하여 데이터베이스에 사용자 정보를 저장
* `testdb.html`을 수정하여 추가된 사용자 정보를 웹 화면에 출력


