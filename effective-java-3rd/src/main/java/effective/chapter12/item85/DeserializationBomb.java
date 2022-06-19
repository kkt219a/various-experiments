package effective.chapter12.item85;
import static effective.chapter12.Util.*;

import java.util.HashSet;
import java.util.Set;

// 코드 85-1 역직렬화 폭탄 - 이 스트림의 역직렬화는 영원히 계속된다. (451-452쪽)
public class DeserializationBomb {
    public static void main(String[] args) throws Exception {
        System.out.println(bomb().length);
        // deserialize(bomb());
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        // t1: foo 하나만 가지고 있는 HashSet
        // t2: 아무것도 없는 HashSet
        // s1과 s2는 매번 t1과 t2를 추가 -> 각각 200개씩 가짐
        // s1은 최종적으로 t
        // ** 정답은 s1, s2가 t1,t2가 스택에서 사라지더라도 힙영역을 가리키고 있으니까 GC 대상이 되지 않고, 계속해서 저장이 되는 것으로 이해했다. 디버깅!
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // t1을 t2와 다르게 만든다.
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        // 1번일 때: [[], [foo]]
        // 2번일 때: [[[], [foo]], [[], foo, [foo]]]
        // System.out.println(root);
        // System.out.println(s1);
        // System.out.println(s2);
        // return new byte[5];
        return serialize(root); // 이 메서드는 effectivejava.chapter12.Util 클래스에 정의되어 있다.
    }
}
