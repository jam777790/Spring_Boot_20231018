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

<img width="566" height="264" alt="image" src="https://github.com/user-attachments/assets/1feb1dfd-31db-412b-9aa6-fb342180e3b1" />

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

<img width="298" height="277" alt="image" src="https://github.com/user-attachments/assets/f6336856-d75e-4cb7-9ae0-0304158d3634" />
<img width="1263" height="271" alt="image" src="https://github.com/user-attachments/assets/8f5dfdde-1b1c-403f-b5b5-3a6f64c80e2f" />

---

# 📌 5주차: Spring Security 기반 로그인/로그아웃 및 비밀번호 암호화

## 🛠️ 실습 내용

### 1. 웹 보안 트렌드 및 인증/인가 이해

* **웹 보안 트렌드:** OWASP Top 10(2025) 기준 접근 제어 실패(A01) 및 인증 실패(A07)가 주요 보안 위험 항목. 해킹 공격의 주요 시작점인 로그인/인증 검사 강화 필요.
* **인증 vs 인가:** 인증(Authentication, "너 누구야?")은 사용자 신원 확인, 인가(Authorization, "너 이거 해도 돼?")는 권한(USER/ADMIN) 검증.
* **비밀번호 저장 및 암호화:** 개인정보 안전성 확보조치 기준에 따라 단방향 해시(BCrypt) 저장. BCrypt는 매번 무작위 Salt(22자)를 자동 생성하여 동일한 비밀번호도 항상 다른 해시 결과로 저장하여 대입 공격을 방지.
* **인증 방식의 변화:** 세션(Session, JSESSIONID 쿠키 기반) ➡️ 토큰(JWT) ➡️ 소셜 로그인(OAuth2) ➡️ 패스키(Passkey).

### 2. 의존성 모듈 추가 및 보안 필터 체인(SecurityFilterChain) 구조

* **의존성(Dependencies) 추가:** `pom.xml`에 `spring-boot-starter-security` 및 `thymeleaf-extras-springsecurity6` 추가.
* **필터 기반 보안:** DispatcherServlet/Controller 도달 전 `SecurityFilterChain` 내의 여러 보안 필터(`CsrfFilter`, `UsernamePasswordAuthenticationFilter`, `LogoutFilter`, `AuthorizationFilter` 등)를 순차 통과하여 인증 및 권한을 검사.

### 3. 스프링 시큐리티 설정 및 회원 관리 아키텍처 구축

* **`SecurityConfig.java` 작성:**
  * `@Bean` 등록으로 `BCryptPasswordEncoder` 암호화 객체 제공.
  * `authorizeHttpRequests`: `/`, `/login`, `/signup`, 정적 리소스(`/css/**`, `/js/**` 등)는 `permitAll()`, 그 외 요청(`anyRequest()`)은 `authenticated()` 지정.
  * `formLogin`: 사용자 정의 로그인 페이지(`/login`), 성공 시 기본 URL(`/`), 실패 시 URL(`/login?error`) 설정.
  * `logout`: `/logout` 요청 시 세션 무효화(`invalidateHttpSession`) 및 `JSESSIONID` 쿠키 삭제 처리.
* **도메인 및 데이터 전달 객체:**
  * `Member.java` (`@Entity`): PK 자동 증가(`@GeneratedValue`), `username` (unique, 필수), BCrypt 암호화 값 `password`, `name`, `role` 필드 구성.
  * `MemberForm.java` (DTO): 화면 input 이름과 바인딩되는 DTO로 엔티티 직접 노출 방지 및 권한 조작 차단.
* **리포지토리 & 서비스:**
  * `MemberRepository.java`: `findByUsername()`, `existsByUsername()` 메소드 선언.
  * `MemberService.java`: `UserDetailsService` 인터페이스 구현, `loadUserByUsername()`을 오버라이딩하여 시큐리티 인증 프로세스와 DB 회원 데이터 연결. 회원가입 시 아이디 중복 체크 및 `passwordEncoder.encode()`로 암호화 후 DB 저장.

