package effective.chapter7.item44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

class CashMapTest {
    @Test
    @DisplayName("1~107을 저장하면 크기는100, 1~7삭제, 8부터 시작")
    public void cash() throws Exception {
        CashMap<Integer,Integer> cm = new CashMap<>();
        for(int i=1;i<=107;cm.put(i++,0));
        Assertions.assertFalse(cm.containsKey(7));
        Assertions.assertTrue(cm.containsKey(8));
        Assertions.assertEquals(cm.size(),100);
    }

    @Test
    public void mayFunctional() {
        CashMap<Integer,Integer> cm = new CashMap<>();
        for(int i=1;i<=10;cm.put(i++,0));
        BiPredicate<CashMap<Integer,Integer>, Map.Entry<Integer,Integer>> delete = (c, v) -> c.size() > 5;
        // 실제론 없음: put을 할때 eldest의 조건을 같이 넘겨주거나
        // cm.put(1,2,delete);
        // 실제론 없음: 생성자를 만들때 함수 객체를 넣어주는 방법을 쓰거나?
        // CashMap<Integer,Integer> cm2 = new CashMap<>(delete);
    }
}