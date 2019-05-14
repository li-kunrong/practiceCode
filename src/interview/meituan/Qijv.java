package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/23 20:08
 */
public class Qijv {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }


    }
}
