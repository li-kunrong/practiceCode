package interview.nowcode2019;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/11 12:15
 */
public class Jiangjin {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i <n; i++) {
            a[i] = scanner.nextInt();
        }
        int left = 0;
        int right = n-1;
        int max = 0,left_sum = a[left],right_sum = a[right];
        while (left<right) {
            if (left_sum==right_sum) {
                max = left_sum;
                left_sum+=a[++left];
                right_sum+=a[--right];
            }else if (left_sum<right_sum){
                left_sum+=a[++left];
            }else {
                right_sum+=a[--right];
            }
        }
        System.out.println(max);
    }
}
