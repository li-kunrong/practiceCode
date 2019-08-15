package interview.nowcode2019;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 16:02
 * @Description:
 **/
public class Tangguo {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String[] candy = sc.nextLine().split(" ");
        TreeSet<Integer> apiSet = new TreeSet<>();
        for (String item : str) {
            apiSet.add(Integer.parseInt(item));
        }
        int sum = 0;
        int temp = 0;
        for (String item : candy) {
            if (apiSet.floor(Integer.parseInt(item)) != null) {
                temp = apiSet.floor(Integer.parseInt(item));
                sum++;
                apiSet.remove(temp);
            }
        }
        System.out.println(sum);
    }

}
