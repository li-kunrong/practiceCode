package LeetCode.list;

/**
 * 归并两个有序的链表
 * @author kunrong
 * @date 2019/3/18 19:15
 */
public class MergeTwoLists {
    public ListNode mergeTwoSortedLists(ListNode l1 , ListNode l2) {
        if (l1== null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val<l2.val){
            l1.next= mergeTwoSortedLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoSortedLists(l1,l2.next);
            return l2;
        }
    }
}
