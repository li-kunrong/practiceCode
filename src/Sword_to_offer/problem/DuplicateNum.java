package Sword_to_offer.problem;

import javafx.scene.layout.Pane;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNum {
    /**
     * 首先，因为1~n-1,所以获取index，再用numbers[index]进行+length，如果再次遇到numbers[index]大于length时，证明已经访问过了，直接返回index
     * time O(n)
     * zone(O(1)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int index = 0;
        for(int i = 0; i < length; i++){
            index = numbers[i];
            if (index >= length)
                index -=length;
            if (numbers[index] >= length){
                duplication[0] = index;
                return true;
            }
            numbers[index]+=length;

        }
        return false;
    }



    //boolean只占一位，所以还是比较省的
    //或者采取map的方法
    public boolean duplicateII(int numbers[], int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {1,1,2, 2,3,4, 3, 4,5,5,9,8};
        System.out.println(new DuplicateNum().countNoDuplicate(array));
    }

    public int countNoDuplicate(int[] array) {
        int result = 0;
        int index = 0;
        int len = array.length;
        for (int i = 0; i < array.length; i++) {
            index = array[i];
            while(index> len) {
                index-=len;
            }
            //System.out.println(index-1);
            array[index-1] +=len;

        }
        for (int i = 0; i < array.length; i++) {
            //array[i] -= len;
            if (array[i] >= 2*len) {
                result+=(array[i]/len);
            }
        }
        result = len - result;
        return  result;
    }
}
