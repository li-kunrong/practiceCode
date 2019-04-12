package interview.wangyi;

import java.util.*;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 16:04
 */
public class Zifuchuan {
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        quanpaixu(n,m);
        if (k>list.size()){
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        System.out.println(list.get(k));

    }
    public static void quanpaixu(int n, int m) {

    }
}
