package interview.baike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/23 21:03
 * @Description:
 **/
public class QiXi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s  = scanner.next();

        char c[] = s.toCharArray();
        int len = c.length;
        List<Integer> list = new ArrayList<>();
        for (int i= 1; i < len; i++) {
            if (c[i]==c[0]) {
                list.add(i);
            }
        }
        int mubiao = -1;
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i);
            int u = 0;
            int t = j;
            for (; t<len; t++) {
                if (c[t]!=c[u++]) {
                    break;
                }
            }
            if (t==len){
                mubiao = j;
                break;
            }
        }
        if (mubiao == -1) {
            String s1 = "";
            for (int i = 0; i < k; i++) {
                s1=s1+s;
            }
            System.out.println(s1);
        }else {
            String s2 = s.substring(mubiao,len);
            for (int i =0; i < k-1; i++) {
                s+=s2;
            }
            System.out.println(s);
        }
    }
}
