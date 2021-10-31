package effective.chapter4.item24.nested;

public class NestedOuter {
    private PubStaticInner pubStaticInner;
    private static int valueStatic = 3;
    private int value;

    public NestedOuter(int value) {
        this.pubStaticInner = new PubStaticInner("symbol");
        this.value = value;
    }

    private void run(){
        System.out.println("run!");
    }
    private static void runStatic(){
        System.out.println("run static!");
    }
    public void runEx(){
        pubStaticInner.run();
        System.out.println(pubStaticInner.symbol);
    }

    // private 선언 시 바깥 클래스 외에 접근 불가
    public class PubStaticInner{
        private String symbol;
        // 정적 필드 사용 불가
//        private static String fixed = "fixed Static!";
        public PubStaticInner(String symbol) {
            this.symbol = symbol;
        }
        public void run(){
            System.out.println(valueStatic);
            //비정적 외부 인스턴스 멤버 접근 불가
            System.out.println(value);
            // 바깥 클래스의 run 인스턴스 메소드 호출 가능
            NestedOuter.this.run();
            // 바깥 클래스 private static 접근 가능
            runStatic();
        }
        //정적 메소드 사용 불가
//        public static void runStatic(){ }
    }
}
