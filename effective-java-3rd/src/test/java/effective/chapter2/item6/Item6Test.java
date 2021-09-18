package effective.chapter2.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class Item6Test {

    @Test
    @DisplayName("리터럴과 새로운 인스턴스")
    public void instanceTest() throws Exception {
        //given
        String s = new String("k____tae");
        String s2 = "k____tae";
        Boolean b = new Boolean("true");
        Boolean b2 = Boolean.valueOf("true");

        //then
        assertNotSame(s,s2);
        assertNotSame(s,"k____tae");
        assertSame(s2,"k____tae");
        assertNotSame(b,b2);
        assertNotSame(b,Boolean.TRUE);
        assertSame(b2,Boolean.TRUE);
    }

    @Test
    @DisplayName("map의 keyset은 매번 같은 객체를 반환한다.")
    public void 맵_테스트() throws Exception {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Burger", 8);
        menu.put("Pizza", 9);

        // map 객체 안의 Key값을 Set으로 전체 반환. 매번 같은 Set 인스턴스를 반환한다.
        Set<String> names1 = menu.keySet();
        Set<String> names2 = menu.keySet();

        // menu를 수정하면 모두가 똑같은 Map 인스턴스를 대변하기 때문에 names1, names2의 객체상태도 변경된다.
        names1.remove("Burger");
        assertSame(names1,names2);
        assertEquals(names1.size(),1);
        assertEquals(names1.size(),names2.size());
        assertEquals(menu.size(),names2.size());
    }

    @Test
    @DisplayName("오토박싱이 성능을 저하한다.")
    public void 오토박싱() throws Exception {
        // 오토박싱
        long start = System.currentTimeMillis();
        Long sum = 0l;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - start);

        // 기본 primitive
        start = System.currentTimeMillis();
        long sum2 = 0l;
        for (long i = 0 ; i <= Integer.MAX_VALUE ; i++) {
            sum2 += i;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
