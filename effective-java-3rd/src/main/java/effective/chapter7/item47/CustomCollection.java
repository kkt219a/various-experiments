package effective.chapter7.item47;

import java.util.*;

public class CustomCollection {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("a","b","c");
        Collection<String> strings = new AbstractCollection<>() {
            @Override
            public Iterator<String> iterator() {
                return lists.iterator();
            }

            @Override
            public int size() {
                return lists.size();
            }

            @Override
            public boolean contains(Object o) {
                // 재정의를 해서 매개변수가 String이 맞는지 확인해야 올바르게 구현된 형태!
                return o instanceof String && super.contains(o);
            }
        };
        System.out.println("strings.size() = " + strings.size() + strings.contains("a"));
    }
}
