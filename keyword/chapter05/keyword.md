## Domain

▶️ 특정 시스템이 다루는 비즈니스 규칙, 데이터, 기능 등을 포함하는 개념

즉, 시스템이 다루는 비즈니스 문제 영역

ex) 쇼핑몰 → 고객, 상품, 주문 등…

금융 시스템 → 계좌, 거래, 고객 등…

### JPA에서 도메인

- JPA에서는 도메인을 표현하기 위해 도메인 엔티티 클래스 정의 (@Entity)
- 데이터베이스 테이블과 매핑되며, 특정 도메인에 해당하는 데이터와 비즈니스 로직을 캡슐화

### DB에서 도메인

- 각 속성들이 가질 수 있는 값의 모임
    
    ex) 성별 → 남성, 여성
    
    나라 → 대한민국, 미국, 중국, 일본
    
- 각 도메인은 테이블, 뷰, 인덱스, 제약조건 등의 구조로 설계됨

### 도메인의 중요성

- 시스템이 해결하려는 비즈니스 문제의 핵심이므로 정확한 설계가 중요
- 비즈니스 요구사항을 잘 반영해야 이후 유지보수 및 기능 확장에 용이
- 데이터 무결성을 유지하는데 중요함



## 연관관계 매핑

### ▶️ 두 객체가 서로 참조해야 하는 상황에서 정의하는 연관관계 방식

- 양방향 관계는 단방향 관계 2개를 맺은 것
    
    → 실제로 양방향 연관관계는 없음, 단지 양방향인 것 처럼 보이게 한 것
    
- 양방향 객체 둘 중 하나는 반드시 외래 키를 관리해야 함

### MappedBy

- 양방향 매핑을 할 때에는 반드시 한쪽 객체에 MappedBy 옵션을 설정해야 함

```java
@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
@Builder.Default
    private List<Review> reviewList = new ArrayList<>();
```

### 연관관계 주인

- 객체의 두 관계 중 하나를 연관관계의 주인으로 지정해야 함
- 연관관계 주인만 외래 키를 관리해야 함
- 주인은 mappedBy 속성을 사용하지 않음
- 주인이 아니면 mappedBy 속성으로 주인을 지정
    
    #### 주인 정하기

    - 외래 키가 있는 곳을 주인으로 정함
    - N : 1 관계일 경우 N에 해당하는 쪽에 외래 키가 존재 (N이 주인)
        
        → @ManyToOne 어노테이션을 사용하는 클래스가 주인
        

## N+1 문제
### ▶️ 연관 관계가 설정된 엔티티를 조회할 경우에 조회된 데이터 개수(N) 만큼 연관관계의 조회 쿼리가 추가로 발행하여 데이터를 읽어오는 것

ex) 1번의 쿼리를 날렸을 때 의도하지 않은 N번의 쿼리가 추가적으로 실행

- JPA Repository를 활용해 인터페이스 메소드를 호출할 때 발생
- 1 : N 또는 N : 1 관계를 가진 엔티티를 조회할 때 발생

### 발생 상황

- JPA Fetch 전략이 EAGER 전략으로 데이터를 조회하는 경우
- JPA Fetch 전략이 LAZY 전략으로 데이터를 가져온 이후에 연관 관계인 하위 엔티티를 다시 조회하는 경우

### 발생 이유

- JPA Repository로 find시 실행하는 첫 쿼리에서 하위 엔티티까지 한번에 가져오지 않고 하위 엔티티를 추가로 조회하기 때문
- JPQL은 기본적으로 글로벌 Fetch 전략을 무시하고 JPQL만 가지고 SQL을 생성하기 때문

### EAGER (즉시 로딩)인 경우

1. JPQL에서 만든 SQL을 통해 데이터를 조회
2. 이후 JPA에서 Fetch 전략을 가지고 해당 데이터의 연관 관계인 하위 엔티티들을 추가 조회
3. 2번 과정으로 인해 N + 1 문제 발생

### LAZY (지연 로딩)인 경우

1. JPQL에서 만든 SQL을 통해 데이터를 조회
2. JPA에서 Fetch 전략을 가지지만, 지연 로딩이기 때문에 추가 조회는 하지 않음
3. 하위 엔티티를 가지고 작업을 하게 되면 추가 조회가 발생하면서 N + 1 문제 발생

### 해결 방법

#### Fetch join

- N + 1 자체가 발생하는 이유는 한쪽 테이블만 조회하고 연결된 다른 테이블은 따로 조회하기 때문
- 미리 두 테이블을 JOIN하여 한 번에 모든 데이터를 가져오면 됨
