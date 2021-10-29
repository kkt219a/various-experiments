package effective.chapter4.item19;

import java.io.Serializable;

// 재정의 가능 메서드를 호출하는 생성자 - 따라 하지 말 것! (115쪽)
public class Super {
    // 잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
    public Super() {
        privateHelpMethod();
    }
    public void overrideMe() {
        privateHelpMethod();
    }
    private void privateHelpMethod(){
        System.out.println("help!");
    }
}
