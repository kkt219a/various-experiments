package custom_sorting;

public class CustomSort {

    /**
     * 버블(교환)정렬: 모든 순간 O(N^2)
     * 버블은 매번 n번 체크하니 n^2
     * **/
    public static int[] bubbleSort(int[] arrays){
        for(int i=0;i< arrays.length;i++){
            for(int j=1;j< arrays.length-i;j++){
                if(arrays[j-1]>arrays[j]){
                    int tmpValue = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = tmpValue;
                }
            }
        }
        return arrays;
    }

    /**
     * 선택정렬: 모든 순간 O(N^2)
     * 선택은 뒤만보니까 n(n+1)/2
     * **/
    public static int[] selectSort(int[] arrays){
        for(int i=0;i< arrays.length;i++){
            int minIdx = i;
            for(int j=i+1;j< arrays.length; j++){
                if(arrays[minIdx]>arrays[j]){
                    minIdx = j;
                }
            }
            int tmp = arrays[minIdx];
            arrays[minIdx] = arrays[i];
            arrays[i] = tmp;
        }
        return arrays;
    }

    /**
     * 최선: n(매번 순서가 다 맞을 경우), 그 외 n^2
     */
    public static int[] insertSort(int[] arrays){
        for(int i=1;i< arrays.length; i++){
            int tmp = arrays[i], j=i-1;
            for(;j>=0&&arrays[j]>=tmp;j--){
                arrays[j+1] = arrays[j];
            }
            arrays[j+1] = tmp;
        }
        return arrays;
    }

}
