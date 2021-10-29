package effective.chapter7.item43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

interface G1{
    <E extends RuntimeException> Object m() throws E;
}
interface G2 {
    <F extends RuntimeException> String m() throws RuntimeException;
}

@FunctionalInterface
interface G extends G1, G2{

}
public class GenericFunctionType {

    private static <F extends Throwable> String m() throws RuntimeException {
        return "kTae";
    }

    private static void gClass(G g){
        try {
            System.out.println(g.m());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //익명클래스 생성
        G g  = new G() {
            @Override
            public <F extends RuntimeException> String m() throws RuntimeException {
                return null;
            }
        };
        try {
            //gClass(()->m()); // 함수형 인터페이스의 제네릭 메소드는 람다식이 안된다는 것.
            gClass(GenericFunctionType::m); // 메소드 참조 표현식은 가능
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            gClass(g); // 만들어진 객체 가능
            //gClass(()->g.m()); // 람다 불가능
            gClass(g::m); // 메소드 참조 표현식 가능
            //throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
