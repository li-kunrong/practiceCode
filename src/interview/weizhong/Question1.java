package interview.weizhong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/11 18:56
 */
public class Question1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n==1){
            System.out.println();
            System.out.println(1);
            return;
        }else if (m == 1){
            for (int i = 1; i < n; i++)
                System.out.print(i + " ");
            System.out.println();
            System.out.println(n);
            return;
        }

        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            list.add(i);
        }
//
        int bt = 1;
        while (list.size() > 1) {
            bt = (bt + m -1) % list.size();
           // System.out.println(list.get(bt));
            res.add(list.get(bt));
            list.remove(bt);
           // System.out.println(list);
        }
        for (Integer i: res) {
            if (i.equals(0)) {
                System.out.print(n+" ");
            }else{
                System.out.print(i+" ");
            }

        }
        System.out.println();
        if (list.get(0).equals(0)) {
            System.out.println(n);
        }else {
            System.out.println(list.get(0));
        }

    }
}
