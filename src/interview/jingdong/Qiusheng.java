package interview.jingdong;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/13 19:56
 */
public class Qiusheng {
    public static void main(String[] args){
      String t = "jjaabcabc";
      String s = "aa";
        int index = t.indexOf(s);
//        String tmp1 = t.substring(index+s.length());
//        System.out.println(tmp1);
//        String tmp2 =t.substring(0,index);
//        System.out.println(tmp2);
//        t = tmp1+tmp2;
//        System.out.println(t);
        System.out.println(getString(t,2,2));

    }

    static String getString(String s, int i , int len) {
        char a[] = s.toCharArray();
        int j = i;
        for ( ; j < s.length()-len; j++) {
            a[j] = a[j+len];
        }
        while (j<s.length()) {
            a[j++] = 0;
        }

        return String.valueOf(a);
    }
}
