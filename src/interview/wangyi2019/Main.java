package interview.wangyi2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/3 15:30
 */
public class Main {
    private static Map<Integer,String> map = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] =new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int q  = scanner.nextInt();
        while (q-->0) {
            int index = scanner.nextInt();
            solve(a,index-1);
        }
    }
    public static void solve(int[] a, int i) {
        int b = a[i];
        if (map.containsKey(b)){
            System.out.println(map.get(b));
            return;
        }
        double result= 0;
        for (int u : a) {
            if (u<=b){
                result++;
            }
        }
        double res = (result-1)/a.length*100;
        System.out.println(String.format("%.6f",res));
        map.put(b,String.format("%.6f",res));
    }
}
