package LeetCode;

/**
 * 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree {

    /**
     *
     * 输入：[3,2,1,6,0,5]
     * 输出：返回下面这棵树的根节点：
     *
     *       6
     *     /   \
     *    3     5
     *     \    /
     *      2  0
     *        \
     *         1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;
        // 假设l就是最大索引
        int maxIdx = l;
        // 从l+1位置找到r的最大值
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        // 从整个数组里边找到最大的一个数作为根节点
        TreeNode root = new TreeNode(nums[maxIdx]);
        // 递归的方式构建0~最大数的左子树
        root.left = findRoot(nums,l, maxIdx);
        // 递归的方式构建最大数+1 ~ 数组长度构建的又子树
        root.right = findRoot(nums, maxIdx, r);
        return root;
    }


}
