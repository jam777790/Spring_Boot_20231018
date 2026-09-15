# 🚀 Spring Boot 개발환경 설정 및 테스트

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![VS Code](https://img.shields.io/badge/VS_Code-007ACC?style=for-the-badge&logo=visualstudiocode&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 👤 작성자 정보

* **학번:** `학번을 입력하세요`
* **이름:** `이름을 입력하세요`

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
   * **[과제 실습] `/hello2` 매핑 추가:** 컨트롤러에 5개 속성 변수 추가 및 `hello2.html`을 통한 화면 출력 완료

---

### 💬 느낀점

처음 다뤄보는 Spring Boot와 VS Code의 확장 환경이 익숙지 않았지만, Spring Initializr를 통해 복잡한 XML 설정 없이 손쉽게 웹 프로젝트 생태계를 구축할 수 있어 흥미로웠습니다. 특히 DispatcherServlet과 Thymeleaf가 연동되어 컨트롤러에서 전달한 데이터가 HTML에 동적으로 렌더링되는 과정을 직접 확인하며 웹 MVC 아키텍처의 흐름을 명확하게 이해할 수 있었습니다.
