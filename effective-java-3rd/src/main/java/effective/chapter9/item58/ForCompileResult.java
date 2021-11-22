package effective.chapter9.item58;

import java.util.List;

public class ForCompileResult {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1, 2, 3);
        for (Integer number : numberList) {
           int a = number+2;
        }
    }
}
