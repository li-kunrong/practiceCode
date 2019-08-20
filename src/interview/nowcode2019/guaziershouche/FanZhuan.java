package interview.nowcode2019.guaziershouche;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 10:59
 * @Description:
 **/
public class FanZhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str[] = scanner.nextLine().split(" ");
        for (int i = str.length-1; i>=0;i--) {
            System.out.print(str[i]+" ");
        }
    }
}
