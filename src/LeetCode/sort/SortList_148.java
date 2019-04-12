package LeetCode.sort;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4

 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5


 */
public class SortList_148 {
    public static void main(String []args){
        ListNode one = new ListNode(1);
        ListNode one2 = new ListNode(2);
        ListNode one3 = new ListNode(3);
        ListNode one4 = new ListNode(4);
        ListNode one5 = new ListNode(5);
        ListNode one6 = new ListNode(6);
        ListNode one7 = new ListNode(7);
        one4.next = one5;
        one5.next = one2;
        one2.next = one;
        one.next = one3;
        System.out.println( new SortList_148().sortList(one4));




    }

    /**
     * 快排思想
     * 4->5->2->1->3
     * 4->5->1->3  2被提取
     * 2->4->5->1->3   2和left交换，left = 2
     * 2->4->5->3    1<4   1被提取
     * 1->2->4->5->3  1指向left，left= 1
     * 3->1->2->4->5 3指向left，left = 3，同时4达到了应该到的位置
     * 3->1->2->4 再次排序，5再次排序，每次的start排到相应的位置。
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }
    // quick sort from start to end
    // use start as the pivot (this may cause some efficiency problem)
    public ListNode quickSort(ListNode start, ListNode end) {
        // quit condition
        if (start == end || start.next == end) {
            return start;
        }
        // partition part. Use cur for loop, left for the left end
        ListNode cur = start;
        ListNode left = start;
        while (cur != null && cur != end) {
            if (cur.next != null && cur.next.val < start.val) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = left;
                left = t;
            } else {
                cur = cur.next;
            }
        }

        left = quickSort(left, start);
        // connect the two seperated linked list
        start.next = quickSort(start.next, end);
        return left;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
