package Sword_to_offer.problem;

public class GetKthNumFromSortArray {
    public static void main(String[] args){
        int []a = {1,4,4,4,5,6,6,7,8,9,9,9};
        System.out.println(new GetKthNumFromSortArray().GetNumberOfK(a,4));
    }
    /**
     * get到开始和结束的k就好
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0|| k <0){
            return 0;
        }
        int start = getStart(array,k);
        int last = getLast(array,k);
        return last-start+1;
    }
    int getStart(int[] array,int k){
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while (start <= end){
            mid = (start+end)>>1;
            if (array[mid]<k){
                start =mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }

    int getLast(int[] array,int k){
        int start = 0;
        int end = array.length-1;
        int mid = 0;
        while (start <= end){
            mid = (start+end)>>1;
            if (array[mid]<=k){
                start =mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
}