### 4. 컨트롤러 및 Thymeleaf 연동 (UI/UX)

* **`MemberController.java` 작성:** `@GetMapping("/login")`, `@GetMapping("/signup")`, `@PostMapping("/signup")` 처리 구현.
* **Thymeleaf Security 태그 사용:**
  * `sec:authorize="isAnonymous()"`: 비로그인 상태 시 로그인 버튼 노출.
  * `sec:authorize="isAuthenticated()"` 및 `sec:authentication="name"`: 로그인 성공 시 사용자 아이디 및 로그아웃 버튼 노출.

---

#### ✏️ [과제 실습]  로그인 기능 개선 및 검증 로직 구현

* **로그인 상태 유지(`remember-me`) 기능 추가**
* **회원가입 비밀번호 확인 검증 로직 구현**

<img width="1918" height="1109" alt="image" src="https://github.com/user-attachments/assets/663bd851-76b8-4eae-875a-a3d965f72fd6" />
<img width="640" height="762" alt="image" src="https://github.com/user-attachments/assets/f4ae0ae0-99fd-4277-a784-bbcca905b74b" />
<img width="535" height="860" alt="image" src="https://github.com/user-attachments/assets/7bfe3850-ad75-444f-a650-d237f79c84ef" />
<img width="871" height="212" alt="image" src="https://github.com/user-attachments/assets/041cc66e-0334-4ae6-9b6d-90e26e7418b9" />

# 📌 6주차: Spring Security 기반 권한 관리 및 관리자 페이지 구현

## 🛠️ 실습 내용

### 1. 웹 보안 트렌드 및 접근 제어 이해

* **OWASP Top 10 - 접근 제어 실패(A01):** 로그인한 사용자라도 권한 검사를 누락하면 관리자 페이지 접근, 타인 정보 조회(IDOR), 권한 상승 등의 보안 문제가 발생할 수 있음.
* **인증(Authentication) vs 인가(Authorization):** 인증은 사용자의 신원을 확인하는 과정이며, 인가는 사용자의 역할과 권한에 따라 접근 가능 여부를 검사하는 과정.
* **권한 관리 모델(RBAC):** 역할(Role)을 기반으로 권한을 관리하는 방식으로, `USER`, `MANAGER`, `ADMIN` 등의 역할을 사용하여 접근 권한을 구분.
* **최소 권한 원칙(Least Privilege):** 사용자에게 업무 수행에 필요한 최소한의 권한만 부여하여 보안 사고 발생 시 피해를 최소화.
* **핵심 보안 원칙:** 화면에서 메뉴를 숨기는 것만으로는 보안이 보장되지 않으며, 실제 요청과 기능 실행 단계에서 권한을 검사해야 함.

### 2. Spring Security 권한 제어 구조

* **URL 기반 접근 제어:** `SecurityConfig.java`의 `authorizeHttpRequests()`와 `requestMatchers()`를 사용하여 URL별 접근 권한 설정.
    * `permitAll()`: 누구나 접근 가능.
    * `authenticated()`: 로그인한 사용자만 접근 가능.
    * `hasRole("ADMIN")`: 관리자 권한을 가진 사용자만 접근 가능.
* **메서드 기반 접근 제어:** `@PreAuthorize`를 사용하여 서비스 메서드 실행 직전에 권한 검사.
    * `@EnableMethodSecurity`를 설정 클래스에 추가해야 메서드 보안이 활성화됨.
    * 회원 권한 변경 및 삭제 기능을 관리자 전용으로 제한.
