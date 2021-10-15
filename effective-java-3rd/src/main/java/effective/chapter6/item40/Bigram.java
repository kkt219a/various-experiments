package effective.chapter6.item40;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.*;

// 코드 40-1 영어 알파벳 2개로 구성된 문자열(바이그램)을 표현하는 클래스 - 버그를 찾아보자. (246쪽)
public class Bigram implements Serializable {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first  = first;
        this.second = second;
        Bigram2 bi = new Bigram2('a','b');
        try {
            ObjectOutputStream a = new ObjectOutputStream(new OutputStream() {
                @Override
                public void write(int b) throws IOException {

                }
            });
            a.writeObject(bi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());

        ChildClass childClass = new ChildClass();
        childClass.giveFood();
        childClass.giveMoney();
        childClass.giveHouse();
    }
}
