package interview.nowcode;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kunrong
 * @date 2019/3/14 19:29
 */
public class Test_manerchashu {
    public static List<String> res  = new ArrayList<>();
    public static boolean door = false;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        back_trace(n,k,1);
        for (int i = 0;i <res.size(); i++) {
            System.out.println(res.get(i) );
        }

    }

    public static void back_trace(int n, int k,int curr) {
        if (k<0) {
            return ;
        }
        if (n==curr && k==0) {
            door = true;
            return ;
        }
        res.add(String.valueOf(curr));
        res.add("+");
        back_trace(n,k-1,curr+curr*2);


        if (door== true) {
            return;
        }
        res.remove(String.valueOf(curr));
        res.remove("+");

        res.add(String.valueOf(curr));
        res.add("-");
        back_trace(n,k-1,-curr+curr*2+1);
        if (door==true) {
            return;
        }
        res.remove(String.valueOf(curr));
        res.remove("-");
    }
}