* **이중 보안 구조:** URL 기반 검사와 메서드 기반 검사를 함께 적용하여 URL 설정 오류나 새로운 API 추가 등으로 발생할 수 있는 보안 취약점을 방지.
* **ROLE과 Authority:** `.roles("ADMIN")`은 내부적으로 `ROLE_ADMIN` 권한으로 변환됨. 따라서 `hasRole("ADMIN")`처럼 `ROLE_` 접두사를 제외한 역할 이름을 사용.

### 3. 로그인 사용자 정보 및 마이페이지 구현

* **`MemberService.java`:**
    * `findByUsername()` 메서드를 추가하여 로그인한 사용자의 회원 정보를 조회.
    * `findAll()` 메서드를 추가하여 전체 회원 목록을 조회하고 ID 순서로 정렬.
* **`MemberController.java`:**
    * `@GetMapping("/mypage")`를 사용하여 마이페이지 구현.
    * `Principal` 객체의 `getName()`으로 현재 로그인한 사용자의 아이디를 가져와 회원 정보 조회.
    * URL에 회원 ID를 직접 입력받는 대신 로그인 정보를 사용하여 IDOR 취약점 방지.
* **Thymeleaf Security 태그:**
    * `sec:authorize="isAuthenticated()"`: 로그인한 사용자에게만 내 정보 메뉴 표시.
    * `sec:authorize="hasRole('ADMIN')"`: 관리자에게만 관리자 메뉴 표시.
    * `sec:authentication="name"`: 로그인한 사용자의 아이디 표시.
* **세션 권한 관리:** 데이터베이스에서 회원의 역할을 변경해도 이미 로그인한 세션의 권한은 즉시 바뀌지 않으므로, 변경된 권한을 적용하려면 다시 로그인해야 함.

### 4. 관리자 계정 및 회원 관리 기능 구현

* **관리자 계정 생성:**
    * 회원가입 화면에서 `admin` 계정을 정상적으로 생성.
    * SQL을 이용하여 해당 회원의 `role`을 `ADMIN`으로 변경.
    * 로그아웃 후 다시 로그인하여 관리자 권한 적용 여부 확인.
    * 비밀번호는 BCrypt로 암호화된 값을 사용해야 하므로, 평문 비밀번호를 직접 SQL로 저장하지 않음.
* **`AdminController.java`:**
    * `@RequestMapping("/admin")`을 사용하여 관리자 페이지 URL을 분리.
    * `@GetMapping("/members")`를 통해 `/admin/members`에서 전체 회원 목록 조회.
    * `@PostMapping("/members/{id}/role")`로 회원 권한 변경 처리.
    * `@PostMapping("/members/{id}/delete")`로 회원 삭제 처리.
* **`MemberService.java`의 회원 관리 로직:**
    * `changeRole()` 메서드로 회원 권한 변경.
    * `deleteMember()` 메서드로 회원 삭제.
    * `findById()`를 이용해 회원 존재 여부를 확인한 후 변경 또는 삭제 수행.
    * `save()`는 기존 ID가 있으면 수정하고, 새로운 ID라면 삽입하는 방식으로 동작.
* **권한 화이트리스트(Whitelist):** 허용된 역할을 `USER`, `ADMIN`으로 제한하여 개발자 도구 등을 통해 `MANAGER`와 같은 임의의 값을 전달해도 거부하도록 검증.
* **PRG 패턴(Post-Redirect-Get):** 처리 후 `redirect:/admin/members`로 이동하고 `RedirectAttributes`의 Flash 메시지를 사용하여 새로고침에 따른 중복 요청을 방지.

### 5. URL 및 메서드 기반 보안 적용과 검증

* **URL 접근 제어 설정:** `SecurityConfig.java`에서 `/admin/**` 경로를 관리자 전용으로 제한.

  ```java
  .requestMatchers("/admin/**").hasRole("ADMIN")
  .anyRequest().authenticated()
  ```

