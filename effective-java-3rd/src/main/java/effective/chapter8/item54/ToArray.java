package effective.chapter8.item54;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ToArray {
    private static final Integer HUNDRED_MILLION = 100_000_000;
    public static Integer[] newInteger(){
        return new Integer[HUNDRED_MILLION];
    }
    public static Integer[] instanceInteger(){
        return (Integer[])Array.newInstance(Integer.class,HUNDRED_MILLION);
    }

    public static void main(String[] args) {
        List<Integer> collect = IntStream.rangeClosed(0, HUNDRED_MILLION).boxed().collect(Collectors.toList());
        long before = System.currentTimeMillis();
//        collect.toArray();
//        times(before);
//        before = System.currentTimeMillis();
//        collect.toArray(new Integer[0]);
//        times(before);
//        before = System.currentTimeMillis();
//        collect.toArray(new Integer[collect.size()]);
//        times(before);
        instanceInteger();
        times(before);
        before = System.currentTimeMillis();
        newInteger();
        times(before);
    }

    public static void times(long beforeTime){
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
