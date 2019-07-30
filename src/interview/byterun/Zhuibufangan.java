package interview.byterun;

import java.util.Scanner;

public class Zhuibufangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }

        long m = count(n,d,a);
        System.out.println(m);
    }

    public static long count(int n, int d, int[] a) {
        if (n<3)
            return 0;
        long result = 0;
        long len = 0;
        int i=0;
        int j=1;
        for (; i < n-2; i++) {
            while (j<n&&(a[j]-a[i])<=d) {
                j++;
            }
            len = j-i-1;
            if (len>=2){
                result+=(len-1)*len/2%99997867;
            }
        }
        return result%99997867;
    }
}
