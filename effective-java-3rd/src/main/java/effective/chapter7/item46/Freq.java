package effective.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// 빈도표 초기화에 스트림을 적절하지 못하게 혹은 적절하게 사용하는 예 (277-279쪽)
public class Freq {
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File(args[0]);
//
////        // 코드 46-1 스트림 패러다임을 이해하지 못한 채 API만 사용했다 - 따라 하지 말 것! (277쪽)
////        Map<String, Long> freq = new HashMap<>();
////        try (Stream<String> words = new Scanner(file).tokens()) {
////            words.forEach(word -> {
////                freq.merge(word.toLowerCase(), 1L, Long::sum);
////            });
////        }
//
//        // 코드 46-2 스트림을 제대로 활용해 빈도표를 초기화한다. (278쪽)
//        Map<String, Long> freq;
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//        }
//        System.out.println(freq);
//
//        // 코드 46-3 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인 (279쪽)
//        List<String> topTen = freq.keySet().stream()
//                .sorted(Comparator.comparing(freq::get).reversed())
//                .limit(10)
//                .collect(Collectors.toUnmodifiableList());
//        //topTen.add("zz");
//        topTen.remove(2);
//        System.out.println(topTen);

    }
}
