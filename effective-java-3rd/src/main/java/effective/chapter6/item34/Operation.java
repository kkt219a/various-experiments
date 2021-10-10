package effective.chapter6.item34;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

// 코드 34-6 상수별 클래스 몸체(class body)와 데이터를 사용한 열거 타입 (215-216쪽)
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
        // 생성자나 인스턴스 초기화 때, 정적 필드에 접근할 수 없기에 컴파일 에러
        //stringToEnum.put(symbol,this);
        // 메소드를 통해 초기화하려 해도, 정적 필드들이 초기화 전이라 NPE가 발생
        put(symbol,this);
    }

    public void put(String symbol, Operation operation){
        stringToEnum.put(symbol,operation);
    }

    @Override public String toString() { return symbol; }

    public abstract double apply(double x, double y);

    // 코드 34-7 열거 타입용 fromString 메서드 구현하기 (216쪽)
    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    // 지정한 문자열에 해당하는 Operation을 (존재한다면) 반환한다.
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

        Operation plus = Enum.valueOf(Operation.class, "PLUS");//Enum을 사용할 경우 -> 존재
        Operation plus1 = Operation.valueOf("PLUS");//Operation을 사용할 경우 -> 이 메소드의 출처는 어디서?
        Operation[] values = Operation.values(); // 어디서?

    }
}