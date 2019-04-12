package LeetCode.list;
/**
 * 142. Linked List Cycle II

 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 *这个题目很坑，一开始没看懂题目，看了题解，服
 * 解法思想：
 主要思想和上一个算法前面基本一样，也是设置一个快指针fp和一个慢指针sp，所不同的是这回是要求出如果链表存在环，
 那么求出环入口的起始结点。接下来我们就是要从上面的算法中做出一定程度的改变就可以完成题目的要求了。我首先说一下具体的解法，推导过程后面再说。
 如果链表中存在环，那么fp和sp一定会相遇，当两个指针相遇的时候，我们设相遇点为c，此时fp和sp都指向了c，接下来令fp继续指向c结点，
 sp指向链表头结点head，此时最大的不同是fp的步数变成为每次走一步，令fp和sp同时走，每次一步，那么它们再次相遇的时候即为环的入口结点。
 接下来我们也许想知道为什么fp和sp指向上面所说的结点之后同时以步数为一走再次相遇的时候一定会指向环的入口结点？


 * h------(a)-----d---------(s)------c-----------------d;
 * 问题可以转化成求c到d的距离cd为什么等于h到d的距离hd？

 首先如图所示，链表的整个长度为L，链表头head为h，假设fp和sp按照箭头所示的方向走。其中环入口点为d，h到d的距离hd为a。fp和sp假设初次相遇在c，初次相遇的时候慢指针sp肯定没有走完整个链表。设d到c的距离dc为x，h到c的距离即为sp初次相遇所走的路程，即设hc长度为s。此外设环的长度为r。而在fp和sp初次相遇在c点的时候，fp则在环内已经走了n圈。由于fp的速度是sp的2倍，接下来我们可以得出：
 2s = s + nr
 ->    s = nr  (1)
 又因为hd距离为a，dc距离为x，hc距离为s，所以可以得出：
 a + x = s   (2)
 结合(1)和(2)可以得出：
 a + x = nr   ->    a + x = (n-1)r + r   ->    a + x = (n-1)r + (L-a)        注释：L-a即为环长r
 ->     a = (n-1)r + (L-a-x)
 即此时h到d的距离a等于c到d的距离(L-a-x)。所以当fp和sp初次相遇在c点的时候，令fp从c点出发，sp指向
 链表头h，两个同时以步数为1同时出发，则再次相遇的时候即为环的入口节点d。


 */
public class HasCircleList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        ListNode r4 = new ListNode(5);
        ListNode r5 = new ListNode(6);
        head.next= r1;
        r1.next = r2;
        r2.next= r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r2;
        System.out.println(new HasCircleList2().detectCycle(head).val);


    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
