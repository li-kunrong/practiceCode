package LeetCode.problem;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3

 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 Credits:
 Special thanks to @stellari for adding this problem and creating all test cases.
 *
 * 描述： 找出两个链表的交点，并且后面的部分全部相同。
 */
public class IntersectionofTwoLinkedLists_160 {
    /**
     * 解决其实很简单，不用计算两个长度，因为加起来长度是一定的，所以第一遍遍历的时候，证明了短的长度呢不会有交点的，到头后就去另一条链的头部
     * 等长链到尾部后，转到短链，就可以比较后面的node了。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null|| headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while ( a != b) {
            a= a==null? headB: a.next;
            b= b==null? headA: b.next;
        }
        return a;
    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
