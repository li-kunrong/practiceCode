package interview.qq;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/5 21:06
 */
public class Yingbi {
    public static void main(String[] args){
        Scanner scanner = new Scanner( System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int a[] = new int[n];
        int coins[] = new int[m+1];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            coins[a[i]] = 1;
        }
        int flag = 0;
        for (int i = 1; i < m+1; i++) {
            if(!check(coins,a, i)){
                flag = 1;
                break;
            }
            if (coins[i] == 1)
                continue;
            if (find(coins,i)) {

            }

        }
        if (flag == 1) {
            System.out.println(-1);
        }else {

        }


    }

    static boolean find(int[] coins, int index) {
        boolean succ = false;
        for (int i = index-1; i > 0; i--) {
            if (coins[i]!=0){
                succ = find(coins,index-coins[i]);
            }
        }
        return true;
    }

    static boolean check(int coins[] , int a[] , int co) {
        int f = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < co) {
                f = 1;
            }
        }
        if (f == 1)
            return true;
        else
            return false;
    }
}
