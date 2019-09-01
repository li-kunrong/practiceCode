package interview.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/11 14:38
 */
public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] =new int[n];
        for (int i  = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        double result = Double.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            double p = solve(a,i);
            if (p<result) {
                result = p;
            }
        }
        System.out.println(String.format("%.2f",result));
    }

    static double solve(int []a, int i) {
        double average = 0.0;
        int sum = 0;
        for (int j = 0; j <3; j++) {
            sum+=a[i+j];
        }
        average = sum/3.0;

        double res = 0.0;
        for (int j = 0; j < 3; j++) {
            res+=Math.pow((a[i+j]-average),2.0);
        }

        return res/3.0;
    }
}
