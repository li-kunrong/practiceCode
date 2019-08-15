package interview.nowcode2019.shopee;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/14 14:09
 * @Description:
 *
 *  如果一分钟跑完则每分钟最多跑序列的总和步 right
 *  如果n分钟跑完则每分钟最多跑序列中最大数的步数 left
 *  问题转换为在[left, right]中找到一个左边界数，使得步数最小又能在规定的时间内跑完
 **/
public class Jianfei {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int a[] = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n;i++) {
            a[i] = s.nextInt();
            left = Math.max(left,a[i]);
            right+=a[i];
        }
        binary(n,m,left,right,a);

    }

    static void binary(int n, int m, int left,int right,int []a) {
        int mid = 0;
        while (left<=right) {
            mid = left+(right-left)/2;
            int num =0;
            for (int k = 0; k < n; ) {
                int sum = 0;
                while (k<n&&sum+a[k]<=mid) sum+=a[k++];
                num++;
                if (num>m)
                    break;
            }
            if (num>m){
                left=mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(mid);
    }
}
