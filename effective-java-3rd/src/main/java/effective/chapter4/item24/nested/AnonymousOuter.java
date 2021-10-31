package effective.chapter4.item24.nested;

public class AnonymousOuter {
    static int anonymousStaticInt = 1;
    int anonymousLocalInt;
    public AnonymousOuter(int anonymousLocalInt) {
        this.anonymousLocalInt = anonymousLocalInt;
    }
    public void repair(){
        System.out.println("repair!");
    }
    public static void repairStatic(){
        System.out.println("repair static!");
    }

    //비정적 메소드인 run이니 외부 인스턴스 참조 가능
    public void run(){
        //익명 클래스 선언!
        AnonymousInterface anonymousInterface = new AnonymousInterface() {
            // 상수는 정적 문맥이든 비정적 문맥이든 사용 가능
            public static final int valueFinal = 1;
            // 기본 타입과 String 외에는 사용할 수 없음
//            public static final Integer valueIntegerFinal = 1;
            // 상수 외에 정적 멤버 불가능
//            static int valueStatic;
            int valueLocal;
            @Override
            public void run() {
                repair();
                repairStatic();
                System.out.println(anonymousLocalInt);
                System.out.println(anonymousStaticInt);
                System.out.println(valueFinal);
                valueLocal = 2;
                System.out.println(valueLocal);
            }
            // 상수 외에 정적 멤버 불가능
//            public static void run2(){ }
        };
        anonymousInterface.run();
    }

}

interface AnonymousInterface{
    void run();
}