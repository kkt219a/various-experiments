package effective.chapter8.item56;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class GenericEnumAnnotation {
    // 제네릭 문서화(339p)
    /**
     * An object that maps keys to values. A map cannot contain
     * duplicate keys; each key can map to at most one value.
     *
     * (Remainder omitted)
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    public interface Map<K, V> {  }

    //    /**
//     * 키와 값을 매핑하는 객체. 맵은 키를 중복해서 가질 수 없다.
//     * , 키 하나가 가리킬 수 있는 값은 최대 1개다.
//     *
//     * (나머지 설명 생략)
//     *
//     * @param <K> 이 맵이 관리하는 키의 타입
//     * @param <V> 매핑된 값의 타입
//     */
//    public interface Map<K, V> {  }

    // 열거 상수 문서화 (339-340쪽)
    /**
     * An instrument section of a symphony orchestra.
     */
    public enum OrchestraSection {
        /** Woodwinds, such as flute, clarinet, and oboe. */
        WOODWIND,

        /** Brass instruments, such as french horn and trumpet. */
        BRASS,

        /** Percussion instruments, such as timpani and cymbals. */
        PERCUSSION,

        /** Stringed instruments, such as violin and cello. */
        STRING;
    }
    // 한글 버전 (340쪽)
    // /**
    //  * 심포니 오케스트라의 악기 세션.
    //  */
    // public enum OrchestraSection {
    //     /** 플루트, 클라리넷, 오보 같은 목관악기. */
    //     WOODWIND,
    //
    //     /** 프렌치 호른, 트럼펫 같은 금관악기. */
    //     BRASS,
    //
    //     /** 탐파니, 심벌즈 같은 타악기. */
    //     PERCUSSION,
    //
    //     /** 바이올린, 첼로 같은 현악기. */
    //     STRING;
    // }


    // 애너테이션 타입 문서화 (340쪽)
    /**
     * Indicates that the annotated method is a test method that
     * must throw the designated exception to pass.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExceptionTest {
        /**
         * The exception that the annotated test method must throw
         * in order to pass. (The test is permitted to throw any
         * subtype of the type described by this class object.)
         */
        Class<? extends Throwable> value();
    }
    // 한글 버전 (341쪽)
    // /**
    //  * 이 애너테이션이 달린 메서드는 명시한 예외를 던져야만 성공하는
    //  * 테스트 메서드임을 나타낸다.
    //  */
    // @Retention(RetentionPolicy.RUNTIME)
    // @Target(ElementType.METHOD)
    // public @interface ExceptionTest {
    //     /**
    //      * 이 애너테이션을 단 테스트 메서드가 성공하려면 던져야 하는 예외.
    //      * (이 클래스의 하위 타입 예외는 모두 허용된다.)
    //      */
    //     Class<? extends Throwable> value();
    // }
}
