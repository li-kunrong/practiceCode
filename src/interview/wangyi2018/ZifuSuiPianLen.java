package interview.wangyi2018;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/7/31 14:22
 * @Description:
 **/
public class ZifuSuiPianLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        char a[] = s.toCharArray();
        int i = 0;
        double count=0;
        while (i<a.length){
            boolean flag = false;
            while (i<a.length-1&&a[i]==a[i+1]){
                i++;
                flag = true;
            }
            count++;
            System.out.println(count);
            i++;
        }
        double result = a.length/count;
        System.out.println(String.format("%.2f",result));
    }
}
