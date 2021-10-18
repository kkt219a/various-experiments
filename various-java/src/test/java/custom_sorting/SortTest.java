package custom_sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SortTest {
    private final int[] arrays = new int[60000];

    @BeforeEach
    public void init(){
        for(int i=0;i< arrays.length;i++){
            arrays[i] = (int)(Math.random() * arrays.length);
        }
    }

    @Test
    @DisplayName("버블 정렬")
    public void bubble() throws Exception {
//        System.out.println("arrays = " + Arrays.toString(arrays));
        CustomSort.bubbleSort(arrays);
//        System.out.println("arrays = " + Arrays.toString(arrays));
    }

    @Test
    @DisplayName("선택 정렬")
    public void select() throws Exception {
//        System.out.println("arrays = " + Arrays.toString(arrays));
        CustomSort.selectSort(arrays);
//        System.out.println("arrays = " + Arrays.toString(arrays));
    }

    @Test
    @DisplayName("삽입 정렬")
    public void insert() throws Exception {
//        System.out.println("arrays = " + Arrays.toString(arrays));
        CustomSort.insertSort(arrays);
//        System.out.println("arrays = " + Arrays.toString(arrays));
    }

}