package interview.neteasy;

import java.util.Scanner;

public class Xiangfanshu {
    public static void main(String[] args) {

        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        String s=scanner.next();
        //将字符串转换成数字
        int number1=Integer.parseInt(s);
        //将字符串倒序后转换成数字
        //因为Integer.parseInt()的参数类型必须是字符串所以必须加上toString()
        int number2=Integer.parseInt(new StringBuilder(s).reverse().toString());
        System.out.println(number1+number2);

    }
}
