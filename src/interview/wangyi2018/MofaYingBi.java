package interview.wangyi2018;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/7/31 14:14
 * @Description:
 **/
public class MofaYingBi {
    public static void main(String[] args){
        //System.out.println("请输入要获得的硬币数量：");
        Scanner scanner = new Scanner(System.in);
        int coincount = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        while (coincount >= 1) {
            // 偶数的情况
            if (coincount % 2 == 0) {
                coincount = (coincount - 2) / 2;
                sb.append("2");
                // 奇数的情况
            } else {
                coincount = (coincount - 1) / 2;
                sb.append("1");
            }
        }
        // 输出反转后的字符串
        System.out.println(sb.reverse());
    }
}
