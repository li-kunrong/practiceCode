package interview.baike;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/23 20:23
 * @Description:
 **/
public class JianBeike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sumVaule = scanner.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        int curSum = 0;
        int curValue = 0;
        for (int i= 0; i < n; i++) {
            int tempSum = getSum(a[i],curValue, sumVaule);
            curSum+=tempSum;
            curValue+=(tempSum*a[i][1]);
        }
        System.out.println(curSum);

    }

    static int getSum(int a[], int curValue, int sumValue) {
        int tmp = 0;
        while (tmp<=a[0]) {
            if (curValue+tmp*a[1]>sumValue) {
                tmp--;
                break;
            }
            tmp++;
        }
        if (tmp<0)
            tmp=0;
        if (tmp>a[0])
            tmp = a[0];
        return tmp;
    }
}
