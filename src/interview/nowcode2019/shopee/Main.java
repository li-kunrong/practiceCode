package interview.nowcode2019.shopee;
import java.util.Scanner;
/**
 * @Author: kunrong
 * @Date: 2019/8/14 15:40
 * @Description:
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] q = new int[n][n];                                     //问题数组
        int [][] result = new int[n][n];                              //结果数组
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                q[i][j] = sc.nextInt();
                result[i][j] = 0;
            }
        }
        sc.close();

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(q[i][j] == 0){
                    findOne(q, result, i, j, n);                             //碰到0就往后面找1
                }else{
                    result[i][j] = Integer.MAX_VALUE;
                    findZero(q, result,i, j, n);                              //否则就找0
                }
            }
        }

        int minResult = Integer.MAX_VALUE;

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(result[i][j] < minResult){
                    minResult = result[i][j];
                }
            }
        }
        minResult = minResult == Integer.MAX_VALUE ? -1: minResult;
        System.out.println(minResult);
    }

    private static void findZero(int[][] q, int[][] result, int x, int y, int n) {
        int j = y;
        for(int i=x; i < n; i++){
            for(; j < n; j++){
                if(q[i][j] == 0){
                    result[i][j] += (Math.abs(i - x) + Math.abs(j - y));   //把距离分散到碰到的0上面
                }
            }
            j = 0;
        }


    }

    private static void findOne(int[][] q, int[][] result, int x, int y, int n) {
        int j = y;
        for(int i=x; i < n; i++){
            for(; j < n; j++){
                if(q[i][j] == 1){
                    result[x][y] += (Math.abs(i - x) + Math.abs(j - y)); //把距离累加到 result[x][y]上
                }
            }
            j = 0;
        }

    }

}
