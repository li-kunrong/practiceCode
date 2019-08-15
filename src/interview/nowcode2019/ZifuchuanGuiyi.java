package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 10:11
 * @Description:
 **/
public class ZifuchuanGuiyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char []c = s.toCharArray();
        int a[] = new int[256];
        for (char i: c){
            a[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <256; i++) {
            if (a[i]>0) {
                sb.append((char)i);
                sb.append(a[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
