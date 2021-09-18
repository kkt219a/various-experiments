package effective.chapter2.item1;


import java.lang.reflect.Method;
import java.util.Arrays;

public class Refrigerator {
    private String name;
    private String manufacturer;

    public Refrigerator() {
    }
    public Refrigerator(String name) {
        this.name = name;
    }
    /** 생성자의 시그니처 제약. 같은 타입을 파라미터로 받는 생성자가 2개일 수 없다. 따라서 public static 메소드 패턴을 이용해서 나타내는게 유리하다. **/
//    public Refrigerator(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }

    /** 생성자가 제공하는 파라미터로 반환객체를 잘 설명하지 못할경우,  public static 메소드가 더 읽기 편하고 이해하기 쉽다. **/
    public static Refrigerator withName(String name){
        return new Refrigerator(name);
    }

    /** public static 메소드 패턴 이용, 빈 생성자를 활용해 세팅하여 반환 **/
    public static Refrigerator withManufacturer(String manufacturer){
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.manufacturer = manufacturer;
        return refrigerator;
    }

    /** 인스턴스를 새로 생성하지 않아도 된다. **/
    private static final Refrigerator GOOD_TEMPERATURE = new Refrigerator();
    public static Refrigerator getRefrigerator(){
        return GOOD_TEMPERATURE;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    /** 냉장고의 하위 타입 **/
    static class MiniRefrigerator extends Refrigerator{

    }

    /** 매개변수에 따른 다른클래스 호출(상속) **/
    public static Refrigerator getRefrigerator(boolean flag){
        return flag?new Refrigerator() : new MiniRefrigerator();
    }

    enum Color{
        RED, WHITE, BLACK
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class vectorClass = Class.forName("effective.item1.domain.Test");
        Method[] methods = vectorClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println("methods.length = " + methods.length);
    }
}
