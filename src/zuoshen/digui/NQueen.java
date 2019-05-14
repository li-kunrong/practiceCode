package zuoshen.digui;


import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/5/14 19:24
 */
public class NQueen {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nums(n));
    }

    static int nums(int n) {
        if (n<1) {
            return 0;
        }
        int record[] = new int[n];
        return process1(0,record,n);
    }

    static int process1(int i, int[] record,int n ){
        if (i==n)
            return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(i,j,record)) { //是否可以放，可以就纪录
                record[i] = j;
                res+=process1(i+1,record,n);
            }
        }
        return res;
    }

    static boolean isValid(int i, int j, int record[]) {
        for (int k = 0; k < i; k++) {
            if (record[k]==j||Math.abs(i-k)==Math.abs(j-record[k])){//不能同列或者斜对
                return false;
            }
        }
        return true;
    }
}
