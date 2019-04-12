package Sword_to_offer.Array;

/**
 * 题目描述
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author kunrong
 * @date 2019/2/26 18:09
 * 解决：
 * 重点是在排序问题，已经排好序，我们可以从左下角开始，
 * array[i][j] < target 就j++
 * >target 就i--
 * ==target 就返回true；
 */
public class FindTargetInTheArray {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0|| array[0] == null || array[0].length == 0){
            return false;
        }
        int len = array.length-1;
        int len2 = array[0].length-1;
        if (array[0][0] > target)
            return false;
        if (array[len][len2] < target)
            return false;
        int i = len;
        int j = 0;
        while (i >= 0 && j <= len2){
            if (array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                j++;
            }else{
                i--;
            }
        }
        return false;

    }
}
