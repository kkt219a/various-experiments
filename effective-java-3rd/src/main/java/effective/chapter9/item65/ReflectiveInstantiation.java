package effective.chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// 리플렉션으로 활용한 인스턴스화 데모
public class ReflectiveInstantiation {
    Class<? extends Set<String>> cl = null;

    public ReflectiveInstantiation() {
        // 클래스 이름을 Class 객체로 변환, 구현체 클래스 지정
        try {
            cl = (Class<? extends Set<String>>)  // 비검사 형변환!
                Class.forName("java.util.HashSet");
        } catch (ClassNotFoundException e) {
            fatalError("클래스를 찾을 수 없습니다.");
        }
    }

    // 클래스의 생성자를 통해 인스턴스 생성
    public Set<String> getInstance(){
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
        }

        // 집합의 인스턴스를 만든다.
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("생성자에 접근할 수 없습니다.");
        } catch (InstantiationException e) {
            fatalError("클래스를 인스턴스화할 수 없습니다.");
        } catch (InvocationTargetException e) {
            fatalError("생성자가 예외를 던졌습니다: " + e.getCause());
        } catch (ClassCastException e) {
            fatalError("Set을 구현하지 않은 클래스입니다.");
        }
        // 생성한 집합을 사용한다.
        s.addAll(List.of("a","b","c"));
        return s;
    }

    // 인스턴스가 가지는 모든 메소드 이름과 결과 출력
    public void printMethod(Set<String> s){
        Method[] methods = cl.getMethods();
        System.out.println("====메소드와 결과===");
        for (Method method : methods) {
            System.out.println(method.getName());
            try {
                if(method.getParameterCount()==0
                    &&!method.getName().equals("wait")
                    &&!method.getName().equals("notify")
                    &&!method.getName().equals("notifyAll")

                ) {
                    System.out.println(method.invoke(s));
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    // 인스턴스가 가지는 모든 필드 이름과 값 출력
    public void printField(Set<String> s){
        Field[] fields = cl.getFields();
        System.out.println("====필드와 결과===");
        for (Field field : fields) {
            System.out.println(field.getName());
            try {
                System.out.println(field.get(s));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}
