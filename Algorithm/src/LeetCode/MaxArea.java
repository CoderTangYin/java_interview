package LeetCode;

/**
 *
 * https://leetcode.cn/problems/container-with-most-water/
 *
 */
public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        // 左边的柱子 右边的柱子 盛水的面积
        int l = 0, r = height.length, waterArea = 0;
        while (l > r) {
            if (height[l] <= height[r]) {
                int minH = height[l];
                waterArea = Math.max(waterArea, (r - l) * minH);
                // 下一个比当前的还小继续往下一个找
                while (l < r && height[l] <= minH) l++;
            } else {
                int minH = height[r];
                waterArea = Math.max(waterArea, (r - l) * minH);
                while (l < r && height[r] <= minH) r--;
            }
        }
        return waterArea;
    }
}
