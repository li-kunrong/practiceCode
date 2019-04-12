package LeetCode.list;
/**
 * 141. Linked List Cycle

 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 *这是一道水题，乍一看用一个set保存就好，但他说不准用另外的空间辅助，所以只能用两个指针解决，前面的指针是后面的指针的两倍速度
 * 若是循环链表必会相等。
 */
public class HasCircleList {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
