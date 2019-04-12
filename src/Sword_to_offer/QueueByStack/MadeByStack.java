package Sword_to_offer.QueueByStack;

import java.util.Stack;
/**
 * Author: kr
 * Date: 2018-4-15
 * Time: 21:30
 * Declaration: All Rights Reserved !!!
 */
public class MadeByStack {
    /**
     * 用两个栈模拟的队列
     * 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
     * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    // 添加操作，成在队列尾部插入结点
    public void push(int node) {
        stack1.add(node);
    }
    //弹出操作，在队列头部弹出结点
    public int pop() {

        // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
        // 并且将弹出的数据压入弹出栈中
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        // 如果弹出栈中还没有数据就抛出异常
        if (stack2.isEmpty()) {
            throw new RuntimeException("No more element.");
        }
        return stack2.pop();
    }
}
