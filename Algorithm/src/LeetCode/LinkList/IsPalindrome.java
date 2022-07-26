package LeetCode.LinkList;

/**
 * 回文链表。   利用快慢指针的典型题
 */
public class IsPalindrome {

    /**
     *
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 找到中间节点并进行反转
        ListNode rh = reverseNode(middleNode(head));
        ListNode lh = head;
        ListNode roldh = rh;
        boolean res = true;
        while (rh != null) {
            if (rh.val != lh.val) {res = false; break;}
            rh = rh.next;
            lh = lh.next;
        }
        // 恢复链表结构
        reverseNode(roldh);
        return res;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseNode(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }


}
