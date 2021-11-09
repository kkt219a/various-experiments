package effective.chapter7.item47;

import java.util.*;

public class PowerSet {
    // 코드 47-5 입력 집합의 멱집합을 전용 컬렉션에 담아 반환한다. (287쪽)
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        // Collectiondml size가 int 값을 반환해서 Integer.MAX_VALUE인 (2^31)-1로 제한된다.
        // 크기가 더 커도 (2^31)-1을 반환해도 되지만 만족스러운 해법은 X
        if (src.size() > 30)
            throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30개).: " + s);
        return new AbstractList<Set<E>>() {
            @Override public int size() {
                // 멱집합의 크기는 2를 원래 집합의 원소 수만큼 거듭제곱 것과 같다.
                return 1 << src.size();
            }

            @Override public boolean contains(Object o) {
                // o가 Set 클래스가 맞는지, 리스트가 o를 전부 포함하는지 여부 반환
                return o instanceof Set && src.containsAll((Set)o);
            }

            @Override public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                // &연산을 통해서 어떤 원소가 있는지 유추할 수 있다. 오른쪽 시프트하며 다음 원소로 계속해서 이동한다.
                // 그리고 원소가 인덱스에 있다면 result에 추가하고 최종적으로 result를 반환한다.
                for (int i = 0; index != 0; i++, index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };
    }

    public static void main(String[] args) {
        Set s = new HashSet(Arrays.asList(args));
        System.out.println(PowerSet.of(s));
    }
}
