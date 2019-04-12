package interview.byterun;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/28 16:01
 */
public class ZimuJvLI {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        String s = scanner.next();
        int[] a= new int[27];
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length;i++) {
            a[c[i]-'a']++;
        }


    }
}
