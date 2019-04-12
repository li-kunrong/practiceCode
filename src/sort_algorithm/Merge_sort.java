package sort_algorithm;

import java.util.Arrays;

/**
 * @author kunrong
 * @date 2019/2/16 18:42
 */
public class Merge_sort {
    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7,3};
        int[] newArray = mergeSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }
    }

    public static int[] mergeSort(int []array) {
        if (array.length<2) {
            return array;
        }
        int len = array.length;
        int mid = len/2;
        int []left = Arrays.copyOfRange(array,0,mid);
        int []right = Arrays.copyOfRange(array,mid,len);
        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int []left, int []right) {
        int[] result = new int[left.length+right.length];
        int l=0;
        int r = 0;
        for (int i = 0 ; i < left.length || i<result.length; i++) {
            if (l>=left.length){
                result[i] = right[r++];
            }else if (r>=right.length) {
                result[i] = left[l++];
            }else if (left[l]<right[r]){
                result[i] = left[l++];
            }else {
                result[i] = right[r++];
            }
        }
        return result;
    }
}
