package LeetCode.DP;

/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 礼物最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        // 求出有多少行跟多少列
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        // 这个相当于左上角二维数组的第一个元素 对于它自己而言自己就是最大的
        dp[0][0] = grid[0][0];

        // 求第0行的最大值
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }

        // 求第0列的最大值
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row -1][0] + grid[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < col; col++) {
                // 求我自己同列上一行的值 自己同行前一列的值中的较大者 在加上自己就是我能拿到的最大值
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        // 右下角的是最大的值
        return dp[rows - 1][cols - 1];
    }
}
