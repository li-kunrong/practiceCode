package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/21 19:53
 */
public class Dafuweng {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getSum(n));
    }
    static int getSum(int num) {
        int res = 0;
        if (num == 1) {
            res = 1;
        }else if (num == 2) {
            res =2;
        }else {
            for (int i = 1; i < num; i++) {
                res+=getSum(num-i);
            }
            res+=1;
        }
        return res;
    }
}
