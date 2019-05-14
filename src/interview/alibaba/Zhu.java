package interview.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/12 19:47
 */
public class Zhu {

    static String calculate(int m, int k) {
    int a[] = new int[m+4];
    a[1] = 2;
    a[2] = 3;
    a[3] = 4;
    for (int i = 4; i<=m; i++) {
        a[i] = a[i-2] + a[i-3];
    }
    String res = "";
    res+=a[m]+",";
    int b[] =new int[m];
    for (int i = 0; i<m;i++) {
        b[i] = test(a[i+1]);
    }
    Arrays.sort(b);
    int year = getYear(m);
    year+=2018;
    res+=year+",";
    int paiming = test(b[m-k]);
    int index = 0;
    for (int i = 1; i <=m;i++) {
        if (paiming== a[i]) {
            index= i;
            break;
        }
    }
    res+=index;
    return res;
    }

    static int test(int k) {
        int res = 0;
        while (k>0) {
            int j = k%10;
            k/=10;
            res= (res*10) + j;
        }
        return res;
    }

    static int getYear(int m) {
        if (m<=2){
            return 1;
        }else if (m==3) {
            return 2;
        }else if (m==4) {
            return 3;
        }else  {
            int res = 4;
            int pre = 3;
            int prepre = 2;
            int tmp1 = 0;
            int tmp2 = 0;
            int n = 3;
            while(m>res) {
                tmp1 = res;
                tmp2 = pre;
                res +=prepre;
                pre = tmp1;
                prepre= tmp2;
                n++;
            }
            return n-2;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}
