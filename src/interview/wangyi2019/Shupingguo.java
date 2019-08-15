package interview.wangyi2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 13:57
 * @Description:
 **/
public class Shupingguo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int a[] = new int[n];
        int sum[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        sum[0] = a[0];
        for (int j = 1; j < n; j++) {
            sum[j]=sum[j-1]+a[j];
        }
        int k = scanner.nextInt();
        int []b = new int[k];
        for (int i = 0; i < k ; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i= 0; i <k ; i++) {
            int index = find(sum,b[i]);
            System.out.println(index+1);
        }


    }
    static  int find(int[] a, int b) {
        int l = 0;
        int r = a.length-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (a[mid]==b)
                return mid;
            else if (a[mid] > b)
                r = mid;
            else
                l = mid+1;
        }

        return l;
    }
}
