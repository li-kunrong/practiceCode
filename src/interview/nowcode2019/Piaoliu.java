package interview.nowcode2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/13 10:27
 * @Description:
 **/
public class Piaoliu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;
        int a[] = new int[n];
        int limit = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        int l =0;
        int r = n-1;
        int res = 0;
        while (l<r){
            if (a[l]+a[r]<=limit) {
                a[l++]=-1;
                a[r--] = -1;
                res+=1;
            }else {
                r--;
            }
        }
        for (int i = 0 ; i < n; i++) {
            if (a[i]!=-1)
                res++;
        }
        System.out.println(res);
    }
}
