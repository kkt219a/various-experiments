package effective.chapter3.item14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class BigDecimalTest {
    
    @Test
    @DisplayName("compareTo와 equals의 일반규약이 다르면 TreeSet과 HashSet에 저장된 원소의 개수는 다르다.")
    public void differenceTest() throws Exception {
        //given
        BigDecimal oneDotZero = new BigDecimal("1.0");
        BigDecimal oneDotZeroZero = new BigDecimal("1.00");
        Set<BigDecimal> hashSet = new HashSet<>();
        Set<BigDecimal> treeSet = new TreeSet<>();
        //when
        hashSet.add(oneDotZero);
        hashSet.add(oneDotZeroZero);
        treeSet.add(oneDotZero);
        treeSet.add(oneDotZeroZero);
        //then
        assertEquals(2, hashSet.size());
        assertEquals(1, treeSet.size());
        assertFalse(oneDotZero.equals(oneDotZeroZero));
        assertTrue(oneDotZero.compareTo(oneDotZeroZero) == 0);
    }
}
