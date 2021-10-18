package effective.chapter4.item18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// 잘못 설계된 Properties 사용
public class KTae {
    private Long age;
    public KTae(Long age) {
        this.age = age;
    }
    public static void main(String[] args) {
        Properties p = new Properties();
        KTae ktae = new KTae(25L);
        //Properties의 상위 클래스인 HashTable의 메소드를 물려받아서 넣음
        p.put("KTaeObj",ktae);
        // 아래 코드는 key/value 모두 String이라 '우연히' 문제가 없음
        p.put("kTaeString","kkt");
        // Properties의 상위 클래스인 HashTable의 메소드를 물려받아 정상출력
        System.out.println("p.get(\"KTaeObj\") = " + p.get("KTaeObj"));
        System.out.println("p.get(\"ktae\") = " + p.get("kTaeString"));
        // KtaeObj는 String value가 아니기에 null 출력, 원래 Properties가 쓰기로 기대됐던 것
        System.out.println("p.getProperty(\"KTaeObj\") = " + p.getProperty("KTaeObj"));
        System.out.println("p.getProperty(\"ktae\") = " + p.getProperty("kTaeString"));
        //원래 Properties가 쓰기로 기대됐던 것
        p.setProperty("KTae","KTae");
        try {
            // String이 아닌 객체가 value나 key에 있으면 ClassCastException을 던지게됨
            p.store(new FileOutputStream("ktaePropertiesTest.txt"),"hihi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
