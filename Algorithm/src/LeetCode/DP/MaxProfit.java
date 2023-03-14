package LeetCode.DP;

/**
 *
 * 买卖股票最佳时机
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {

    // 非动态规划解法
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 默认第一天买入第一天卖出 收益是0
        int minPrice = prices[0], maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第i天的价格比买入的那天还少 即为花三块买的1块卖 赔本不能卖
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxPrice = Math.max(maxPrice, prices[i] - minPrice);
            }
        }
        return maxPrice;
    }

    // 动态规划
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 第I天买第J天卖 动态规划是求 I~J的两两天数之间差值的全部和
        int dp[] = new int[prices.length];
        int maxProfit = 0;
        dp[0] = prices[1] - prices[0];
        maxProfit = Math.max(0, dp[0]);
        for (int i = 2; i < prices.length; i++) {
           maxProfit = Math.max(maxProfit, dp[i] + dp[i-1]);
           dp[i] = prices[i] - prices[i-1];
        }
        return maxProfit;
    }

}
