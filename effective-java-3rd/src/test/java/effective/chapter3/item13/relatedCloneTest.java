package effective.chapter3.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class relatedCloneTest {
    
    @Test
    @DisplayName("clone은 같은 클래스지만 실제 참조 주소는 다르다. equals 재정의가 없으니 다르다.")
    public void genericClone() throws Exception {
        //given
        TestClone original = new TestClone(1);
        TestClone clone = original.clone();

        //then
        assertNotSame(clone,original); // !=
        assertSame(clone.getClass(),original.getClass()); // ==
        assertNotEquals(clone, original); // !equals
    }

    @Test
    @DisplayName("레퍼런스 String은 같은 주소와 값을 참조하지 않는다.")
    public void stringReferenceNEq() throws Exception {
        //given
        String[] original = {"hi0","hi1","hi2"};
        String[] clone = original.clone();
        //when
        original[0] = "hi4";
        //then
        assertNotSame(System.identityHashCode(original[0]),System.identityHashCode(clone[0])); // !=
        assertNotSame(original[0],clone[0]); // !=
        assertNotEquals(original,clone); // !equals
    }

    @Test
    @DisplayName("레퍼런스 Integer와 프리미티브 int는 같은 주소와 값을 참조하지 않는다.")
    public void integerRefAndIntPrimitiveNEq() throws Exception {
        //given
        Integer[] originalReference = {1,2,3};
        //int[] originalPrimitive = {4,5,6};
        Integer[] cloneReference = originalReference.clone();
        //int[] clonePrimitive = originalPrimitive.clone();
        //when
        originalReference[0] = 7;
        //originalPrimitive[0] = 8;
        //then
        System.out.println("System.identityHashCode(originalReference[0]) = " + System.identityHashCode(originalReference[0]));
        System.out.println("System.identityHashCode(cloneReference[0]) = " + System.identityHashCode(cloneReference[0]));
        assertAll(
                () -> assertNotSame(originalReference[0],cloneReference[0]),
                //() -> assertNotSame(originalPrimitive[0],clonePrimitive[0]),
                //() -> assertNotEquals(originalPrimitive,clonePrimitive),
                () -> assertNotEquals(originalReference, cloneReference)
        );
    }

    @Test
    @DisplayName("(?)커스텀 레퍼런스는 같은 참조를 하고있다.")
    public void customReferenceEquals() throws Exception {
        //given
        TestClone[] original = {new TestClone(1),new TestClone(2),new TestClone(3)};
        TestClone[] clone = original.clone();
        //when
        original[0].setNumber(4);
        //then
        System.out.println("clone[0].getNumber() = " + clone[0].getNumber());
        System.out.println("original = " + original[0].getNumber());
        System.out.println("clone = " + clone[0]);
        System.out.println("original = " + original[0]);
        //assertNotSame(original[0].getNumber(),clone[0].getNumber()); // 4 ! = 1
        //assertNotEquals(original[0],clone[0]); //
    }

    @Test
    @DisplayName("커스텀 레퍼런스는 깊은 복사를 사용해야한다.")
    public void customReferenceDeepCopy() throws Exception {
        //given
        TestClone[] original = {new TestClone(1),new TestClone(2),new TestClone(3)};
        TestClone[] cloneShallow = original.clone();
        TestClone[] cloneDeep = new TestClone[original.length];
        for(int i=0,j=cloneDeep.length;i<j;i++){
            cloneDeep[i] = original[i].clone();
        }
        //when
        cloneDeep[0].setNumber(4);
        original[0].setNumber(5);
        //then
        assertSame(original[0],cloneShallow[0]);
        assertNotSame(cloneDeep[0],cloneShallow[0]);
        assertSame(original[0].getNumber(),cloneShallow[0].getNumber());
        assertNotSame(cloneDeep[0].getNumber(),cloneShallow[0].getNumber());

    }


    @Test
    @DisplayName("clone 호출 시 배열도 따로 복제하면 원본과 같은 참조를 갖지 않는다.")
    public void stackElementNotShare() throws Exception {
        //given
        String[] value = {"hi", "hi2", "hi3"};
        Stack original = new Stack();
        for (String val : value)
            original.push(val);
        Stack copy = original.clone();
        //when
        copy.changeFirstElement("change!");
        //then
        assertNotEquals(copy.getElements()[0], original.getElements()[0]);
        assertNotSame(copy.getElements(), original.getElements());
    }

}
