package interview.wangyi;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 14:40
 * @Description:
 **/
public class Ludeng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            char []c = s.toCharArray();
            int res = 0;
            int i = 0;
            for (i =0 ; i < c.length-3;){
                if (c[i]=='X'){
                    i++;
                    continue;
                }
                int j = 0;
                while (j<3){
                    c[i+j]='X';
                    j++;
                }
                i+=3;
                res++;
            }
            while (i<n){
                if(c[i]=='.'){
                    res++;
                    break;
                }
                i++;
            }
            System.out.println(res);

        }
    }
}
