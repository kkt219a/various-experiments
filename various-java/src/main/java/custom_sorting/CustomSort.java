package custom_sorting;

import java.util.Arrays;

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
            for(;j>=0&&arrays[j]>tmp;j--){
                arrays[j+1] = arrays[j];
            }
            arrays[j+1] = tmp;
        }
        return arrays;
    }

//    public static void quickSort(int[] arrays, int left, int right) {
//        // 원소가 1개인 경우
//        if(left >= right)
//            return;
//        int pivot = partition(); // 첫번째 값으로 할거면 left, 마지막 값으로 하려면 right 하면 됨
//        quickSort(arr);
//    }
//
//    private static int partition(i)

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
//        System.out.println(arr[mid]+"왼쪽");
        sort(arr, low, mid - 1);
//        System.out.println(arr[mid]+"오른쪽");
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
//        System.out.println("pivot = " + pivot);
        while (low <= high) {
            while (arr[low] < pivot) low++;
            while (arr[high] > pivot) high--;
//            System.out.println("low = " + low);
//            System.out.println("high = " + high);
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
//        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        System.out.println("low = " + low);
//        System.out.println("high = " + high);
//        System.out.println();
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /** merge sort 시작 **/
    public static void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] L = Arrays.copyOfRange(arr, left, mid + 1), R = Arrays.copyOfRange(arr,mid+1,right+1);
        int ls = 0, rs = 0, now = left, lsSize = L.length, rsSize = R.length;
        while(ls<lsSize&&rs<rsSize){
            if(L[ls]<=R[rs]){
               arr[now] = L[ls++];
            }else{
                arr[now] = R[rs++];
            }
            now++;
        }
        while(ls<lsSize){
            arr[now++] = L[ls++];
        }
        while(rs<rsSize){
            arr[now++] = R[rs++];
        }
    }

}
