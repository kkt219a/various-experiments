package effective.chapter8.item50;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateChild extends Date implements Cloneable{
    private static List<Date> dates = new ArrayList<>();
    @Override
    public DateChild clone() {
        return this;
    }
    public void addDates(Date start, Date end){
        dates.add(start);
        dates.add(end);
    }
    public static List<Date> getAttackDates() {
        return dates;
    }
}
