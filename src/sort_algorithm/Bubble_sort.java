package sort_algorithm;

/**
 * @author kunrong
 * @date 2019/2/16 16:41
 */
public class Bubble_sort {

    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7};
        int [] newArray = new Bubble_sort().bubbleSort(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]);
        }


    }

    public int[] bubbleSort(int[] array) {
        if (array.length==0)
            return array;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
}
