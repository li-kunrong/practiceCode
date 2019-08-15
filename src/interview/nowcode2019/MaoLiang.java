package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 14:39
 * @Description:
 **/
public class MaoLiang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1[] = s.split(" ");
        int h = scanner.nextInt();
        int n = s1.length;
        int a[] = new int[s1.length];
        int max = Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s1[i]);
            max = Math.max(a[i],max);
            sum+=a[i];
        }
        if (n>h){
            System.out.println(-1);
        }else if (n==h){
            System.out.println(max);
        }else {
            int tmp = 0;
            for (int i =max-1; i>=1;i--) {
                int res = solve(a,i);
                if (res>h){
                    break;
                }
                tmp = i;

            }
            System.out.println(tmp);
        }

    }

    static int solve(int []a, int i) {
        int ret = 0;
        for (int k = 0; k < a.length; k++) {
            ret+=(a[k]/i);
            ret+=(a[k]%i==0?0:1);
        }
        return ret;
    }
}
