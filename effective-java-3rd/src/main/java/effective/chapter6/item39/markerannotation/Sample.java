package effective.chapter6.item39.markerannotation;

// 코드 39-2 마커 애너테이션을 사용한 프로그램 예 (239쪽)
public class Sample {
    @Test public static void m1() { } // 성공
    public static void m2() { }
    @Test public static void m3() {    // 실패해야 한다.
        throw new RuntimeException("실패");
    }
    public static void m4() { }
    @Test public void m5() { }   // 정적메소드가 아님
    public static void m6() { }
    @Test public static void m7() {    // 실패해야 한다.
        throw new RuntimeException("실패");
    }
    public static void m8() { }
}
