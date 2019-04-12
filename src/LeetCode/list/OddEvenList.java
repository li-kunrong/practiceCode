package LeetCode.list;

/**
 * @author kunrong
 * @description
 * @date 2019/3/18 19:52
 */
public class OddEvenList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(10);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(23);
        ListNode l5 = new ListNode(44);
        l1.next= l2;
        l2.next= l3;
        l3.next= l4;
        l4.next= l5;
        l1 = new OddEvenList().oddEvenList(l1);
        while (l1!=null) {
            System.out.print(l1.val+"->");
            l1 = l1.next;
        }

    }
    public  ListNode oddEvenList(ListNode root) {
        if (root== null )
            return root;
        ListNode odd = root, even = root.next, evenHead = even;
        while (even!=null &&even.next!=null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return root;
    }
}
