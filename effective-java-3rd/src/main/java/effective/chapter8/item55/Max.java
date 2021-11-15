package effective.chapter8.item55;

import org.jetbrains.annotations.NotNull;

import java.util.*;

// 반환 타입으로 Optional<T> 사용하기 (327-328쪽)
public class Max {
    int a;
//    // 코드 55-1 컬렉션에서 최댓값을 구한다. - 컬렉션이 비었으면 예외를 던진다. (327쪽)
//    public static <E extends Comparable<E>> E max(Collection<E> c) {
//        if (c.isEmpty())
//            throw new IllegalArgumentException("빈 컬렉션");
//
//        E result = null;
//        for (E e : c)
//            if (result == null || e.compareTo(result) > 0)
//                result = Objects.requireNonNull(e);
//
//        return result;
//    }

//    // 코드 55-2 컬렉션에서 최댓값을 구해 Optional<E>로 반환한다. (327쪽)
//    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
//        if (c.isEmpty())
//            return Optional.empty();
//
//        E result = null;
//        for (E e : c)
//            if (result == null || e.compareTo(result) > 0)
//                result = Objects.requireNonNull(e);
//
//        return Optional.of(result);
//    }

    // 코드 55-3 컬렉션에서 최댓값을 구해 Optional<E>로 반환한다. - 스트림 버전 (328쪽)
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("f");words.add("c");words.add("b");

        System.out.println(max(words));

        //초기 옵셔널 설정
        Optional<NotImplComp> optionalWord = Optional.of(new NotImplComp(25, "kkt"));
        // 옵셔널이 비어있다면 기본 값 설정할 수 있는 메소드
        optionalWord.orElse(new NotImplComp(24,"kkt!"));
        // 옵셔널이 비어있다면 예외를 처리할 수 있는 메소드
        optionalWord.orElseThrow(NullPointerException::new);
        // 옵셔널에 값이 있다는 가정하에 값을 가져올 수 있는 메소드
        optionalWord.get();
        // orElse와 달리 객체 생성을 옵셔널이 비어있을때만 실행되도록 미룰 수 있음
        optionalWord.orElseGet(()-> new NotImplComp(24,"kkt!"));

        List<NotImplComp> lists = new ArrayList<>();
        lists.add(new NotImplComp(25, "kkt"));
        max(lists);
        lists.stream().max(Comparator.naturalOrder());

    }
}


















