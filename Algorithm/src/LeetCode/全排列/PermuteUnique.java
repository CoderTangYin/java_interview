package LeetCode.全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 *
 * 不能有重复的
 *
 */
public class PermuteUnique {

    private  List<List<Integer>> list;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        // 先从第一层开始
        dfs(0);
        return list;
    }

    private void dfs(int idx) {
        // 层数等于数字个数意为是当次已经走到最底层了 记录这一次的结果
        if (idx == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int val :
                    nums) {
                result.add(val);
            }
            list.add(result);
        }

        for (int i = idx; i < nums.length; i++) {
            if (isRepeat(nums, idx, i)) continue;
            swap(idx, i);
            dfs(idx + 1);
            // 要把前边交换的数据在换最初的样子供下次使用 这里也是递归到底层后逆着回来的去交换
            swap(idx, i);
        }
    }

    // 判断在idx到i范围是否出现过i索引位置的数字
    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
