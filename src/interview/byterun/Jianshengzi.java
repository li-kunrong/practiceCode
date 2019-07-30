package interview.byterun;

import java.util.Scanner;

public class Jianshengzi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int max = a[0];
        for (int i = 1; i <n ;i++) {
            if (a[i]>max)
                max = a[i];
        }

        double high = max;
        double low = 0;
        double mid = 0;
        while (high-low>1.0E-6) {
            mid = (high+low)/2;

            int count = checkmax(a,mid);
            if (count<m) {
                high = mid;
            }else {
                low=mid;
            }
        }
        System.out.println(String.format("%.2f",mid));
    }

    private static int checkmax(int[] a, double mid) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            Double ins = a[i]/mid;

            result+=ins.intValue();
        }
        return  result;
    }
}
