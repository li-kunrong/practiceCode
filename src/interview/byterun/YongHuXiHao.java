package interview.byterun;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/28 14:50
 */
public class YongHuXiHao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int j = 0; j < q; j++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            countPeople(array,l-1,r-1,k);
        }
    }
    public static void countPeople(int[] a, int l, int r, int k) {
        int res=0;
        for (int i = l; i <= r; i++) {
            if (a[i] == k)
                res++;
        }
        System.out.println(res);
    }
}

