package interview.pingduoduo;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/11 14:38
 */
public class Third {
    private  static int res =0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        for (int i = 1; (i+i+n-1)*n/2<=s; i++) {
            solve(i,i,1,n,s);
        }
        System.out.println(res);
    }

    static void solve(int cur,int last, int num, int n , int s) {
        if (cur>s)
            return;
        if (num==n-1&&s-cur>last) {
            res= (++res)%1000000007;
            return;
        }else if (num==n-1) {
            return;
        }
        for (int i = cur+1; (i+i+n-num-1)*(n-num)/2<=(s-cur); i++) {
            solve(i+cur,i,num+1,n,s);
        }

    }

}
