/**
 * @author: zhaopc@tuya.com
 * @date: 2020-06-14 17:52
 * @description 买卖股票的最佳时机 II
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return res;
    }
}
