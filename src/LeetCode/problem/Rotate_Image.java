package LeetCode.problem;


/**
 * You are given an n x n 2D matrix representing an image.
 *Rotate the image by 90 degrees (clockwise).
 *Note:
 *You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 *DO NOT allocate another 2D matrix and do the rotation.
 * 把数组翻转九十度，不能新开矩阵。
 * 思路：先将数组对角线翻转，然后改变列的位置。
 */
public class Rotate_Image {
    public static void main(String[] args) throws Exception {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Rotate_Image().rotate(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.println(A[i][j]);
            }
        }
    }

    /**
     * 简单解法
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i ; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        int n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0 ; j < matrix[i].length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }



    }

    /**
     * 高手一个循环解决的。
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int lc = 0, tr = 0, rc = matrix[0].length - 1, br = matrix.length - 1;
        while (tr < br) {
            for (int i = lc, j = tr, k = rc, l = br; i < rc && j < br && k > lc && l > tr; i++, j++, k--, l--) {
                int temp1 = matrix[j][rc];
                matrix[j][rc] = matrix[tr][i];
                int temp2 = matrix[br][k];
                matrix[br][k] = temp1;
                temp1 = matrix[l][lc];
                matrix[l][lc] = temp2;
                matrix[tr][i] = temp1;
            }
            lc++;
            tr++;
            rc--;
            br--;
        }
    }
}
