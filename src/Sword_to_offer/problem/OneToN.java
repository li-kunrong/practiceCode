package Sword_to_offer.problem;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class OneToN {
    /**
     * 利用&&逻辑短路和递归实现
     * 当n==0时，直接返回0
     * 当n>=0时，执行(sum+=Sum_Solution(n-1))>0
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
