package Sword_to_offer;

/**
 * 题目描述
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    /**
     * 方法一：开启两个数组来分别奇偶
     * @param array
     */
    public void reOrderArray(int [] array) {
        int []a1 = new int[array.length];
        int []a2 = new int[array.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i< array.length ; i++) {
            if (array[i]%2 == 1) {
                a1[j++] = array[i];
            }else{
                a2[k++] = array[i];
            }
        }
        for (int i = 0; i < j; i++) {
            array[i] = a1[i];
        }
        for (int i = 0 ; i < k; i++) {
            array[j+i] = a2[i];
        }

    }


}
