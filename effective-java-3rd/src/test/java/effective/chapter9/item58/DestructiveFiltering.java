package effective.chapter9.item58;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class DestructiveFiltering {
    static List<Integer> numbers;
    @BeforeEach
    public void init(){
        numbers = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
    }
    @Test
    @DisplayName("collection의 remove 메소드는 예외 발생")
    public void collectionRemove() {
        // Iterator 순회 중 데이터의 변경이 일어나기 때문에 ConcurrentModificationException 발생
        for (Integer number : numbers) {
            if(number%3==0){
                numbers.remove(number);
            }
        }
    }

    @Test
    @DisplayName("반복자를 이용한 remove")
    public void iteratorRemove() {
        for(Iterator<Integer> i = numbers.iterator(); i.hasNext();){
            Integer number = i.next();
            if(number%3==0){
                i.remove();
            }
        }
        numbers.forEach(System.out::println);
    }

    @Test
    @DisplayName("collection의 removeIf를 이용한 remove")
    public void collectionRemoveIf() {
        numbers.removeIf(number -> number % 3 == 0);
        numbers.forEach(System.out::println);
    }

}