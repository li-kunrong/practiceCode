package interview.nowcode2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/13 9:13
 * @Description:
 *
 * 我这里还sort了。。。。其实直接用map保存每个数字的amount。
 *
 *
 * 思想就是用map记录每个相同数字num的次数count；
 * 1、count<=num+1，则该num对应的人数为num+1;
 * 2、count>num,则进行num+1，count -= num;之后再进行判断，因为每一个num对应的人数最多为num+1，所以要减去num重新判断。
 * 即比如2 2 2 2；这四个2是不同阵容的，比如前面两个2代表蓝色，则后面的两个2就应该是红色或者其他不适蓝色的颜色。属于两个阵容，人数为(3+1) + (3+1);
 **/
public class Tangguomiti {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] strings = s.nextLine().split(" ");
        int []a = new int[strings.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(a);
        int tmp = a[0];
        int res = 1;
        int total = 0;
        for (int i = 1; i < a.length; i++ ) {
            if (a[i]==tmp){
                res+=1;
                continue;
            }
            int t = (res%(tmp+1)==0?0:1);
            total+=(tmp+1)*(res/(tmp+1)+t);
            res = 1;
            tmp= a[i];
        }
        int t = (res%(tmp+1)==0?0:1);
        total+=(tmp+1)*(res/(tmp+1)+t);

        System.out.println(total);
    }
}
