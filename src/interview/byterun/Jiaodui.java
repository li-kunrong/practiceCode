package interview.byterun;

import java.util.Scanner;

public class Jiaodui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0) {
            String str = scanner.next();
            int j =0;
            char[] c = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                c[j++] = c[i];
                if (j>2 && c[j-1]==c[j-2]&&c[j-2]==c[j-3]) j--;
                if (j>3 && c[j-1]==c[j-2]&&c[j-3]==c[j-4]) j--;
            }
            str = String.valueOf(c);
            str = str.substring(0,j);
            System.out.println(str);
        }
    }
}
