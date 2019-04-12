package interview.wangyi;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 14:12
 */
public class Fangkuai {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int grid[] = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m ;i++) {
            int k = scanner.nextInt();
            grid[k]++;

        }
        for (int i = 1; i <=n; i++)
            if (grid[i]<min)
                min=grid[i];
        System.out.println(min);
    }
}