* **메서드 보안 적용:** `SecurityConfig.java`에 `@EnableMethodSecurity`를 추가하고, 회원 권한 변경 및 삭제 메서드에 `@PreAuthorize("hasRole('ADMIN')")` 적용.
* **접근 제어 3단계:**
    1. **화면 제어:** `sec:authorize`로 메뉴 표시 여부를 제어.
    2. **URL 제어:** `requestMatchers()`로 컨트롤러 접근을 차단.
    3. **메서드 제어:** `@PreAuthorize`로 핵심 서비스 로직 실행을 차단.
* **접근 결과 검증:**
    * 비로그인 사용자: 관리자 URL 접근 시 로그인 화면으로 리다이렉트(302).
    * `USER`: 관리자 페이지 접근 시 403 Forbidden 응답.
    * `ADMIN`: 관리자 페이지 접근 및 회원 관리 기능 사용 가능.
* **403 접근 거부 페이지:** `templates/error/403.html`을 생성하여 아이디, 권한, 요청 주소 등을 표시하는 접근 거부 화면 구현.
* **예외 상황 검증:** URL 규칙이 누락되더라도 메서드 보안이 회원 권한 변경 및 삭제를 차단하는지 확인.

---

#### ✏️ [과제 실습] 관리자 보호 및 MANAGER 권한 추가

* **관리자 본인 보호 기능 구현**
    * 관리자가 자기 자신의 권한을 `USER`로 변경하거나 계정을 삭제하지 못하도록 제한.
    * `SecurityContextHolder`에서 현재 로그인한 사용자의 아이디를 가져와 대상 회원과 비교.
    * 본인 권한 변경 또는 삭제 시 오류 메시지를 표시하고 작업을 거부.

* **MANAGER 권한 추가**
    * 회원 권한 변경 시 `MANAGER` 역할도 선택할 수 있도록 허용 목록 수정.
    * `/testdb` 경로를 `ADMIN`, `MANAGER`만 접근할 수 있도록 제한하고 `USER`는 접근할 수 없도록 설정.
    * `hasAnyRole("ADMIN", "MANAGER")`를 사용하여 여러 역할에 대한 접근 권한 설정.

* **추가 도전 과제**
    * 회원 목록 메뉴가 `USER`에게 표시되지 않도록 화면 권한 제어 적용.
    * 비로그인 사용자, `USER`, `MANAGER`, `ADMIN` 계정별로 URL 접근 및 기능 실행 결과 검증.

# 📌 7주차: REST API와 JSON 기반 회원 관리 기능 구현

## 🛠️ 실습 내용

### 1. 웹 개발 트렌드 및 REST API 이해

* **API(Application Programming Interface):** 프로그램끼리 데이터를 주고받기 위한 약속으로, 요청(Request)과 응답(Response)을 통해 데이터를 전달.
* **프론트엔드와 백엔드의 역할 분리:**
    * SSR(Server-Side Rendering): 서버가 Thymeleaf로 HTML을 완성하여 브라우저에 전달.
    * CSR(Client-Side Rendering): 백엔드는 JSON 데이터를 제공하고, 프론트엔드는 React, Vue 등의 기술로 화면을 구성.
    * 관리자 화면은 Thymeleaf를 사용하고, 모바일 앱 및 외부 서비스 연동은 REST API를 사용하는 방식으로 혼용 가능.
* **REST API:** 자원은 URL로 표현하고, 작업은 HTTP 메서드로 구분하는 API 설계 방식.
    * `GET`: 데이터 조회.
    * `POST`: 데이터 생성.
    * `PATCH`: 데이터 일부 수정.
    * `DELETE`: 데이터 삭제.
* **JSON(JavaScript Object Notation):** 서버와 클라이언트 사이에서 데이터를 전달하는 표준 형식.
    * `{}`: 객체.
    * `[]`: 배열.
    * 문자열, 숫자, 불리언(`true`, `false`), `null` 등의 값을 사용.
* **API 테스트 도구:** Postman, 브라우저 개발자 도구(F12), `curl` 등을 사용하여 요청과 응답 확인.

