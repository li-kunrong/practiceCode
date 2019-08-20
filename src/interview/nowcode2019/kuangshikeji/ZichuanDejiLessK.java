package interview.nowcode2019.kuangshikeji;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 14:44
 * @Description:
 **/
public class ZichuanDejiLessK {

    public static int getNumberOfMultiplySmallerThanK(int[] array, int k, int index, int multiply) {
        //递归退出条件
        if (index >= array.length) {
            return multiply < k ? 1 : 0;
        }   //索引为index的数要
        return getNumberOfMultiplySmallerThanK(array, k, index + 1, multiply * array[index]) + //索引为index的数不要
                getNumberOfMultiplySmallerThanK(array, k, index + 1, multiply);
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfMultiplySmallerThanK(new int[]{1, 2, 3, 4}, 10, 0, 1) - 1);
        System.out.println(getNumberOfMultiplySmallerThanK(new int[]{4, 8, 7, 2}, 50, 0, 1) - 1);
    }
}
