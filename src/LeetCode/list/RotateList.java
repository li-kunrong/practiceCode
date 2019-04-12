package LeetCode.list;

/**
 * 61. Rotate List
 *
 * Given a list, rotate_naive the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 * 想形成环，然后len-k模len，计算翻转个数，然后就可以置head.next= null
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null ) {
            return null;
        }
        int len = 1;
        ListNode copyhead = head;
        while (copyhead.next!=null){
            copyhead = copyhead.next;
            len++;
        }
        copyhead.next = head;
        for (int i = len - k%len; i >1; i--) {
            head = head.next;
        }
        copyhead = head.next;
        head.next = null;
        return copyhead;
    }
}
