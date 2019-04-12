package Sword_to_offer.jumpFloor;

public class JumpFloorI {
    /**
     * 题目描述
     一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target <= 0){
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int result = 1;
        for (int i = target-1; i >=1; i--) {
            result += JumpFloorII(i);
        }
        return result;
    }
}
