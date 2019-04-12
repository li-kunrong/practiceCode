package Sword_to_offer.ListNode;
/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 核心：当前节点不为null，先取下个节点，翻转当前节点，然后前一个节点向前，然后当前节点向前。
 * @return 反转后的链表的头结点
 *
 *  不递归的版本是定义cur， pre, next
 *  想让next = cur.next
 *  cur.next = pre;
 *  pre = cur;
 *  cur = next;
 *  如此循环
 *  reverHead = cur;
 *
 *  对递归的简述：
 *  haed.next == null 就返回head
 *  然后让pre = back(head.next)
 *  head.next.next = head; 就是让后面一个指向自己
 *  然后head.next = null ,让自己指向null
 *  return pre；
 */
public class Reverse {

    public static void main(String[] args) throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;
//        ListNode newNode = new Reverse().ReverseList(node1);
//        System.out.println(newNode.val);
        ListNode Node2 = new Reverse().backtrace(node1);
        while (Node2!=null){
            System.out.println(Node2.val);
            Node2 = Node2.next;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            reverseHead = cur;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseHead;
    }
    public ListNode backtrace(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = backtrace(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
