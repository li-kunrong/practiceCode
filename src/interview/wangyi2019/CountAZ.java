package interview.wangyi2019;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 17:40
 * @Description:
 * 题意： 
 * 排列组合，n个'a'和m个'z'，可以组成的单词数有C(m+n，n）=  (m+n)！/ （ n！* m！）
 *
 * 思路：
 *
 * 假设第一个字符为a，则剩下n-1个'a'和m个'z'组成的子序列只能构成C(n-1+m,n-1)个单词，且是字典中前C(n-1+m,n-1)个单词。
 * 比较k和C(n-1+m,n-1)，若k小，说明k是前C(n-1+m,n-1)个单词，则第一个字符必为'a'。子问题化为在子序列(n-1个'a'和m个'z')找到第k个单词
 * 若k大，则说明第一个字符必为'z',单词是以'z'开头的单词中的第k-C(n-1+m,n-1)个。子问题化为在子序列(n个'a'和m-1个'z')找到第k-C(n+m-1,m-1)个单词。
 * eg:n=2,m=2,k=6
 *
 * 假设第一个字符为a,则剩下1个a,2个z只能构成3个单词，且是字典中前3个单词(azz,zaz,zza)
 * k>3，则第一个字符必为z。
 * 原问题化为在n=2,m=1,k=3，即在剩下2个a，1个z中(aaz,aza,zaa)找到第3个单词
 * 假设第二个字符是a，则剩下1个a，1个z只能构成2个单词(az,za)
 * k>2，所以第二个字符必为z
 * 原问题化为在n=2，m=0，k=1,所以只剩下了1种aa
 * 所以找到zzaa
 **/
public class CountAZ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//a的个数
        int m = scan.nextInt();//z的个数
        long k = scan.nextInt();//目标第几个
        long count = 0;
        ArrayList<String> list = new ArrayList<String>();
        while (m > 0 && n > 0) {//当a和z均存在时执行
            count = pz(n - 1, m, k);//假设a确定，出去一个a之后剩余a和z的排列组合个数
            if (count >= k) {//如果确定a之后，剩余的排列组合数大于目标，则说明a已确定
                list.add("a");
                n--;//a的个数减1
            } else {//如果确定a之后，剩余的排列组合数小于目标，则说明是应该是z。
                list.add("z");
                m--;//z的个数减1
                k -= count;//目标减掉排列组合数。因为如果a开头可以有count种情况，
                //减掉count之后即为确定z开头之后，接下来找第k个即可。
            }
        }
        //循环结束后，剩余子序列只存在"aa..aaa" 或 "zz..zzz"1种情况
        if (k != 1) {//存在经过计算之后必为1
            System.out.println("-1");
            return;
        } else {
            while (n > 0) {//如果z的个数为0，则将剩余a追加到最后
                list.add("a");
                n--;
            }
            while (m > 0) {//如果a的个数为0，则将剩余z追加到最后
                list.add("z");
                m--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public static long pz(int n, int m, long k) {//计算假设a确定之后，a之后的部分排列组合数
        if (n == 0 || m == 0)
            return 1;
        long sum = m + n;
        long count = 1;
        n = Math.min(n, m);     //C(m+n,n)=C(m+n,m) 取最小即可
        for (int i = 0; i < n; i++) {
            count *= sum - i;
            count /= (i + 1);
            if (count > k)//防止大数。如果count>k 则只进行list.add("a")和m--//a的个数减1。
                break;
        }
        return count;
    }

}
