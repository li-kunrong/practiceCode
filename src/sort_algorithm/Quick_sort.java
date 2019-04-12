package sort_algorithm;

/**
 * @author kunrong
 * @date 2019/2/16 19:14
 */
public class Quick_sort {
    public static void main(String[] args){
        int[] array = {1,2,4,6,5,9,8,7,3};
        quickSort(array,0, 8);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static void quickSort(int []array, int start, int end) {
        if (start >= end)
            return ;
        int pivot = partion(array, start,end);
        quickSort(array,start,pivot-1);
        quickSort(array,pivot+1,end);
    }

    public static int partion(int[] array, int low, int high) {
        int pivot = array[low];//枢轴纪录
        while (low<high) {
            while (low<high && array[high]>pivot) --high;
            array[low] = array[high];//交换比枢轴小的
            while (low<high && array[low]<pivot) ++low;
            array[high] = array[low];//交换比枢轴大的
        }
        array[low] = pivot;
        //返回枢轴的位置
        return low;
    }
}
