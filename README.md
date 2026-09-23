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

---

### 💬 느낀점

처음 다뤄보는 Spring Boot와 VS Code의 확장 환경이 익숙지 않았지만, Spring Initializr를 통해 복잡한 XML 설정 없이 손쉽게 웹 프로젝트 생태계를 구축할 수 있어 흥미로웠습니다. 특히 DispatcherServlet과 Thymeleaf가 연동되어 컨트롤러에서 전달한 데이터가 HTML에 동적으로 렌더링되는 과정을 직접 확인하며 웹 MVC 아키텍처의 흐름을 명확하게 이해할 수 있었습니다.

<img width="559" height="243" alt="image" src="https://github.com/user-attachments/assets/4d6a7b90-6fc6-442b-a4b4-d2b2d466fda5" />\
<img width="566" height="264" alt="image" src="https://github.com/user-attachments/assets/1feb1dfd-31db-412b-9aa6-fb342180e3b1" />
<img width="569" height="449" alt="image" src="https://github.com/user-attachments/assets/001071ef-98b3-4961-a44b-5ae382fbbebb" />

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

---

### 💬 느낀점



<img src="https://github.com/user-attachments/assets/919d250e-3d72-43cd-82ed-90fad87874e0" width="700" alt="Lighthouse 성능 측정 결과 1" />
<br><br>
<img src="https://github.com/user-attachments/assets/36e09ffc-c53a-4f7c-a4c3-9f736c9b083f" width="700" alt="Lighthouse 성능 측정 결과 2" />

