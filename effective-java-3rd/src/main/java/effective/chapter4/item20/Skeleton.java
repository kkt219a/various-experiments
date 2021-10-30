package effective.chapter4.item20;

public class Skeleton {
}

/** 1단계 - 중복 메소드 발생 **/
//interface Car{
//    void run();
//    void stop();
//}
//class SuperCar implements Car{
//    @Override
//    public void run() {
//        System.out.println("SuperCar run!");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("멈춰!");
//    }
//}
//class GeneralCar implements Car{
//    @Override
//    public void run() {
//        System.out.println("GeneralCar run!");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("멈춰!");
//    }
//}

/** 2단계 - 골격 구현 사용 **/
//interface Car{
//    void run();
//    void stop();
//}
//abstract class AbstractCar implements Car{
//    @Override
//    public void stop() {
//        System.out.println("멈춰!");
//    }
//
//    @Override
//    public void run() {
//        throw new RuntimeException();
//    }
//}
//
//class SuperCar extends AbstractCar implements Car{
//    @Override
//    public void run() {
//        System.out.println("SuperCar run!");
//    }
//
//}
//class GeneralCar extends AbstractCar implements Car{
//    @Override
//    public void run() {
//        System.out.println("A run!");
//    }
//}

/** 3단계 골격 구현을 확장한 Private 내부 클래스를 정의하고 메소드 호출로 인스턴스에 전달**/
//class TeslxCar{
//    public void maintenance(){
//        System.out.println("테슬x 정비 시작");
//    }
//}
//
//interface Car{
//    void run();
//    void stop();
//    void process();
//}
//abstract class AbstractCar implements Car{
//    @Override
//    public void stop() {
//        System.out.println("멈춰!");
//    }
//
//    @Override
//    public void run() {
//        throw new RuntimeException();
//    }
//
//    @Override
//    public void process() {
//        throw new RuntimeException();
//    }
//}
//
//class SuperCar extends TeslxCar implements Car{
//    InnerAbstractCar innerAbstractCar = new InnerAbstractCar();
//    @Override
//    public void run() {
//        innerAbstractCar.run();
//    }
//
//    @Override
//    public void stop() {
//        innerAbstractCar.stop();
//    }
//
//    @Override
//    public void process() {
//        maintenance();
//        innerAbstractCar.run();
//    }
//    private static class InnerAbstractCar extends AbstractCar{
//        @Override
//        public void run() {
//            System.out.println("SuperCar run!");
//        }
//    }
//}
//class GeneralCar extends AbstractCar implements Car{
//    @Override
//    public void run() {
//        System.out.println("GeneralCar run!");
//    }
//}