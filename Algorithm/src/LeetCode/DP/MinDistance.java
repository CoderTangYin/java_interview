package LeetCode.DP;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        // 空串转为空串的情况 不需要转换
        dp[0][0] = 0;
        // 0列  转换成空串的最少操作数
        for (int i = 1; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        // 0行
        for (int i = 1; i <= chars2.length; i++) {
            dp[0][i] = 0;
        }
        // 其他行跟列
        for (int i = 1; i <= chars1.length; i++) {
            for (int j=1; j<=chars2.length; j++) {
                int top = dp[i-1][j] + 1;
                int left = dp[i][j-1] + 1;
                int leftTop = dp[i-1][j-1];
                if(chars1[i-1] != chars2[j-1]) { leftTop++ };
                dp[i][j] = Math.min(Math.min(top, left), leftTop);
            }
        }
        return dp[chars1.length][chars2.length];
    }

}
