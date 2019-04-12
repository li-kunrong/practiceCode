package Sword_to_offer.problem;

public class MoreHalf_number {
    /**
     * 遇到相同的count就+1，不相同的减一，count等于0时设置num为当前array[i]，同时count设置为1
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        if (array.length ==1){
            return array[0];
        }
        int num = 0;
        int count = 1;
        num = array[0];
        for (int i = 1 ;i < array.length; i++) {
            if (array[i] == num){
                count++;
            }else{
                count--;
            }
            if (count==0){
                num = array[i];
                count=1;
            }
        }
        count = 0;
        for (int i : array) {
            if (i == num){
                count++;
            }
        }
        if (count>array.length/2)
            return num;
        else
            return 0;
    }
}
