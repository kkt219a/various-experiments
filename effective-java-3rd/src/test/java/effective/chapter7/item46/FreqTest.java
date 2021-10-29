package effective.chapter7.item46;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FreqTest {

    @Test
    @DisplayName("unModifiable은 수정할 수 없다.")
    public void a() throws Exception {
        List<String> tmp = new ArrayList<>();
        tmp.add("z");
        Map<String, String> collect = tmp.stream().collect(Collectors.toUnmodifiableMap(a1 -> a1, a2 -> a2));
        collect.put("z","k");
    }

    @Test
    @DisplayName("groupBy 매개변수 1개는 키를 매핑함수로 지정하고 값을 디폴트로 List value를 가진다.")
    public void b() throws Exception {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(5);tmp.add(5);tmp.add(5);
        Map<Integer, List<Integer>> collect1 = tmp.stream().collect(Collectors.groupingBy(val -> val * 2));
        System.out.println(collect1);
    }

    @Test
    @DisplayName("toMap 매개변수 4개는 맵 팩토리와 merge 함수를 작성해서 매핑가능")
    public void c() throws Exception {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(5);tmp.add(5);tmp.add(5);
        Map<Integer, Integer> result = tmp.stream().collect(Collectors.toMap(ii -> ii, jj -> jj, (kk, ll) -> kk * ll, TreeMap::new));
        System.out.println(result);
    }

    @Test
    @DisplayName("summing, averaging, summarizing은 어떤 값을 불러오는가")
    public void d() throws Exception {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(5);tmp.add(5);tmp.add(5);
        Integer sum = tmp.stream().collect(Collectors.summingInt(value->value*2));
        Integer sum2 = tmp.stream().mapToInt(value -> value * 2).sum(); // mapToInt의 sum으로 대체 가능
        Double avg = tmp.stream().collect(Collectors.averagingInt(value->value*2));
        IntSummaryStatistics innSumma = tmp.stream().collect(Collectors.summarizingInt(value -> value * 2));
    }

    @Test
    @DisplayName("joining의 다양한 방법")
    public void e() throws Exception {
        List<String> tmp = new ArrayList<>();
        tmp.add("z");tmp.add("x");tmp.add("c");
        tmp.stream().collect(Collectors.joining()); // zxc
        tmp.stream().collect(Collectors.joining(", ")); // z, x, c
        tmp.stream().collect(Collectors.joining("[",", ","]")); // [z, x, c]
    }

    @Test
    @DisplayName("joining의 다양한 방법")
    public void f() throws Exception {
        List<String> tmp = new ArrayList<>();
        tmp.add("z");tmp.add("x");tmp.add("c");
        tmp.stream().collect(Collectors.joining()); // zxc
        tmp.stream().collect(Collectors.joining(", ")); // z, x, c
        tmp.stream().collect(Collectors.joining("[",", ","]")); // [z, x, c]
    }


}