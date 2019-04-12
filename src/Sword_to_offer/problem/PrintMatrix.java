package Sword_to_offer.problem;

import java.util.ArrayList;

public class PrintMatrix {

    public static void main(String[] args){
        int [][]num = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new PrintMatrix().printMatrix_2(num));
    }

    /**
     * 采用旋转魔方的方式 一次取一行，然后旋转
     */
    public ArrayList<Integer> printMatrix_2(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        while (row != 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                al.add(matrix[0][i]);
            }
            if (row == 1)
                break;
            matrix = turn(matrix);
            row = matrix.length;
        }
        return al;
    }

    private int[][] turn(int[][] matrix) {
        // TODO 自动生成的方法存根
        int col = matrix[0].length;
        int row = matrix.length;
        int[][] newMatrix = new int[col][row - 1];
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 1; i < row; i++) {
                newMatrix[col - 1 - j][i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }


    public ArrayList<Integer> printMatrix_1(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();
        int row = matrix.length;
        if (row == 0)
            return al;
        int col = matrix[0].length;
        // 短的边/2，向上取整
        int circle = ((row > col ? col : row) + 1) / 2;
        for (int i = 0; i < circle; i++) {

            // 从左向右打印，j=i; j<col-i,
            // 这一行的前i个已经在第i圈从下往上被打印，故j=i
            // 倒数i个都已经在第i圈从上往下被打印，故j=col-i-1<col-i
            for (int j = i; j < col - i; j++)
                al.add(matrix[i][j]);

            // 从上往下打印，j=i+1;j<row-i,
            // 这一列的前i+1个已经在从左向右打印时被打印,故j=i+1
            // 倒数i个已经在第i圈从右往左被打印,故j=row-i-1<row-i
            for (int j = i + 1; j < row - i; j++)
                al.add(matrix[j][col - i - 1]);

            // 从右往左打印，j=col-i-2;j>=i&&row-i-1!=i;，
            // 这一行倒数i个已经在第i圈从上往下被打印
            // 这一行倒数第i+1个已经在从上往下时被打印，故j=col-1-(i+1)=col-i-2
            // 这一行的前i个已经在从下往上时被打印，故j=i>=i
            // 当第i圈为0时即从未由上往下打印时，col有多列时，会造成重复打印，故判断row-i-1!=i以避免
            for (int j = col - i - 2; j >= i && row - i - 1 != i; j--)
                al.add(matrix[row - i - 1][j]);

            // 从下往上打印，j=row-i-2;j>i&&col-i-1!=i，
            // 这一列倒数i个已经在第i圈从右往作被打印
            // 这一列倒数第i+1个已经在从右往左时被打印，故j=row-1-(i+1)=row-i-2
            // 这一列的前i个已经在第i圈从左往右时被打印，
            // 这一列的第i+1个已经在本圈从左往右被打印，故j=i+1>i
            // 当第i圈为0时即从未由右向左打印时，row有多行时，会造成重复打印，故判断col-i-1!=i以避免
            for (int j = row - i - 2; j > i && col - i - 1 != i; j--)
                al.add(matrix[j][i]);
        }
        return al;
    }
}
