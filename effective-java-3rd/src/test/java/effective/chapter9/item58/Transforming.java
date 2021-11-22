package effective.chapter9.item58;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Transforming {
    static List<Integer> numbers;
    @BeforeEach
    public void init(){
        numbers = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
    }

    @Test
    public void transforming() {
        for (Integer number : numbers) {
            if(number%3==0) {
                number = -1;
            }
        }
        //값이 변경되지 않음, 반복자나 배열이라면 인덱스를 사용해야함
        numbers.forEach(System.out::println);

    }

    @Test
    public void listIteratorUse() {
        for(ListIterator<Integer> i = numbers.listIterator(); i.hasNext();){
            Integer number = i.next();
            if(number%3==0) {
                i.set(-1);
            }
        }
        numbers.forEach(System.out::println);
    }

    @Test
    public void indexUse() {
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)%3==0){
                numbers.set(i,-1);
            }
        }
        // 인덱스를 이용, 값 변경
        numbers.forEach(System.out::println);
    }
}