### 2. Spring Boot REST API 구현

* **`MemberApiController.java` 작성:**
    * `@RestController`: HTML 화면 이름 대신 객체나 데이터를 반환하는 컨트롤러.
    * `@RequestMapping("/api")`: 해당 컨트롤러의 모든 URL 앞에 `/api` 경로 적용.
    * `@GetMapping("/hello")`: 첫 번째 API인 `GET /api/hello` 구현.
* **JSON 자동 변환:** `Map<String, Object>` 등의 객체를 반환하면 Spring이 JSON 응답으로 변환.
* **첫 번째 API 테스트:** `/api/hello`에 접속하여 메시지와 현재 시간이 JSON 형식으로 출력되는지 확인.
* **공개 API 설정:** `SecurityConfig.java`에 `/api/hello`를 `permitAll()`로 설정하여 로그인하지 않아도 접근할 수 있도록 구성.

### 3. 응답 DTO를 이용한 개인정보 보호

* **문제점:** `Member` 엔티티를 그대로 반환하면 getter가 제공하는 필드가 JSON으로 노출되어 BCrypt 비밀번호 해시까지 응답에 포함될 수 있음.
* **응답 DTO(Response DTO):** 클라이언트에 전달할 데이터만 별도로 구성하여 불필요한 정보 노출을 방지.
* **`MemberResponse.java` 작성:**
    * `id`, `username`, `name`, `role` 필드만 포함.
    * `password` 필드는 제외.
    * `Member` 엔티티를 응답 DTO로 변환하는 `from()` 메서드 구현.
    * Java `record`를 사용하여 DTO 코드를 간결하게 작성.
* **DTO의 역할 구분:**
    * `Member`: 데이터베이스 저장용 엔티티.
    * `MemberForm`: 회원가입 등 클라이언트에서 서버로 전달하는 요청 DTO.
    * `MemberResponse`: 서버에서 클라이언트로 전달하는 응답 DTO.
* **내 정보 API 구현:** `GET /api/me`에서 `Principal`의 `getName()`으로 로그인한 사용자를 확인하고, `MemberResponse.from(member)`를 반환.
* **보안 핵심:** 데이터베이스 엔티티를 그대로 반환하지 않고 요청과 응답에 적합한 DTO를 각각 사용하여 권한 조작과 개인정보 노출을 방지.

### 4. Postman 테스트 및 API 인증 설정

* **Postman:** 브라우저 외부에서 서버에 직접 API 요청을 보내고, 응답 본문과 HTTP 상태 코드를 확인하는 도구.
* **세션 기반 인증의 한계:** 브라우저는 로그인 후 세션 쿠키를 자동으로 전송하지만, Postman은 별도로 인증 정보를 설정하지 않으면 로그인된 사용자로 인식되지 않음.
* **Basic 인증:** 요청마다 아이디와 비밀번호를 전달하여 사용자를 인증하는 방식.
    * `아이디:비밀번호` 문자열을 Base64로 인코딩하여 전달.
    * Base64는 암호화가 아니므로 실제 서비스에서는 반드시 HTTPS를 사용해야 함.
* **`SecurityConfig.java` 설정:**
    * `httpBasic(Customizer.withDefaults())`: Basic 인증 활성화.
    * `csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))`: 실습에서 JSON API 경로의 CSRF 검사를 제외.
    * `HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)`: 인증되지 않은 API 요청에 로그인 화면 리다이렉트 대신 401 응답 반환.
* **인증 테스트:**
    * 인증 정보 없음: `401 Unauthorized`.
    * 올바른 Basic 인증 정보: `200 OK`.
    * 잘못된 비밀번호: `401 Unauthorized`.
* **HTTP 상태 코드 구분:**
    * `302 Found`: 로그인 화면 등으로 리다이렉트.
    * `401 Unauthorized`: 인증 정보가 없거나 올바르지 않음.
    * `403 Forbidden`: 인증은 되었지만 접근 권한이 없음.

