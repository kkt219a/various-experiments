package effective.chapter2.item5;

import java.util.List;
import java.util.function.Supplier;

public class SupplierWildCard {
    private List<Supplier<? extends A>> test;
    public void add(){
        test.add(A::new);
        test.add(B::new);
        test.add(C::new);
    }
    public void print(){
        test.forEach(System.out::println);
    }
}
class A { }
class B extends A { }
class C extends A { }
