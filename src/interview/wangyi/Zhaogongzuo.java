package interview.wangyi;

import java.util.*;

/**
 * @Author: kunrong
 * @Date: 2019/8/9 9:31
 * @Description:
 **/
public class Zhaogongzuo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int []a = new int[n+m];
        int []b = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            a[i] = t;
            int q = scanner.nextInt();
            if (map.containsKey(t)){
                if (map.get(t)<q)
                    map.put(t,q);
            }else {
                map.put(t,q);
            }
        }

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
            a[n+i] = b[i];
            if (!map.containsKey(b[i]))
                map.put(b[i],0);
        }

        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i <m+n; i++) {
            max = Math.max(map.get(a[i]),max);
            if (max>map.get(a[i]))
                map.put(a[i],max);
        }
        for (int i = 0; i < m; i++){
            System.out.println(map.get(b[i]));
        }
    }
}
/**
 4 4
 5 10
 6 20
 9 100
 10 1000

 4 4
 5 10
 7 20
 7 18
 9 100
 1 6 7 8
 */

/**

 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 int n = scanner.nextInt();
 int m = scanner.nextInt();
 int a[][] = new int[n][2];
 for (int i =0;i < n; i++) {
 a[i][0]  = scanner.nextInt();
 a[i][1] = scanner.nextInt();
 }
 Arrays.sort(a,(o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
 //        for (int i = 0; i < n; i++) {
 //            System.out.println(a[i][0] + " " + a[i][1]);
 //        }
 while (m-->0) {
 int q = scanner.nextInt();
 int res = 0;
 res = find(a,q);
 if (res==0&&a[res][0]>q) {
 res = 0;
 }else if (a[res][0]>q){
 res--;
 res = a[res][1];
 } else{
 res = a[res][1];
 }
 System.out.println(res);
 }
 }

 static int find(int[][] a, int q) {
 int l = 0;
 int r = a.length;
 while (l<r) {
 int mid = (l+r)/2;
 if (a[mid][0]>q){
 r = mid-1;
 }else if (a[mid][0]<q) {
 l = mid+1;
 }else{
 if (mid<a.length-1&& a[mid][0]==a[mid+1][0]) {
 l = mid+1;
 }else {
 return mid;
 }
 }

 }
 return l;
 }

 **/