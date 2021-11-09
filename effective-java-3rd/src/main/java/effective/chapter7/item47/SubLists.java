package effective.chapter7.item47;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 리스트의 모든 부분리스트를 원소를 갖는 스트림을 생성하는 두 가지 방법 (288-289쪽)
public class SubLists {
    // 입력 리스트의 모든 부분리스트를 스트림으로 반환
    // 즉, list에 {"a","b","c"}가 있다면 prefix 결과 {"a"}, {"a","b"}, {"a", "b", "c"}를
    // 각각 마지막 원소를 포함하게 하면 {a}, {a,b}, {b}, {a,b,c}, {b,c},{c}가 나올 수 있다.
    // 모든 부분 리스트니 빈 리스트도 필요하고, 이를 Stream으로 만들어 concat을 통해 붙히면
    // 첫 번째 스트림 인자 뒤로 두 번째 스트림 인자가 붙어서 최종적으로 부분 리스트들이 Stream으로 만들어져 반환된다.
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    // 첫 번째 원소를 포함하는 부분리스트를 반환
    private static <E> Stream<List<E>> prefixes(List<E> list) {
        //rangeClosed: 특정 범위의 숫자를 차례대로 생성, [startInclusive,endInclusive]
        // 즉, list에 {"a","b","c"}가 있다면 mapToObj를 통해
        // [0,1) ~ [0,3)까지를 결과를 List형태로 Stream에 담는다.--> {"a"}, {"a","b"}, {"a", "b", "c"}
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    // 마지막 원소를 포함하는 부분리스트를 반환
    private static <E> Stream<List<E>> suffixes(List<E> list) {
        //range: 특정 범위의 숫자를 차례대로 생성, [startInclusive,endInclusive)
        // 즉, list에 {"a","b","c"}가 있다면 mapToObj를 통해
        // [0,3) ~ [2,3)까지의 결과를 List형태로 Stream에 담는다. --> {"a", "b", "c"}, {"b","c"}, {"c"}
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

//    // 코드 47-7 입력 리스트의 모든 부분리스트를 스트림으로 반환한다(빈 리스트는 제외). (289쪽)
//    // 289쪽의 명확한 반복 코드의 변형이다.
    public static <E> Stream<List<E>> ofDirect(List<E> list) {
        //flatMap을 쓴 이유는, mapToObj 결과가 Stream<Stream<List<E>> 형태기 때문에 평탄화가 필요하다.
        return IntStream.range(0, list.size())
                .mapToObj(start ->
                        IntStream.rangeClosed(start+(int)Math.signum(start), list.size())
                                .mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("a","b","c");
        List<String> lists2 = Arrays.asList("d","e","f");

        SubLists.of(lists).forEach(System.out::println);
        System.out.println();
        suffixes(lists).forEach(System.out::println);
        System.out.println();
        prefixes(lists).forEach(System.out::println);
        System.out.println();
        //lists.stream().flatMap(a->lists2.stream()).forEach(System.out::println);

        //단, 빈배열은 여기서 출력을 안한다.
        for(int start=0;start<lists.size();start++){
            for(int end=start+1;end<=lists.size();end++){
                System.out.println(lists.subList(start,end));
            }
        }
        System.out.println();
        SubLists.ofDirect(lists).forEach(System.out::println);
        // 양수면 1, 음수면 -1, 0이면 0
        System.out.println("Math.signum(5) = " + Math.signum(-1));

    }
}
