package effective.chapter3.item13;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class TestClone implements Cloneable{
    private int number;
    public TestClone(int number){
        this.number = number;
    }
    @Override
    public TestClone clone() {
        try {
            return (TestClone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
