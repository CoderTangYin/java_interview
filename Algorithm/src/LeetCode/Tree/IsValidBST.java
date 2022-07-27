package LeetCode.Tree;

import java.util.Stack;

/**
 *
 * 判断一棵树是不是二叉搜索树
 *
 * 利用中序遍历
 *
 */
public class IsValidBST {

    public Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            root = stack.pop();
            if (prev != null &&  root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
