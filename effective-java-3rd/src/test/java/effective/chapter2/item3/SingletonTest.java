package effective.chapter2.item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    @DisplayName("public static final 필드는 리플렉션으로 private 생성자를 호출할 수 있다.")
    public void singletonPublicStaticFinalFieldTest() throws Exception {
        SingletonPublicStaticFinalField singletonOriginal = SingletonPublicStaticFinalField.INSTANCE;
        SingletonPublicStaticFinalField singletonOriginal2 = SingletonPublicStaticFinalField.INSTANCE;

        Class<?> aClass = Class.forName("effective.chapter2.item3.SingletonPublicStaticFinalField");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonPublicStaticFinalField singletonReflection = (SingletonPublicStaticFinalField) constructor.newInstance();

        assertSame(singletonOriginal, singletonOriginal2);
        assertNotSame(singletonOriginal, singletonReflection);
        System.out.println("singletonOriginal = " + singletonOriginal);
        System.out.println("singletonOriginal2 = " + singletonOriginal2);
        System.out.println("singletonReflection = " + singletonReflection);
    }

    @Test
    @DisplayName("static factory method 방식은 리플렉션으로 private 생성자를 호출할 수 있다.")
    public void singletonStaticFactoryMethodTest() throws Exception {
        SingletonStaticFactoryMethod singletonOriginal = SingletonStaticFactoryMethod.getInstance();
        SingletonStaticFactoryMethod singletonOriginal2 = SingletonStaticFactoryMethod.getInstance();

        Class<?> aClass = Class.forName("effective.chapter2.item3.SingletonStaticFactoryMethod");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonStaticFactoryMethod singletonReflection = (SingletonStaticFactoryMethod) constructor.newInstance();

        assertSame(singletonOriginal, singletonOriginal2);
        assertNotSame(singletonOriginal, singletonReflection);
        System.out.println("singletonOriginal = " + singletonOriginal);
        System.out.println("singletonOriginal2 = " + singletonOriginal2);
        System.out.println("singletonReflection = " + singletonReflection);
    }

    @Test
    @DisplayName("getInstance()는 Supplier로 사용할 수 있다.")
    public void SingletonSupplierTest() throws Exception {
        Supplier<SingletonStaticFactoryMethod> singletonSupplier = SingletonStaticFactoryMethod::getInstance;
    }
}