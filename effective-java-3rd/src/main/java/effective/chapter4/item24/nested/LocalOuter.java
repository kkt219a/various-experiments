package effective.chapter4.item24.nested;

public class LocalOuter {
    static int localStaticInt = 1;
    int localInt;
    public LocalOuter(int localInt) {
        this.localInt = localInt;
    }
    public void repair(){
        System.out.println("repair!");
    }
    public static void repairStatic(){
        System.out.println("repair static!");
    }
    //비정적 메소드인 run이니 외부 인스턴스 참조 가능
    public void run(){
        // 지역변수처럼 취급되니 정적, 접근제한자 설정 불가능
        class LocalInner{
            final int localInnerInt;
//            정적 필드 불가능
//            static int localInnerIntStatic=2;
            public LocalInner(int localInnerInt) {
                this.localInnerInt = localInnerInt;
            }
            public void runTo(){
                //비정적 문맥일 때 외부 인스턴스 참조 가능!
                System.out.println(localInt * localInnerInt * localStaticInt);
                repair();
                repairStatic();
            }
//            정적 멤버 불가능
//            public static void runTo2(){}
        }
        LocalInner localInner = new LocalInner(3);
        localInner.runTo();
    }
}
