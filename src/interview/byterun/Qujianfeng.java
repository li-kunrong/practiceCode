package interview.byterun;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/7 14:52
 * @Description:
 * dp做法，算是双指针
 **/
public class Qujianfeng {
    public static void main(String[] args) {

        //预处理左右各做一遍最长上升子串, 然后维护一个最大和即可
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        int[] l = new int[n];
        for (int i = 1; i < n; i++) {
            if (x[i] - x[i - 1] > 0) {
                l[i] = l[i - 1] + 1;
            }
        }
        int[] r = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (x[i] > x[i + 1]) {
                r[i] = r[i + 1] + 1;
            }
        }
        int mx = 0, ll = -1, rr = -1;
        for (int i = 0; i < n; i++) {
            if (l[i] > 0 && r[i] > 0 && l[i] + r[i] > mx) {
                mx = l[i] + r[i];
                ll = i - l[i];
                rr = i + r[i];
            }
        }
        System.out.print(ll + " " + rr);
    }
}