### 5. REST API 주소 설계 및 HTTP 상태 코드

* **REST 주소 설계:** URL은 자원을 나타내고, HTTP 메서드는 수행할 작업을 나타냄.

| 기능 | HTTP 메서드 | REST API 주소 |
|---|---|---|
| 회원 목록 조회 | GET | `/api/admin/members` |
| 회원 한 명 조회 | GET | `/api/admin/members/3` |
| 회원 등록 | POST | `/api/admin/members` |
| 회원 권한 변경 | PATCH | `/api/admin/members/3/role` |
| 회원 삭제 | DELETE | `/api/admin/members/3` |

* **주요 HTTP 상태 코드:**
    * `200 OK`: 조회 또는 수정 성공.
    * `201 Created`: 새로운 데이터 생성 성공.
    * `204 No Content`: 작업 성공, 응답 본문 없음.
    * `400 Bad Request`: 잘못된 요청, 중복 아이디 또는 허용되지 않는 권한.
    * `401 Unauthorized`: 인증 실패.
    * `403 Forbidden`: 권한 부족.
    * `404 Not Found`: 요청한 회원이나 자원이 존재하지 않음.
* **`ResponseEntity`:** 응답 본문과 HTTP 상태 코드를 직접 지정할 때 사용.
    * `ResponseEntity.ok(body)`: 200 응답.
    * `ResponseEntity.created(uri).body(body)`: 201 응답 및 `Location` 헤더 설정.
    * `ResponseEntity.noContent().build()`: 204 응답.
    * `ResponseEntity.badRequest().body(error)`: 400 응답.
    * `ResponseEntity.notFound().build()`: 404 응답.

### 6. 관리자 REST API 구현

* **`AdminApiController.java` 작성:**
    * `@RestController`와 `@RequestMapping("/api/admin/members")`를 사용하여 관리자 회원 관리 API 구성.
    * `GET /api/admin/members`: 전체 회원 조회.
    * `GET /api/admin/members/{id}`: 특정 회원 조회.
    * `POST /api/admin/members`: 회원 등록.
    * `PATCH /api/admin/members/{id}/role`: 회원 권한 변경.
    * `DELETE /api/admin/members/{id}`: 회원 삭제.
* **회원 목록 조회:** `MemberService.findAll()`로 조회한 엔티티 목록을 `MemberResponse` 목록으로 변환하여 반환.
* **회원 한 명 조회:** `Optional<Member>`와 `ResponseEntity`를 이용하여 회원이 존재하면 200, 존재하지 않으면 404 응답 반환.
* **회원 등록:**
    * `@RequestBody`를 사용하여 JSON 요청 본문을 `MemberForm` 객체로 변환.
    * 기존 `MemberService.signup()`을 재사용하여 회원가입 처리 및 BCrypt 비밀번호 암호화.
    * 등록 성공 시 201 응답과 `Location` 헤더 반환.
    * 중복 아이디나 필수 입력값 누락 시 400 응답 반환.
* **필수 입력값 검증:** API 요청에는 HTML의 `required` 검사가 자동 적용되지 않으므로 서비스에서 아이디, 비밀번호, 이름 등의 빈 값 검사 수행.
* **요청 DTO를 통한 권한 조작 방지:** `MemberForm`에 `role` 필드가 없으므로 요청 JSON에 `"role": "ADMIN"`을 추가하더라도 해당 값으로 권한을 지정할 수 없음.

### 7. 회원 권한 변경 및 삭제 API

* **`RoleRequest.java` 작성:** 권한 변경 요청 본문인 `{"role": "ADMIN"}`을 전달받는 DTO.
* **`MemberService.changeRole()` 수정:**
    * 반환형을 `void`에서 `Member`로 변경.
    * 권한 변경 후 `memberRepository.save(member)`의 결과를 반환하여 수정된 회원 정보를 응답에 활용.
