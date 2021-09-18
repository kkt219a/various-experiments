package effective.chapter2.item2.hierarchicalbuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static effective.chapter2.item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static effective.chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;

class PizzaTest {

    @Test
    @DisplayName("피자 테스트!")
    public void 피자_테스트() throws Exception {
        //given
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        //then
        System.out.println(pizza);
        System.out.println(calzone);
    }

}