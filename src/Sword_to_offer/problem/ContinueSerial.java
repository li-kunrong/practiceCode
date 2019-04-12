package Sword_to_offer.problem;

import java.util.ArrayList;

public class ContinueSerial {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c451a3fd84b64cb19485dad758a55ebe
     来源：牛客网

     ）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，
     而这个序列的中间值代表了平均值的大小。假设序列长度为n，那么这个序列的中间值可以通过（S / n）得到，
     知道序列的中间值和长度，也就不难求出这段序列了。
     2）满足条件的n分两种情况：
     n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
     n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，
     所以条件为：(sum % n) * 2 == n.余数为除数的一半
     3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，
     但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
     根据等差数列的求和公式：S = (1 + n) * n / 2，得到.

     最后举一个例子，假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），
     n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。
     完整代码：时间复杂度为
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int)Math.sqrt(sum*2); n>=2; n--) {
            if ((n&1)==1 && sum%n==0 || (sum%n)*2==n) {
                ArrayList<Integer> list = new ArrayList<>();
                // (k+k+n-1)*n/2 = sum
                for (int j = 0, k = sum/n-(n-1)/2; j<n; j++,k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 双指针解决
     * 初始化small=1，big=2;
     * small到big序列和小于sum，big++;大于sum，small++;
     * 当small增加到(1+sum)/2是停止
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequenceII(int sum) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        if(sum<=1){return lists;}
        int small=1;
        int big=2;
        while(small!=(1+sum)/2){          //当small==(1+sum)/2的时候停止
            int curSum=sumOfList(small,big);
            if(curSum==sum){
                ArrayList<Integer> list=new ArrayList<Integer>();
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                lists.add(list);
                small++;big++;
            }else if(curSum<sum){
                big++;
            }else{
                small++;
            }
        }
        return lists;
    }

    public int sumOfList(int head,int leap){        //计算当前序列的和
        int sum=head;
        for(int i=head+1;i<=leap;i++){
            sum+=i;
        }
        return sum;
    }
}
