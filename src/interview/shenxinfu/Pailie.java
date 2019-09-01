package interview.shenxinfu;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/5/31 21:19
 */
public class Pailie {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-->0) {
            String s = in.next();
            char c[] = s.toCharArray();
            find(c);
        }
    }

    static void find(char[] chars) {
        char s[] = new char[4];
        s[0] = 'a';
        s[1] = 'e';
        s[2] = 'i';
        s[3] = 'o';
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            for (char c : s){
                if (c==chars[i]){
                    num++;
                    break;
                }
            }
        }
        int sum = chars.length-num;
        if (sum ==0 ){
            System.out.println(0);
            return;
        }

        int res  = 1;
        while(sum>0) {
            res*=sum;
            sum--;
        }
        res*=num;
        System.out.println(res);
    }
}
