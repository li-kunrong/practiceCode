package LeetCode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * */
public class RandomListNode_138 {
    /**
     * 按照原链表next的顺序依次创建节点，并处理好新链表的next指针，同时把原节点与新节点的对应关系保存到一个hash_map中，
     * 然后第二次循环将random指针处理好。这种方法的时间复杂度是O(n)，空间复杂度也是O(n)。
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    /**
     * 第二种方法则是在原链表的每个节点之后插入一个新的节点，这样原节点与新节点的对应关系就已经明确了，
     * 因此不需要用hash_map保存，但是需要第三次循环将整个链表拆分成两个。这种方法的时间复杂度是O(n)，空间复杂度是O(1)。
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
    }

    /**
     * 复制结点，复制的结点放在待复制的结点后，依然组成一个单链表
     *
     * @param head 链表头
     */
    public void copyNode(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
            // 复制一个新的结点
            RandomListNode copyNode = new RandomListNode(node.label);
            // 将结点串接到被复制的结点后，并且依然组成单链表
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    /**
     * 串接随机指针
     *
     * @param head 链表头
     */
    public void linkRandomPointer(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
            // 随机指针有指向某个具体的结点
            if (node.random != null) {
                // 串接node被复制结点的随机指针
                node.next.random = node.random.next;
            }

            // 指向下一个被复制的结点
            node = node.next.next;
        }
    }

    /**
     * 将链表拆分，还原原来的链表，并且组装拷贝的链表
     *
     * @param head 链表头
     * @return 拷贝的新链表头
     */
    public RandomListNode splitList(RandomListNode head) {
        // 新链表头
        RandomListNode copyHead = head.next;
        // 当前处理的被复制的结点
        RandomListNode node = head;
        // 当前复制的结点
        RandomListNode copy;

        while (node != null){
            // 指向复制结点
            copy = node.next;

            // node.next指向下一个被复制的结点
            node.next = copy.next;

            // 下一个被复制的结点不为null
            if (node.next != null) {
                // copy.next指向下一个复制的结点
                copy.next = node.next.next;
            }

            // node指向下一个要被处理的被复制结点
            node = node.next;
        }
        return copyHead;
    }
}
