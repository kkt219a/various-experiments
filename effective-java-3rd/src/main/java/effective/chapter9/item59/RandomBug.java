package effective.chapter9.item59;
import java.util.*;

// 무작위 수 생성은 쉽지 않다.
public class RandomBug  {
    // 코드 59-1 흔하지만 문제가 심각한 코드! (351쪽)
    static Random rnd = new Random();


    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    // 무작위 수 1백만 개 생성 후, 중간 값보다 작은 수의 개수 출력 (351쪽)
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        // int n = 1342177329;
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (rnd.nextInt(n) < n/2)
                low++;
        System.out.println(low);

        int low2 = 0;
        for (int i = 0; i < 1000000; i++)
            if (random(n) < n/2)
                low2++;
        System.out.println(low2);

        Map<Integer,Integer> numbers = new HashMap<>();
        Map<Integer,Integer> numbers2 = new HashMap<>();

        for (int i = 0; i < 10000; i++){
            int number = Math.abs(rnd.nextInt())%8;
            int number2 = rnd.nextInt(8);
            //System.out.println("number = " + number);
            numbers.put(number,numbers.getOrDefault(number,0)+1);
            numbers2.put(number2,numbers2.getOrDefault(number2,0)+1);

        }
        for (Map.Entry<Integer, Integer> en : numbers.entrySet()) {
            System.out.println("en = " + en);
        }
        for (Map.Entry<Integer, Integer> en : numbers2.entrySet()) {
            System.out.println("en = " + en);
        }

        // 11101100
    }
}
