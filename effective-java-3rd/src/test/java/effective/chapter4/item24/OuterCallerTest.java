package effective.chapter4.item24;

import effective.chapter4.item24.nested.AnonymousOuter;
import effective.chapter4.item24.nested.LocalOuter;
import effective.chapter4.item24.nested.NestedOuter;
import effective.chapter4.item24.nested.StaticNestedOuter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OuterCallerTest {

    @Test
    @DisplayName("Local 클래스 테스트")
    public void localTest() throws Exception {
        LocalOuter local = new LocalOuter(3);
        local.run();
    }

    @Test
    @DisplayName("Anonymous 클래스 테스트")
    public void anonymousTest() throws Exception {
        AnonymousOuter anonymousOuter = new AnonymousOuter(3);
        anonymousOuter.run();
    }

    @Test
    @DisplayName("StaticNested 클래스 테스트")
    public void staticNestedTest() throws Exception {
        // 아래 3줄은 public으로 선언할 때만 사용.
//        StaticNestedOuter.PubStaticInner.runStatic();
//        StaticNestedOuter.PubStaticInner pubStaticInner = new StaticNestedOuter.PubStaticInner("symbol");
//        pubStaticInner.run();
        StaticNestedOuter.Operator minus = StaticNestedOuter.Operator.MINUS;
        StaticNestedOuter staticNestedOuter = new StaticNestedOuter(3);
        staticNestedOuter.runEx();
        StaticNestedOuter.runExStatic();
    }

    @Test
    @DisplayName("Nested 클래스 테스트")
    public void NestedTest() throws Exception {
        NestedOuter nestedOuter = new NestedOuter(3);
//        NestedOuter.PubStaticInner symbol = nestedOuter.new PubStaticInner("symbol");
        nestedOuter.runEx();
    }


}