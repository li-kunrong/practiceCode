package interview.wangyi;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 15:20
 */
public class Tower {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int s = 0;
        int record[][] = new int[k][2];
        int max = 0;
        int min = 0;
        for (int j = 0; j < k; j++) {
             max = maxIndex(a);
             min = minIndex(a);
            if (a[max] == a[min] || a[max] == a[min]+1)
                break;
            a[max]--;
            a[min]++;
            record[j][0] = max;
            record[j][1] =min;
            s++;
        }
        max = maxIndex(a);
        min = minIndex(a);
        System.out.println(a[max]-a[min]+"\t"+s);
        for (int i = 0; i < s; i++){
            System.out.println((record[i][0]+1) +"\t" + (record[i][1]+1));
        }
    }

    public static int maxIndex(int a[]) {
        int res = 0;
        int max = a[0];
        for (int i = 1; i < a.length; i++ ) {
            if (a[i] > max){
                max= a[i];
                res= i;
            }

        }
        return res;
    }

    public static int minIndex(int a[]) {
        int res = 0;
        int min = a[0];
        for (int i = 1; i < a.length; i++ ) {
            if (a[i] < min){
                min= a[i];
                res= i;
            }

        }
        return res;
    }
}
