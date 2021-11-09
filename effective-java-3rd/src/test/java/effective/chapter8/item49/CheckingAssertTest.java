package effective.chapter8.item49;

import org.junit.jupiter.api.Test;

import static effective.chapter8.item49.CheckingAssert.callAssert;
import static org.junit.jupiter.api.Assertions.*;

class CheckingAssertTest {

    @Test
    public void test() throws Exception {
        callAssert(null,null);
        callAssert(3, null);
    }
}