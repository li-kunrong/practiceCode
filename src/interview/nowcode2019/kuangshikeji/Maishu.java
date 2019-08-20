package interview.nowcode2019.kuangshikeji;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 14:08
 * @Description:
 **/
public class Maishu {
    public static void main(String[] args) {
        int a[] = {10,15,20};
        int res = 0;
        for (int i = 32; i>=0; i-=2) {
            int k = 500-i*15;
            res +=cal(k);
        }

        System.out.println(res);
    }

    static  int cal(int k) {
        int res = 0;
        for (int i= 0; 10*i<=k; i++) {
            if ((k-i*10)%20==0) {
                res++;
            }
        }
        return res;
    }
}
