package LeetCode.dynamicPlanning;

/**
 * @author kunrong
 * @description
 * @date 2019/5/27 18:14
 */
public class TwoBuySellStocks {
    public static void main(String[] args){
        int[] a = {3,3,5,0,0,3,1,4};
        new TwoBuySellStocks().maxProfit(a);
    }

    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }
}
