package effective.chapter7.item44;

import java.util.LinkedHashMap;
import java.util.Map;

public class CashMap<K,V> extends LinkedHashMap<K,V> {
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return super.size() > 100;
    }
}
