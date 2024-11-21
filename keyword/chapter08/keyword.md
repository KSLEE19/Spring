
## Exception 종류

- Unchecked Exception
    - RuntimeException
- Checked Exception ( System 자원을 접근하는 메서드들로 compile error가 발생)
    - CloneNotSupportException
    - IntantiationException
    - NoSuchMethodException
    - ClassNotFoundException
    - IOException

Unchecked Exception은 예외가 발생된 곳에서 처리되지 않으면 전파됨

## RuntimeException 종류

- ClassCastException

▶️ 특정 클래스의 객체를 호환되지 않는 클래스로 형변환하려고 할 때 발생

- ArithmeticException

▶️ 연산이 불가능한 상황에 발생 

ex ) 0으로 나누는 경우(divide by zero)

- NegativeArraySizeException

▶️ 배열 선언을 할 때 배열의 크기를 음수로 지정하는 경우 발생

- NullPointerException

▶️ 참조변수가 Null로 초기화 된 상황에서 메소드가 호출되는 경우 발생

- ArrayStoreException

▶️ 객체 배열에 잘못된 유형의 객체를 저장하려고 하는 경우 발생

- IndexOutOfBoundException

▶️ 잘못된 인덱스 값을 사용하는 경우 발생

- SecurityException

▶️ 잘못된 접근 시도, 접근 권한 없음 등의 상황이 생기면 발생

---

## @Valid

## Bean Validator를 이용해 객체의 제약 조건을 검증하도록 지시하는 어노테이션

## 의존성 추가

```java
implementation 'org.springframework.boot:spring-boot-starter-validation'
```

build.gradle에 의존성을 추가하면 사용 가능

## 사용 예시

```java
public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
...
}
```

→ 이런식으로 컨트롤러 메소드에 @Valid를 넣어주면 유효성 검증을 함

## 동작 원리

모든 요청은 Dispatch Servlet을 통해 컨트롤러로 전달되며 전달 과정에서는 컨트롤러 메소드 객체를 만들어주는 ArgumentResolver가 동작하는데, @Valid 도 ArgumentResolver에 의해 처리됨

*** @Valid는 기본적으로 컨트롤러에서만 동작 → 다른 계층에서는 검증이 안됨

*** 다른 계층에서 파라미터를 검증하려면 @Validated를 사용해야 함

## 특징

- 자동 유효성 검사
    - 클래스나 메서드 매개변수에 설정된 제약 조건을 자동으로 검증
- 객체 단위 검증
- 어노테이션 기반 유효성 검사

## 어노테이션 종류

### @Null, @NotNull

▶️ Null 가능 여부

### @NotEmpty, @NotBlank

▶️ Null, 빈 문자열 사용 불가

### @Size(min =,max=)

▶️ 값이 min과 max 사이에 해당하는지

### @Positive, @PositiveOrZero

▶️ 양수만 가능 (0 포함 여부)

### @Negative, @NegativeOrZero

▶️ 음수만 가능 (0 포함 여부)

### @Max(), @Min()

▶️ 값이 Max보다 큰지, 값이 Min보다 작은지 확인

### @Email

▶️ 이메일 형식만 가능

### @AssertTrue, @AssertFalse

▶️ True 인가?, False 인가?