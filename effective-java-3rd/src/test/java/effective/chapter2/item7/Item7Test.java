package effective.chapter2.item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.WeakHashMap;

class Item7Test {


    @Test
    @DisplayName("캐시 테스트")
    public void cacheTest() throws Exception {
        // key1이 사라졌을때, weakReference를 사용해서 GC의 대상이 된다.
        Object key1 = new Object();
        Object value1 = new Object();

        Map<Object, Object> cache = new WeakHashMap<>();
        cache.put(key1, value1);
    }
}