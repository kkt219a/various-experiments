package effective.chapter9.item57;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForProfit {
    public static void main(String[] args) {
        //1
        List<Integer> lists = IntStream.range(0,3).boxed().collect(Collectors.toList());
        // 순회에는 좋으나 삭제는?
        for (Integer list : lists) { }
        // 다양한 상황에 유연
        for(Iterator<Integer> i = lists.iterator();i.hasNext();){
            Integer next = i.next();
        }
        //2
        for(int i=0;i<2;i++);
        // 조건문에 j 대신 i를 썼으나 컴파일 타임에 바로 잡힘
//        for(int j=0;i<5;j++);
        int k=0;
        while(k<lists.size()){
            if(lists.get(k)==0)
                break;
            k++;
        }
        int k2=0;
        // k2를 사용해야하는데 k를 사용해버리기
        while(k<lists.size()){
            if(lists.get(k2)==0){
                break;
            }
            k2++;
        }

        //3
        for(int i=0;i<3;i++);
        for(int i=2;i<5;i++);
        for(int i=4;i<7;i++);
        //4
        for(int i=0, n=expensiveComputation();i<n;i++);
    }

    private static int expensiveComputation() {
        return 0;
    }

}
