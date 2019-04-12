package LeetCode.problem;

/**
 * 就是求是不是3的幂
 */
public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n!=1){
            if (n%3==0){
                n/=3;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 题目要求不能使用循环或者递归，这里需要用到数学的一点小技巧。

     首先如果n《=0，那么一定返货false

     如果n是3的x次方，那么y=log3(n)一定是一个整数，而且3^y一定等于n

     在java里没有底为3的log对数运算，所以这里需要用到换底公式
     * @param n
     * @return
     */
    public boolean isPowerOfThreeII(int n) {
        if (n <= 0) {
            return false;
        }
        if (Math.pow(3, Math.round(Math.log(n) / Math.log(3))) == n) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThreeIII(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
            return ( n>0 &&  1162261467%n==0);
    }
}
