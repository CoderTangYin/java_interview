package LeetCode.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    /**
     * 非递归前序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + "__");
            if (cur.right != null) { stack.push(cur.right);}
            if (cur.left != null) { stack.push(cur.left);}
        }
    }

    /**
     * 非递归中序遍历  升序跟降序
     *
     * @param root
     */
    public void midOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) { stack.push(root); root = root.left;}
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + "__");
                root = root.right;
            }
        }
    }

    /**
     * 非递归后续遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = cur;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { stack.push(cur); cur = cur.left;} else {
                cur = stack.pop();
                if (cur.right == null || cur.right == pre) {
                    System.out.print(cur.val + "__");
                    pre = cur;
                    cur = null;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                    stack.push(cur);
                    cur = cur.left;
                }
            }

        }

    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "__");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode rootL = new TreeNode(2);
        TreeNode leftL = new TreeNode(1);
        TreeNode rightL = new TreeNode(3);
        rootL.left = leftL;
        rootL.right = rightL;

        TreeNode rootR = new TreeNode(6);
        TreeNode leftR = new TreeNode(5);
        TreeNode rightR = new TreeNode(7);
        rootR.left = leftR;
        rootR.right = rightR;

        TreeNode root = new TreeNode(4);
        root.left = rootL;
        root.right = rootR;

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.midOrder(root);
        System.out.println();
        binaryTree.levelOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
    }
}
