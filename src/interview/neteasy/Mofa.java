package interview.neteasy;

import java.util.*;
import java.lang.*;

/**
 * @author kunrong
 * @description
 * @date 2019/4/12 18:31
 */
public class Mofa {
    
    public static void main(String[] args){
        System.out.println("请输入要获得的硬币数量：");
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
