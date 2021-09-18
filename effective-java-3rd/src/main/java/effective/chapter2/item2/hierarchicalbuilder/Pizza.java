package effective.chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    // 빌더 자기 자신의 하위타입을 받는 빌더. 재귀적 타입 한정을 이용하는 제네릭 타입
    abstract static class Builder<T extends Builder<T>> {

        // 빈 Enumset
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        // topping을 추가하는 형식. 하위 클래스에서 연쇄적인 메서드 사용을 위해 동일한 빌더타입 반환
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        /**
         * 하위 클래스는 이 메서드를 재정의(overriding)하여
         * "this"를 반환하도록 해야 한다.
         * 형 변환을 하지 않고도 메서드 연쇄를 지원할 수 있다.
         * self 타입이 없는 자바를 위한 우회 방법을 시뮬레이트한 셀프타입 관용구라 한다.
         **/
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // 아이템 50 참조
    }
}