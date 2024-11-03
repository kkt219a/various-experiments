package hello.loop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ForLoop {
    private static final Value value = new Value();


    @Test
    @DisplayName("배열의 일반 for-loop를 확인한다.")
    public void arrayForLoop() {
        long beforeTime = System.currentTimeMillis();
        Integer[] arrayValue = value.getArrayValue();
        int size = arrayValue.length;
        for(int i=0;i<size;i++){
            Integer a = arrayValue[i];
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }
    @Test
    @DisplayName("배열의 일반 for-enhance-loop를 확인한다.")
    public void arrayForEnhanceLoop() {
        long beforeTime = System.currentTimeMillis();
        Integer[] arrayValue = value.getArrayValue();
        int size = arrayValue.length;
        for (Integer integer : arrayValue) {
            Integer a = integer;
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }
    @Test
    @DisplayName("배열의 일반 for-each-lambda-loop를 확인한다.")
    public void arrayForEachLambdaLoop() {
        long beforeTime = System.currentTimeMillis();
        Integer[] arrayValue = value.getArrayValue();
        int size = arrayValue.length;
        Arrays.stream(arrayValue).forEach(integer ->{ Integer a = integer; });
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    @Test
    @DisplayName("arrayList의 일반 for-loop를 확인한다.")
    public void arrayListForLoop(){
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getArrayListValue();
        int size = listValue.size();
        for(int i=0;i<size;i++){
            Integer integer = listValue.get(i);
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    @Test
    @DisplayName("arrayList의 일반 for-enhance-loop를 확인한다.")
    public void arrayListForEnhanceLoop(){
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getArrayListValue();
        int size = listValue.size();
        for (Integer integer : listValue) {
            Integer a = integer;
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }
    @Test
    @DisplayName("arrayList의 일반 for-each-lambda-loop를 확인한다.")
    public void arrayListForEachLambdaLoop() {
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getArrayListValue();
        int size = listValue.size();
        listValue.forEach(integer -> { Integer a = integer; });
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    @Test
    @DisplayName("linkedList의 일반 for-loop를 확인한다.")
    public void linkedListForLoop(){
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getLinkedListValue();
        int size = listValue.size();
        for(int i=0;i<size;i++){
            Integer integer = listValue.get(i);
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    @Test
    @DisplayName("linkedList의 일반 for-enhance-loop를 확인한다.")
    public void linkedListForEnhanceLoop(){
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getLinkedListValue();
        int size = listValue.size();
        for (Integer integer : listValue) {
            Integer a = integer;
        }
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    @Test
    @DisplayName("linkedList의 일반 for-each-lambda-loop를 확인한다.")
    public void linkedListForEachLambdaLoop() {
        long beforeTime = System.currentTimeMillis();
        List<Integer> listValue = value.getLinkedListValue();
        int size = listValue.size();
        listValue.forEach(integer -> { Integer a = integer; });
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
