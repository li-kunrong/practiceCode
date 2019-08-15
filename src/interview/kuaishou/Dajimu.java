package interview.kuaishou;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/8 10:54
 * @Description:
 *
 *
 * 小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
 * 定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
 * 假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层, 因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
 *
 * solution：主要通过排序化成最长不递减子序列，然后通过二分解决，因为数据量是一百万，不能通过dp。
 **/
public class Dajimu {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int a[][] =new int[n][2];
        for (int i = 0; i< n; i++) {
            a[i][0]  = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a,(o1, o2) -> o1[0]-o2[0]);
        int []top = new int[n];
        int plices =0;
        for (int i = 0; i < n; i++) {
            int target = a[i][1];
            int l = 0;
            int r = plices;
            while (l<r) {
                int mid = (l+r)>>>1;
                if(top[mid]>target){
                    r = mid;
                }else {
                    l = mid+1;
                }
            }
            if (l== plices)
                plices++;
            top[l] = target;
        }
        System.out.println(plices);
    }

}
