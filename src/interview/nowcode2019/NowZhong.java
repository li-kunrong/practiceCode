package interview.nowcode2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 9:30
 * @Description:
 **/
public class NowZhong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in);
        int n = scanner.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++){
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int curhour = m/60;
        int curmin = m%60;
        curhour = hour-curhour;
        //System.err.println(curhour);
        curmin = min-curmin;
        //System.err.println(curmin);
        Arrays.sort(a,(o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        int flag = -1;
        for (int i = n-1; i >= 0; i--) {
            if (a[i][0]<curhour||a[i][0]==curhour&&a[i][1]<=curmin){
                flag = i;
                break;
            }
        }
        if (flag==-1) {

        }else {
            System.out.println(a[flag][0] +" " + a[flag][1]);
        }
    }
}
