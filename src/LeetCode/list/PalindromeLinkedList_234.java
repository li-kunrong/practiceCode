package LeetCode.list;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false

 Example 2:

 Input: 1->2->2->1
 Output: true

 Follow up:
 Could you do it in O(n) time and O(1) space?

 */
public class PalindromeLinkedList_234 {
    /**
     * 判断是否是回文串，用快指针分半，然后判断
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, cur = head,pre = null;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            ListNode next = cur.next;
            cur.next= pre;
            pre = cur;
            cur = next;
        }
        if (fast!=null)
            cur = cur.next;
        while (pre!=null && cur!=null){
            if (pre.val!=cur.val){
                return false;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return true;
    }
}
