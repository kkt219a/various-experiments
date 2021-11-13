package effective.chapter8.item50;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {
    Period period = null;
    @Test
    public void attacksMultiThread() throws Exception {
        Date start = new Date();
        Date end = new Date();
        CountDownLatch cd1 = new CountDownLatch(1);
        CountDownLatch cd2 = new CountDownLatch(1);
        CountDownLatch cd3 = new CountDownLatch(1);
        new Thread(() -> {
            period = new Period(start, end, cd1,cd2);
            cd3.countDown();
        }).start();
        // Period 생성자에서 검증이 끝나면 통과
        cd1.await();
        end.setTime(1);
        // end 기간을 바꾸고 저장
        cd2.countDown();
        // 객체가 만들어지기 전까지 대기
        cd3.await();
        assertFalse(period.start().before(period.end()));
    }

    @Test
    public void attacks() {
        DateChild startChild = new DateChild();
        Date end = new Date();
        // 시작일을 하위클래스로 지정하고, static 리스트에 값 저장
        startChild.addDates(startChild,end);
        Period period = new Period(startChild, end);
        List<Date> attackDates = DateChild.getAttackDates();
        //static 리스트의 값을 변경
        attackDates.get(0).setTime(1);
        // 객체가 변경되어 참조하고 있는 모든 date가 시간이 변경
        // 전부 1970년을 반환
        System.out.println("period.start() = " + period.start());
        System.out.println("start = " + startChild);
        System.out.println("attackDates = " + attackDates.get(0));
    }

}