package effective.chapter7.item43;

import java.nio.file.DirectoryStream;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// map.merge를 이용해 구현한 빈도표 - 람다 방식과 메서드 참조 방식을 비교해보자. (259쪽)
public class Freq {
    public static void main(String[] args) {
        Map<String, Integer> frequencyTable = new TreeMap<>();
        String[] argg = {"k","t","a","e","k","t"};
        for (String s : argg)
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // 람다
        for (String s : frequencyTable.keySet()) {
            System.out.println("frequencyTable = " + frequencyTable.get(s));
        }
        System.out.println(frequencyTable);

        List<Integer> integers = List.of(1, 2, 3);
        // 람다
        // Predicate<Integer> listTwoIndexEq = obj -> integers.get(2).equals(obj);
        Predicate<Integer> a = integers.get(2)::equals;
        System.out.println(a.test(3)); // true

        // 람다
        //Predicate<Instant> parameterIsAfter = otherInstant -> Instant.now().isAfter(otherInstant);
        Predicate<Instant> parameterIsAfter = Instant.now()::isAfter;
        System.out.println(parameterIsAfter.test(Instant.MIN)); //true

        frequencyTable.clear();
        for (String s : argg)
            frequencyTable.merge(s, 1, Integer::sum); // 메서드 참조
        System.out.println(frequencyTable);

    }
}
