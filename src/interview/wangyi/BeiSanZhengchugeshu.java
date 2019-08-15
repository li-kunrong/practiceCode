package interview.wangyi;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 14:06
 * @Description:
 **/
public class BeiSanZhengchugeshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int res = 0;
        for (int i = l ; i<=r ;i++) {
            switch (i%3){
                case 1: break;
                case 2: ++res;break;
                case 0: ++res;break;
            }
        }
        System.out.println(res);
    }
}
