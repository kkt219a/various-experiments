package effective.chapter9.item58;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParallelIteration {
    static List<Integer> diceNumber = List.of(1,2,3,4,5,6);
    static List<String> shape = List.of("star","rectangle","triangle");
    @Test
    public void requiredThree() throws Exception {
        // 1:1 매칭은 for-each 문으로 할 수 없다.
        Iterator<Integer> i = diceNumber.iterator();
        Iterator<String> j = shape.iterator();
        for(;i.hasNext()&&j.hasNext();){
            System.out.println(j.next()+" "+i.next());
        }
    }
}
