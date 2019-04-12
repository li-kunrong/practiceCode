package Sword_to_offer.ListNode;

public class DeletSameNode {
    /**
     * 递归写法
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;
        if (pHead.val == pHead.next.val){//相同的跳过
            ListNode node = pHead.next;
            while (node!= null &&pHead.val == node.val){
                node = node.next;
            }
            return deleteDuplication(node);
        }else {
            pHead.next = deleteDuplication(pHead.next);//不相同的下一个
            return pHead;
        }
    }
    public ListNode deleteDuplicationII(ListNode pHead){
        ListNode first = new ListNode(0);
        ListNode pre = first;
        first.next = pHead;
        while (pHead!=null&&pHead.next!=null){
            if (pHead.val == pHead.next.val){
                int val = pHead.val;

                while (pHead.val!=val && pHead!=null){
                    pHead = pHead.next;
                }
                pre.next = pHead;

            }else{
                pHead = pHead.next;
                pre.next = pHead;
            }
        }
        return first.next;
    }

}
