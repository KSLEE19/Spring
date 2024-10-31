import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class mission_week4 {

    public static void main(String[] args) {

        Function<Integer, String> anonymousClassFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };

        class MyFunction implements Function<Integer, String> {

            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        }
        Function<Integer, String> classFunction = new MyFunction();

        Function<Integer, String> lambdaFunction = (Integer integer) -> String.valueOf(integer);

        Function<Integer, String> methodReferenceFunction = String::valueOf;

        int tmp = 7;
        System.out.println("익명클래스 정의 : " + anonymousClassFunction.apply(tmp));
        System.out.println("클래스 파일 만들어 상속 : " + classFunction.apply(tmp));
        System.out.println("람다식 정의 : " + lambdaFunction.apply(tmp));
        System.out.println("메소드 참조 정의 : " + methodReferenceFunction.apply(tmp));

        int[] streamArr = IntStream.rangeClosed(1, 10).toArray();
        int[] doubleStreamArr = Arrays.stream(streamArr).map(n -> n * 2).toArray();
        System.out.println("원본 배열 : " + Arrays.toString(streamArr));
        System.out.println("2배 배열 : " + Arrays.toString(doubleStreamArr));

        String[] evenStreamArr = Arrays.stream(streamArr)
                .mapToObj(n -> (n % 2 == 0) ? (n + " is even number") : String.valueOf(n))
                .toArray(String[]::new);
        System.out.println("짝수만 String으로 변환한 배열 : " + Arrays.toString(evenStreamArr));

    }
}
