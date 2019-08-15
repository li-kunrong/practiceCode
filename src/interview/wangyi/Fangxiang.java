package interview.wangyi;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 15:00
 * @Description:
 **/
public class Fangxiang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = 0;
        int r = 0;
        String s = scanner.next();
        char c[] = s.toCharArray();
        for (int i = 0; i <c.length; i++) {
            if (c[i]=='L')
                l++;
            else
                r++;
        }
        int dir = (r-l)%4;

        char[]t= {'N','E','S','W'};
        System.out.println(t[(4+dir)%4]);
    }
}
