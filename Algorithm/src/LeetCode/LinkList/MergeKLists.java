package LeetCode.LinkList;

import java.util.PriorityQueue;

/**
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MergeKLists {

    /**
     * 最小堆解法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        // 层序遍历每个头结点
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode l1, ListNode l2) -> {
            return l1.val - l2.val;
        });
        // 把头结点加进去
        for (ListNode l : lists) {
            if (l == null) continue;
            queue.offer(l);
        }
        // 串起来
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail = tail.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummyHead.next;
    }

    /**
     *
     * 递归分治合并  把K个链表转成合并2个链表的操作
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int step = 1;
        while (step < lists.length) {
            int nextStep = step >> 1;
            for (int i = 0; i + step < lists.length; i += nextStep) {
                // 转成合并2个链表
                // list[i] = mergeTwoLists(lists[i], lists[i + step])
            }
            step = nextStep;
        }
        return lists[0];
    }
}
