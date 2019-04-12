package sort_algorithm;

/**
 * @author kunrong
 * @date 2019/2/16 17:19
 */
public class Insert_sort {

    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7};
        int[] newArray = insertSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }
    }
    public static int[] insertSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current= 0;
        for (int i = 0; i < array.length-1; i++) {
            int preIndex = i;
            current =array[i+1];
            while (preIndex>=0&& current<array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return  array;
    }
}
