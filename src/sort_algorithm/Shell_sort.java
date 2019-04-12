package sort_algorithm;

/**
 * @author kunrong
 * @date 2019/2/16 17:38
 */
public class Shell_sort {
    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7,3};
        int[] newArray = shellSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }
    }
    public static int[] shellSort(int[] array) {
        if (array.length== 0)
            return array;
        int len = array.length;
        int gap = len/2;
        while (gap>0) {
            for (int i = gap; i<len; i+=gap) {
                int tmp = array[i];
                int preIndex = i-gap;
                while (preIndex>=0 && array[preIndex] > tmp) {
                    array[preIndex+gap] = array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap] = tmp;
            }
            gap/=2;
        }
        return array;
    }
}
