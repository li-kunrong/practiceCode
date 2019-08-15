package interview.nowcode2019.shopee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/14 11:02
 * @Description:
 **/
public class First {
    private static int count = 0;
    private static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        count = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        int a[][] = new int[n][n];
        for (int i= 0; i <n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }

        dfs(0,0,x,y,a);
        System.out.println(count);

    }

    static void dfs(int curx, int cury, int x, int y, int [][]a) {
        if (curx==x&&cury==y) {
            count++;
            return;
        }

        int tmp_x = curx+1;
        int tmp_y = cury+1;
        if (tmp_x<=x) {
            boolean flag = true;
            for (int i = 0; i <a.length; i++) {
                if (tmp_x==a[i][0]&&cury==a[i][1]){
                    flag = false;
                }
            }
            if (flag){
                dfs(tmp_x,cury,x,y,a);
            }
        }
        if (tmp_y<=y){
            boolean door = true;
            for (int i = 0; i <a.length; i++) {
                if (curx==a[i][0]&&tmp_y==a[i][1]){
                    door = false;
                }
            }
            if (door){
                dfs(curx,tmp_y,x,y,a);
            }
        }
    }
}
