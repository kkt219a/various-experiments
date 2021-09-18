package effective.chapter3.item10;

import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.util.Date;

public class SqlTimeStamp {
    public static void main(String[] args) throws MalformedURLException {
        Timestamp timestamp = new Timestamp(1000);
        Date date = new Date((1000 / 1000) * 1000);
        // 대칭성 위배
        System.out.println(date.equals(timestamp)); // true
        System.out.println(timestamp.equals(date)); // false
    }
}
