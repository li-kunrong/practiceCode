package interview.weizhong;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/11 20:28
 */
public class Q2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        if (n>m) {
            int j = n*k;
            int res =j/m;
            if (j%m==0) {
                System.out.println(res);
            }else  {
                System.out.println(res+1);
            }
        }else if (n<=m){
            System.out.println(k);
        }


    }
}
