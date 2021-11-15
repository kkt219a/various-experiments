package effective.chapter8.item55;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapAndFlatMapOnOptional {
    @Test
    public void map() {
        Optional<Optional<String>> s1 = Optional.of(Optional.of("STRING"));
        // map은 Optional을 리턴하면 Optional이 한 번 더 래핑된다.
        Optional<Optional<String>> s2 = Optional.of("string").map(s -> Optional.of("STRING"));
        assertEquals(s1,s2);
    }
    @Test
    public void flatMap() {
        Optional<String> s1 = Optional.of("STRING");
        // FlatMap은 Optional을 리턴해야한다.
        Optional<String> s2 = Optional.of("string").flatMap(s -> Optional.of("STRING"));
        assertEquals(s1,s2);
    }
}
