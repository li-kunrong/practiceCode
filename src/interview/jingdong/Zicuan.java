package interview.jingdong;

import java.util.*;

/**
 * @author kunrong
 * @description
 * @date 2019/4/13 19:38
 */
public class Zicuan {
    private static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] s = new String[m];
        for (int i = 0; i < m; i++) {
            s[i] = scanner.next();
        }
        String t = scanner.next();
        int res = getSum(s,t,0);
        System.out.println(res);

    }

    static int getSum(String s[],String t, int j) {
        if (map.containsKey(t)) {
            return map.get(t);
        }
        int sum = 0;
        for (int i = j; i < s.length; i++) {
            int max = 0;
            if (t.contains(s[i])) {
                max++;
                map.put(t,max);
                int index = t.indexOf(s[i]);
//                String tmp1 = t.substring(0,index);
//                String tmp2 =t.substring(index+s[i].length());
//                t = tmp1+tmp2;
                t= getString(t,index,s[i].length());
               // System.out.println(t);
                max+=getSum(s,t,i);

            }
            if (max>sum) {
                sum = max;
            }
        }

        return  sum;
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
