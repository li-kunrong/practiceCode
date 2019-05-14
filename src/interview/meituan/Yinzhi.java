package interview.meituan;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/4/21 20:06
 */
public class Yinzhi {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getRes(n,0));
    }
    static int getRes(int aim, int index){
        int res = 0;
        int[] money = {1,5,10,20,50,100};
        if (aim<0) {
            return  0;
        }else if (aim==0){
            return 1;
        }
        if (index==money.length) {
            res = aim==0?1:0;
        }else {
            for (int i = 0; money[index]*i<=aim; i++) {
                res+=getRes(aim-money[index]*i,index+1);
            }
        }
        return res;
    }
}
