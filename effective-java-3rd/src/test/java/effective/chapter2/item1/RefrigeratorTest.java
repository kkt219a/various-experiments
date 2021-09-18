package effective.chapter2.item1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class RefrigeratorTest {

    public static void main(String[] args) {
        Refrigerator refrigerator = RefrigeratorInterface.getRefrigerator();
    }
    @Test
    @DisplayName("장점1: 정적 팩토리 메소드는 이름을 가질 수 있다.")
    public void 이름을_가진다() throws Exception {
        //given
        Refrigerator refrigerator = new Refrigerator("special 4 Door");
        Refrigerator refrigerator1 = Refrigerator.withName("special 4 Door");
        //then
        Assertions.assertEquals(refrigerator.getName(),refrigerator1.getName());
        Assertions.assertNull(refrigerator.getManufacturer());
        Assertions.assertNull(refrigerator1.getManufacturer());
    }
    
    @Test
    @DisplayName("장점1: 이름을 가지기에, 같은 타입의 생성자를 가질 수 없는 시그니처 제약을 받지않는다.")
    public void 시그니처_제약_벗어나기() throws Exception {
        //given
        Refrigerator refrigerator = Refrigerator.withManufacturer("삼성");
        //then
        Assertions.assertEquals(refrigerator.getManufacturer(),"삼성");
        Assertions.assertNull(refrigerator.getName());
    }

    @Test
    @DisplayName("장점2: 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.")
    public void 새객체_필요없음() throws Exception {
        //given
        Refrigerator refrigerator = Refrigerator.getRefrigerator();
        //then
        Assertions.assertNotNull(refrigerator);
        Assertions.assertNull(refrigerator.getManufacturer());
        Assertions.assertNull(refrigerator.getName());
    }

    @Test
    @DisplayName("장점3: 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이있다.")
    public void 하위타입_객체_반환_가능() throws Exception {
        //given
        Refrigerator refrigerator = RefrigeratorInterface.getRefrigerator();
        //then
        Assertions.assertNotNull(refrigerator);
        Assertions.assertNull(refrigerator.getManufacturer());
        Assertions.assertNull(refrigerator.getName());
    }

    @Test
    @DisplayName("장점4: 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.")
    public void 매개변수_따른_객체_반환() throws Exception {
        //given
        Refrigerator miniRefrigerator = Refrigerator.getRefrigerator(false);
        Refrigerator refrigerator = Refrigerator.getRefrigerator(true);
        //then
        assertTrue(miniRefrigerator instanceof Refrigerator.MiniRefrigerator);
        assertFalse(refrigerator instanceof Refrigerator.MiniRefrigerator);
    }

    @Test
    @DisplayName("장점4: 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.")
    public void enumset_테스트() throws Exception {
        //given
        EnumSet<Refrigerator.Color> colors = EnumSet.allOf(Refrigerator.Color.class);
        EnumSet<Refrigerator.Color> whiteAndBlack = EnumSet.of(Refrigerator.Color.WHITE, Refrigerator.Color.BLACK);
        // RegularEnumSet은 public class가 아니라 호출할 수 없어 확인할 수 없다.
    }
}