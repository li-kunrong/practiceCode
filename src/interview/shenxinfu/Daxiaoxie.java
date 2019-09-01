package interview.shenxinfu;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/5/31 20:49
 */
public class Daxiaoxie {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char []chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i]>='A' && chars[i]<='Z')  ) {
                if (i>=1) {
                    if (chars[i-1]<='z'&&chars[i-1]>='a'||(chars[i-1]>='A' && chars[i-1]<='Z')||(chars[i-1]<='9'&&chars[i-1]>='0')){
                        chars[i] +=32;
                    }
                }
                continue;
            }

            if ((chars[i]>='a' && chars[i]<='z')  ) {
               if (i==0||chars[i-1]=='-'||chars[i-1]=='.'||chars[i-1]=='!'||chars[i-1]==','||chars[i-1]=='\t'||chars[i-1]==' '||chars[i-1]=='\\'||chars[i-1]>='0'){
                   chars[i] -=32;
               }

            }
        }
        System.out.println(String.valueOf(chars));
    }
}
