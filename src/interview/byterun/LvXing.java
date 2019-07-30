package interview.byterun;

import java.util.Scanner;

public class LvXing {
    private static int minNum  =Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0;j < n; j++) {
                a[i][j] = input.nextInt();
            }
        }

        for (int i = 1; i < n; i++) {
            dfs(a, 0, i, 1,a[0][i]);
        }

        System.out.println(minNum);

    }

    public static void dfs(int[][] a, int row, int col, int count, int value){
        if (count == a.length-1) {
            value+=a[col][0];
            if (value<minNum)
                minNum = value;
            return;
        }

        int []temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i][col];
            a[i][col] = -1;
        }
        int j = 1;
        for (; j <a.length; j++) {
            if (a[col][j]!=0&&a[col][j]!=-1) {
                dfs(a,col,j,count+1,value+a[col][j]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i][col] = temp[i];
        }


    }

}
