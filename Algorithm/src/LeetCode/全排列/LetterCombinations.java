package LeetCode.全排列;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private  List<List<Integer>> list;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
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
            swap(idx, i);
            dfs(idx + 1);
            // 要把前边交换的数据在换最初的样子供下次使用 这里也是递归到底层后逆着回来的去交换
            swap(idx, i);
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
