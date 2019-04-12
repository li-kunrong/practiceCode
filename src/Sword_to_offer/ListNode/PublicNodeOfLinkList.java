package Sword_to_offer.ListNode;

public class PublicNodeOfLinkList {
    /**
     * 两个链表的长度+起来是一定的，所以最终到达的尾部一定回相等
     * @param ph1
     * @param ph2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode ph1, ListNode ph2) {
        if(ph1 == null || ph2 == null)
            return null;
        ListNode p1 = ph1;
        ListNode p2 = ph2;
        while(p1!=p2){
            p1 = (p1==null?ph2:p1.next);
            p2 = (p2==null?ph1:p2.next);
        }
        return p1;
    }

    /**
     * 找出的长度差，长的先走长度差，然后一起走，就会后面的公共部分。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;

    }

    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
