package effective.chapter6.item38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    @DisplayName("특정 연산에서 EnumSet과 EnumMap을 사용할 수 없다.")
    public void EnumMapAndEnumSet() throws Exception {

        //HashMap에 키 값을 Operation 인터페이스로 설정
        Map<Operation,String> map = new HashMap<>();
        map.put(BasicOperation.DIVIDE,BasicOperation.DIVIDE.toString());
        map.put(ExtendedOperation.EXP,ExtendedOperation.EXP.toString());

        //HashSet에 값을 Operation 인터페이스로 설정
        Set<Operation> set = new HashSet<>();
        set.add(BasicOperation.DIVIDE);
        set.add(ExtendedOperation.EXP);

//        //타입이 다른 것은 묶을 수 없음 - EnumSet
//        EnumSet.of(BasicOperation.DIVIDE,ExtendedOperation.EXP);
//        //인터페이스를 키 값으로 잡을 수 없음 - EnumMap
//        new EnumMap<>(Operation.class);

    }

}