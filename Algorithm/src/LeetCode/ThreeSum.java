package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 中等难度 
 *
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);

        // 用来扫描的只能扫描到倒是第三个
        int lastIdx = nums.length - 3;
        // 最右侧的指针指向数组最后一个元素
        int lastR = nums.length - 1;
        for (int i=0; i<lastIdx; i++) {
            // 自己个自己前边的一样就跳过
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = lastR, remain = -nums[i];
            while (i < r) {
                int sumLr = nums[l] + nums[r];
                if (sumLr == remain) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sumLr < remain) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return list;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }
}
