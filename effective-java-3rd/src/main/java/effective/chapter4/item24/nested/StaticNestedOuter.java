package effective.chapter4.item24.nested;

public class StaticNestedOuter {
    private PubStaticInner pubStaticInner;
    private static int valueStatic = 3;
    private int value;

    public StaticNestedOuter(int value) {
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
        System.out.println(PubStaticInner.fixed);
        PubStaticInner.runStatic();
    }
    public static void runExStatic(){
        System.out.println(PubStaticInner.fixed);
        PubStaticInner.runStatic();
    }

    //이미 static이다.
    public enum Operator{
        PLUS,MINUS;
    }

    // private 선언 시 바깥 클래스 외에 접근 불가
    private static class PubStaticInner{
        private String symbol;
        private static String fixed = "fixed Static!";
        public PubStaticInner(String symbol) {
            this.symbol = symbol;
        }
        public void run(){
            System.out.println(valueStatic);
            //비정적 외부 인스턴스 멤버 접근 불가
            //System.out.println(value);
            // StaticNestedOuter.run();
            // 바깥 클래스 private static 접근 가능
            runStatic();
        }
        public static void runStatic(){
            System.out.println(valueStatic);
            //비정적 바깥 클래스 멤버 접근 불가
            //System.out.println(value);
            //run();
            // 바깥 클래스 private static 접근 가능
            StaticNestedOuter.runStatic();
        }
    }
}
