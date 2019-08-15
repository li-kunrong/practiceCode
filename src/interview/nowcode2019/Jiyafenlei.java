package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 13:58
 * @Description:
 **/
public class Jiyafenlei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] c = s.toCharArray();
        int count_c = 0;
        int count_d = 0;
        int ret_c = 0;
        int ret_d = 0;
        for (int i =0; i < c.length; i++) {
            if (c[i]=='C'){
                ret_c+=(i-count_c);
                count_c++;
            }else {
                ret_d+=(i-count_d);
                count_d++;
            }
        }
        System.out.println(Math.min(ret_c,ret_d));
    }
}