* **회원 권한 변경:** `PATCH /api/admin/members/{id}/role` 요청으로 권한을 변경하고, 성공 시 변경된 회원 정보를 `MemberResponse`로 반환.
* **회원 삭제:** `DELETE /api/admin/members/{id}` 요청으로 회원을 삭제하고, 성공 시 204 응답 반환.
* **기존 보안 로직 재사용:**
    * `@PreAuthorize("hasRole('ADMIN')")`를 통한 관리자 권한 검사.
    * 허용된 역할만 지정할 수 있도록 화이트리스트 검증.
    * 관리자가 본인의 권한을 변경하거나 계정을 삭제하지 못하도록 본인 보호 로직 적용.
* **오류 응답:** 권한이 허용되지 않거나 회원이 존재하지 않는 경우 등 서비스 검증 과정에서 발생하는 `IllegalArgumentException`을 처리하여 400 응답과 오류 메시지 반환.
* **보안 규칙 추가:** `SecurityConfig.java`에서 `/admin/**`뿐 아니라 `/api/admin/**`에도 `hasRole("ADMIN")`을 적용하여 API 경로를 보호.

### 8. Postman 테스트 및 화면 연동

* **관리자 API 테스트:**
    * 관리자 계정으로 전체 회원 조회: 200.
    * 존재하는 회원 조회: 200.
    * 존재하지 않는 회원 조회: 404.
    * `USER` 계정으로 관리자 API 호출: 403.
    * 정상적인 회원 등록: 201.
    * 중복 아이디 또는 필수값 누락: 400.
    * 정상적인 권한 변경: 200.
    * 허용되지 않은 권한 변경: 400.
    * 관리자 본인의 권한 변경 시도: 400.
    * `USER` 계정의 회원 삭제 시도: 403.
    * 관리자 계정의 회원 삭제 성공: 204.
* **Thymeleaf 화면과 API 연동:**
    * `AdminController.java`에 `/admin/members-api` 경로를 추가하여 API를 사용하는 화면 연결.
    * `templates/admin/members-api.html`에서 `fetch`를 사용하여 서버 API 호출.
    * 회원 등록, 권한 변경, 삭제 등의 결과를 화면에 반영하며 페이지 전체 새로고침 없이 데이터 갱신.
* **인증 방식 비교:**
    * 브라우저의 `fetch`: 로그인 세션 쿠키를 사용.
    * Postman: Basic 인증 정보를 요청에 포함.
    * 서로 다른 인증 방식을 사용해도 동일한 API와 서버의 보안 규칙을 적용받음.

---

#### ✏️ [과제 실습] 회원 검색 API 및 공통 오류 처리 구현

* **회원 검색 API 구현**
    * `GET /api/admin/members?keyword=student` 형태의 검색 API 구현.
    * 아이디 또는 이름에 검색어가 포함된 회원만 조회.
    * `@RequestParam(required = false)`로 선택적 검색어 전달.
    * `findBy...Containing...Or...Containing` 형태의 리포지토리 메서드를 활용하여 검색 기능 구현.
    * 제공된 회원 관리 화면의 검색창과 연동하여 검색 결과 확인.

* **공통 오류 처리 구현**
    * 회원 등록, 수정, 삭제 과정에서 반복되는 `try-catch` 코드를 개선.
    * `@RestControllerAdvice`를 사용하여 API의 오류 처리를 한곳으로 통합.
    * 공통 오류 처리 적용 전후의 응답 상태 코드와 오류 메시지가 동일하게 동작하는지 검증.

* **추가 확인 사항**
    * `/api/hello`부터 `/api/me`, 관리자 API까지 순서대로 테스트.
    * `USER`와 `ADMIN` 계정별 접근 권한 검증.
    * Postman의 요청 메서드, 인증 정보, JSON 본문 및 응답 상태 코드 확인.

