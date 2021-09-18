package effective.chapter3.item13;

public class AA implements Cloneable{

    public AA(){
        System.out.println("true = " + true);
    }

    @Override
    protected AA clone() {
        try {
            return (AA) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
