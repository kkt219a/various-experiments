package effective.chapter4.item19;

public class NewList {

    public int binarySearch(int[] obj, int key){
        int low = 0, high = obj.length;
        while(low<=high){
            int mid = (low+high) / 2 ;
            if(obj[mid]==key){
              return mid;
            } else if(key<obj[mid]){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
