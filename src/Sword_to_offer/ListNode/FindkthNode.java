package Sword_to_offer.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第K个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 */
public class FindkthNode {

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        ListNode f=new ListNode(6);
       a.next = b;
       b.next = c;
       c.next = d;
       d.next = e;
       e.next = f;

        System.out.print(FindKthToTail(a,5).val);
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null ) {
            return null;
        }
        if (k == 0) {
            return null;
        }
        ListNode node = head;
        for (int i = 0;i< k-1; i++){
            if (node.next == null){
                return null;
            }
            node = node.next;
        }

        ListNode node1 = head;
        while (node.next != null) {
            node = node.next;
            node1 = node1.next;
        }
        return node1;
    }
}
