package interview.jingdong2019;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/8/24 19:29
 */
public class Shengao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long   a[]  = new long[n];
        for (int i =0 ; i <n; i++) {
            a[i] = scanner.nextInt();
        }
        long sum[] = new long[n];
        sum[0] = a[0];
        for (int i = 1; i < n; i++) {
            sum[i] = a[i]+sum[i-1];
        }
        long res = 0L;
        long curValue = a[0];
        int group = 1;
        int comeon = 0;
        for (int i = 1; i < n; ) {
            long temp[] = getF(curValue,sum,a,i);
            if (temp[2]==-1) {
                comeon++;
                if (comeon>=n) {
                    System.out.println(-1);
                    break;
                }
                i = comeon+1;
                curValue = sum[comeon];
                group= 1;
                continue;
            }
            curValue = temp[1];
            i = (int)(temp[0]+1);
            group++;

        }
        System.out.println(group);
    }

    static long[] getF(long curValue, long[] sum, long a[], int index) {
        long b[] = new long[3];
        int tmpIndex = index;
        while (tmpIndex<a.length) {
            if (sum[tmpIndex]-sum[index-1]>=curValue) {
                b[1] = sum[tmpIndex]-sum[index-1];
                b[0] = tmpIndex;
                break;
            }
            tmpIndex++;
        }
        if (tmpIndex==a.length) {
            if (sum[tmpIndex-1]-sum[index-1]<curValue) {
                b[2] = -1;
            }
        }
        return b;
    }

}
