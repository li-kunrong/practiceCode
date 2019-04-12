package interview.qq;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/5 20:14
 */
public class Zifuchuan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s=scanner.next();
        char[] a=  s.toCharArray();
        int m = n;
        for (int i = 0; i < m; i++) {
           int pre = count(a,i);
           if (pre == 1) {
               m=m-2;
               if (m<0) {
                   break;
               }
               for (int j = i; j < m; j++) {
                   a[j] = a[j+2];
               }
               a[m] ='a';
               a[m+1] = 'a';
               i = -1;

           }else {
               if (i+pre>=m) {
                   break;
               }
               int hou = count(a,i+pre);
               if (hou>=pre) {
                   m-=pre*2;
                   for (int j = i; j < m; j++) {
                       a[j] = a[j+pre*2];
                   }
                   for (int k = m; k < m+pre*2; k++) {
                       a[k] = 'a';
                   }
                   i = -1;
               }else {
                   if (i+pre>=m) {
                       break;
                   }
                   int h = pre-hou;
                   m-=hou*2;
                   for (int j = i+h; j < m;j++) {
                       a[j] = a[j+hou*2];
                   }
                   for (int k =m ; k < m+hou*2; k++) {
                       a[k] ='a';
                   }
                   i = -1;
               }
           }
        }
        int k = 0;
        int count= 0;
        while (a[k] !='a') {
            count++;
            k++;
            if(k==n)
                break;
        }
        System.out.println(count);
    }

    static int count(char a[], int index ) {
        int res = 1;
        for (int i = index; i < a.length-1; i++) {
            if (a[i] ==a[i+1])
                res++;
            else {
                break;
            }
        }
        return res;
    }

}
