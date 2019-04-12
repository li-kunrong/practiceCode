package interview.weizhong;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/11 20:44
 */
public class Q3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int arr[] = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scanner.nextInt();
            test(arr[i]);
        }

    }
    static void test(int i) {
        int flag = 0;
        int count=0;
        if (i== 1) {
            System.out.println(0);
            return;
        }else {
            int tmp = i;
            while (true) {
                i = result(i);
                count++;
                if (i==1)
                    break;
                if (tmp==i){
                    flag =1;
                    break;
                }
            }
        }
        if (flag == 1) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }
    static int result(int j) {
        if (j%2==0)
            return j/2;
        else
            return j*3+1;
    }
}
