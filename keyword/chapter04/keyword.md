## 1. 의존성 주입 (Dependency Injection, DI)

<blockquote>
<h2>의존성 주입</h2>
<ul>
    <li>클래스 컴포넌트 간의 의존성을 관리하는 개념</li>
    <li>클래스가 스스로 필요한 의존성을 생성하는 대신 외부에서 해당 의존성을 주입</li>
    <li>컴포넌트 간 결합도를 낮추고 모듈화 가능</li>
</ul>

<h2>DI 유형</h2>
<ul>
    <li>생성자 주입</li>
    <li>setter 주입</li>
    <li>필드 주입</li>
</ul>

<h2>장점</h2>
<ul>
    <li>모듈화 향상 &rightarrow; 객체 재사용성 증가</li>
    <li>테스트 및 유지보수 향상</li>
    <li>단위 테스트가 용이</li>
</ul>
</blockquote>

## 2. 제어의 역전 (Inversion of Control, IoC)

<blockquote>
<h2>IoC</h2>
▶️Inversion of Controll의 약자로 주도권이 스프링에 있다는 의미
<h3>주도권이란?</h3>
<h4>1. 개발자에게 주도권</h4>
<ul>
    <li>new 예약어를 사용해 인스턴스를 직접 생성 &rightarrow; Heap 메모리 영역에 올라감</li>
    <li>이런 방식으로 선언하면 호출 메서드 이외에 다른 메서드는 사용 불가</li>
</ul>
<h4>2. 스프링에게 주도권</h4>
<ul>
    <li>new 연산자 없이 스프링이 미리 객체들을 Heap 메모리 영역에 올려둠</li>
    <li>스프링이 객체들을 관리</li>
    <li>모든 메서드에서 이 객체를 사용 가능 &Rightarrow; 싱글톤</li>
</ul>

<h2>IoC 컨테이너</h2>
▶️스프링 프레임워크에서 객체를 생성, 관리, 책임지며 의존성을 관리하는 컨테이너
<h3> IoC 컨테이너 종류</h3>
<ul>
    <li>BeanFactory</li>
        <ul>
            <li>Bean을 생성하고 의존관계를 설정하는 등의 기능을 담당</li>
            <li>Lazy-loading 방식을 사용하여 Bean 사용 시 Bean을 로딩</li>
        </ul>
    <li>ApplicationContext</li>
        <ul>
            <li>BeanFactory 확장 버전</li>
            <li>Eager-loading 방식을 사용하여 실행 시 모든 Bean을 미리 로딩</li>
        </ul>
</ul>
</blockquote>

## 3. 프레임워크와 API의 차이
<blockquote>
<h2>프레임워크</h2>
<ul>
    <li>특정 기능을 수행하기 위해 필요한 클래스나 인터페이스 등을 모아둔 집합체</li>
    <li>프레임워크는 제어 흐름에 대한 주도권을 프레임워크가 갖음</li>
    <li>전체 애플리케이션의 구조를 정의하여 일정한 개발 패턴을 따르게 함</li>
</ul>
<h2>API</h2>
▶️Application Programming Interface
<ul>
    <li>한 프로그램에서 다른 프로그램으로 데이터를 주고 받기 위한 방법</li>
    <li>소프트웨어들이 서로 대화할 때 사용되는 수단</li>
    <li>소프트웨어 애플리케이션이 서로 통신할 수 있도록 하는 일련의 규칙 또는 프로토콜</li>
</ul>
<h2>차이점</h2>
<ul>
    <li>흐름을 제어하는 주체가 다름</li>
    <li>프레임워크는 코드 구조를 강제하지만 API는 단순히 기능을 제공하는 도구</li>
</ul>
</blockquote>

## 4. 관점 지향 프로그래밍 (Aspect-Oriented Programming, AOP)
<blockquote>
<h2>관점 지향 프로그래밍</h2>
▶️코드의 핵심 로직과 공통적인 부가 기능을 분리하여 관리하는 프로그래밍 기법
<h2>주요 개념</h2>
<ul>
    <li>Aspect</li>
    <ul>
        <li>관심사를 모듈화한 단위</li>
        <li>실제 AOP의 핵심 기능 구현 ex) 로깅, 보안 기능 등</li>
    </ul>
    <li>Join Point</li>
    <ul>
        <li>Aspect가 적용될 수 있는 모든 위치</li>
        <li>메서드 호출, 예외 발생, 필드 접근 등 다양한 이벤트에 해당 가능</li>  
    </ul>
    <li>Advice</li>
    <ul>
        <li>실제로 수행할 작업을 정의한 코드</li>
        <li>AOP의 핵심 동작</li>
    </ul>
    <li>Pointcut</li>
    <ul>
        <li>Aspect를 적용할 위치를 지정하는 필터링 조건</li>
    </ul>
    <li>Weaving</li>
    <ul>
        <li>핵심 로직을 결합하는 과정</li>
        <li>컴파일 타임, 로드 타임, 런타임에 발생 가능</li>
        <li>AOP 프레임워크가 이 것을 자동으로 처리</li>
    </ul>
</ul>
<h2>장점</h2>
1. 코드 중복 감소
2. 가독성 및 유지보수성 증가
3. 모듈화가 가능하며 개발 유연성 증진

</blockquote>

## 5. 서블릿 (Servlet)

<blockquote>
<h2>서블릿</h2>
▶️Java 기반 웹 애플리케이션에서 요청을 처리하고 응답을 생성하는 서버 프로그램
<ul>
    <li>주로 HTTP 요청을 처리</li>
    <li>서버-클라이언트 간 데이터를 주고 받는 데 사용</li>
</ul>
<h2>생명 주기</h2>
<ul>
    <li>생성</li>
    <ul>
        <li>클라이언트 요청 발생 시 서블릿 컨테이너에 의해 생성</li>
        <li>서블릿 인스턴스는 최초 요청시 한 번만 생성</li>
    </ul>
    <li>초기화</li>
    <ul>  
        <li>init() 메서드 사용하며 생명 주기 중 한 번만 호출</li>
    </ul>
    <li>요청 처리</li>
    <ul>
        <li>요청 메서드에 따라 doGet(), doPost() 같은 메서드 호출</li>
    </ul>
    <li>종료</li>
    <ul>
        <li>서블릿이 더이상 필요하지 않으면 destory() 호출하고 메모리에서 해제</li>
    </ul>
</ul>
</blockquote>
