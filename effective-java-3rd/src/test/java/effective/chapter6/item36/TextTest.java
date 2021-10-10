package effective.chapter6.item36;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import static effective.chapter6.item36.Text.*;
import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    @Test
    @DisplayName("unmodifiableSet은 불변으로 만들어 준다.")
    public void unmodifiableSetTest() {
        Set<Style> styles = Collections.unmodifiableSet(EnumSet.of(Style.BOLD));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> styles.add(Style.UNDERLINE));
    }
}