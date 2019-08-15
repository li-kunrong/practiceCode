package interview.wangyi2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 11:04
 * @Description:
 **/
public class ELuoSiFangKuai {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] =new int[m];
        int b[] =new int[n+1];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[a[i]]++;
        }
        int min =Integer.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            if (b[k]<min) {
                min = b[k];
            }
        }
        System.out.println(min);



    }
}
