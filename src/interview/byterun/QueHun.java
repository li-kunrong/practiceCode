package interview.byterun;

import java.util.Arrays;
import java.util.Scanner;

public class QueHun {
    public static void main(String[] args) {
        int a[] = new int[14];
        int x[] = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i< 13 ; i++) {
            a[i] = scanner.nextInt();
            x[a[i]]++;
        }
      //  check(a,4);
        int b[] = new int[10];
        for (int i = 1; i < 10; i++) {
            if (x[i]<4){
                b[i]=check(a,i);
            }

        }
        int flag = 0;
        for (int i = 1; i < 10; i++) {
            if (b[i]!=0) {
                flag = 1;
                System.out.print(i+" ");
            }

        }
        if (flag ==0 ) {
            System.out.print(0);
        }
    }

    private static int check(int[] a,  int i) {
        int result = 0;
        int []d = new int [14];
        for (int k = 0; k < 13; k++) {
            d[k] = a[k];
        }
        d[13]= i;
        Arrays.sort(d);
        boolean door = isHu(d);
        if (door){
            result=1;
        }
        return result;
    }

    public static boolean isHu(int[] num) {
        if (num.length ==0 )
            return true;
        int len = num.length;
        int count0 = 1;
        for (int i = 1; i < len; i++) {
            if (num[i]==num[i-1]) {
                count0++;
            }else {
                break;
            }
        }
        //没有雀头，并且第一个数的量>=2,
        if (len%3!=0&&count0>=2) {
            int[] h = copyArray(num,2);
            if (isHu(h))
                return true;
        }
        //去相同的
        if (count0>=3) {
            int[] g = copyArray(num, 3);
            if (isHu(g))
                return true;
        }
        //去连顺
        if (len>2&&findNumber(num, num[0]+1)&&findNumber(num,num[0]+2)) {
            int[] u = removeNumber(num,num[0]);
            u = removeNumber(u,num[0]+1);
            u = removeNumber(u,num[0]+2);

            if (isHu(u)) {
                return true;
            }
        }
        return  false;
    }

    public static int[] copyArray(int[] nums, int index) {
        int[] b = new int[nums.length-index];
        for (int i = 0; i< nums.length-index; i++) {
            b[i] = nums[i+index];
        }
        return b;
    }

    public  static boolean findNumber(int[] num, int a){
        boolean result = false;
        for (int i = 0; i < num.length; i++) {
            if (num[i]==a) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static int[] removeNumber(int[] num, int a) {
        int []t = new int[num.length-1];
        boolean flag = false;
        int o =0;
        for (int i = 0; i < num.length; i++) {
            if (flag) {
                t[o++] = num[i];
            }else {
                if (num[i] == a) {
                    flag = true;
                    continue;
                }
                t[o++] = num[i];
            }
        }

        return t;
    }

}
