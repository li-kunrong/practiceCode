package interview.wangyi2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/3 15:51
 */
public class XianglinshuZhihe {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            for (int i = 0; i< n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            int[] b = new int[n];
            int len = n-1;
            boolean flag = true;
            int half = n/2;
            b[half] = a[len];
            int j = 1;
            while (len>0) {
                if (len<=0){
                    break;
                }
                b[half-j] = a[--len];
                if (len<=0){
                    break;
                }
                b[half+j] = a[--len];
                j++;
            }

            for (int k = 1; k <n-1; k++) {
                if (b[k-1]+b[k+1]<b[k]){
                    flag = false;
                    break;
                }
            }
            if (b[0]>b[n-1]+b[1] || b[n-1]>b[n-2]+b[0]) {
                flag = false;
            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
