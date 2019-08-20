package interview.nowcode2019.guaziershouche;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 11:12
 * @Description:
 **/
public class QuanPailieDeYiGe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str[] = scanner.nextLine().split(" ");
        int k = (str.length+1)/str[0].length();
        int n = str[0].length();
        int a[] = new int[256];
        String res = "";
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < str.length; j++) {
                a[str[j].charAt(i)]++;
            }
            int min_index = 0;
            int min = Integer.MAX_VALUE;
            int h = 0;
            for (; h < 256; h++) {
                if (a[h]!=0&&a[h]<min){
                    min = a[h];
                    min_index = h;
                }
            }
            res+=(char)min_index;
            Arrays.fill(a,0);
        }
        System.out.println(res);
    }
}
