package sort_algorithm;

/**
 * @author kunrong
 * @date 2019/2/16 17:02
 */
public class Select_sort {

    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7};
        int [] newArray = selectSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }


    }

    public  static  int[] selectSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
