//package interview.pingduoduo;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author kunrong
// * @description
// * @date 2019/8/11 14:38
// */
//public class Fourth {
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int a[][] = new int[m][2];
//        int b[][] = new int[n+1][n+1];
//        int len[] = new int[n+1];
//        for (int i = 0; i < m; i++) {
//            a[i][0]= scanner.nextInt();
//            a[i][1] = scanner.nextInt();
//            b[a[i][0]][a[i][1]] = 1;
//        }
//        if (m==0){
//            System.out.println(n);
//            return;
//        }
//
//        Arrays.sort(a);
//        int ha = 1;
//        for (int i = 0; i < m;i++) {
//
//            len[a[i][0]] = 1;
//            len[a[i][1]] = 1;
//            while (solve(a,i,a[i][1])){
//
//            }
//            ha++;
//        }
//
//
//
//
//    }
//
//    static  boolean solve(int[][] a,int num) {
//        for (int i= 0;i <)
//    }
//}
