package interview.wangyi2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 11:17
 * @Description:
 **/
public class ShangkeZhishidian {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int base = 0;
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            if (b[i] ==1)
                base+=a[i];
        }
        //System.out.println(base);

        int d =0;
        int max = 0;
        while(d<=n-k) {
            if (b[d]==0) {
                int tmp =base;
                int i = 0;
                while (i<k) {
                    if (d+i>=n)
                        break;
                    if (b[d+i] ==0){
                        tmp+=a[d+i];
                    }
                    i++;
                }

                if (max<tmp)
                    max = tmp;
            }
           // System.err.println(d);
            d++;

        }
        int e = base;
        while (d<n) {
            if (b[d]==0){
                e+=a[d];
            }
            d++;
        }
        if (max<e)
            max = e;
        if (max ==0 ) {
            max = base;
        }
        System.out.println(max);

    }
}
