package Sword_to_offer.problem;

public class ProductArray {
    /**
     *
     剑指的思路：
     B[i]的值可以看作下图的矩阵中每行的乘积。
     下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int  b[] = new int [A.length];
        int len = A.length;
        if (len != 0){
            b[0] = 1;
            for (int i = 1; i < len; i++){//左下三角
                b[i] = b[i-1]*A[i-1];
            }

            int temp = 1;
            for (int k = len-2; k>=0; k--){ //上三角，并且乘到数组中
                temp *= A[k+1];
                b[k] *= temp;
            }
        }
        return b;
    }
}
