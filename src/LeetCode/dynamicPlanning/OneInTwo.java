package LeetCode.dynamicPlanning;

/**
 * @Author: kunrong
 * @Date: 2019/8/19 17:05
 * @Description:
 **/
public class OneInTwo {
    public static void main(String[] args) {

    }

    public int[] countBits(int num){
        int[] res = new int[num + 1];
        int pow2 = 1;
        int before = 1;
        for(int i = 1; i <= num;i++){
            if(i == pow2){
                before = res[i]  = 1;
                pow2 <<= 1;
            }else{
                res[i] = res[before] + 1;
                before += 1;
            }
        }
        return res;
    }
}
