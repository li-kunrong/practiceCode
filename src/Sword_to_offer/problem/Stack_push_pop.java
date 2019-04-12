package Sword_to_offer.problem;

import java.util.Stack;

public class Stack_push_pop {
    /**
     * 开一个辅助栈，每次把入栈序列压入，然后把栈顶和出栈序列的比较，若相等，就pop，指针往后移动，知道最后的栈为空，就说明出栈序列是对的。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while ((!stack.empty()) && (stack.peek() == popA[j])) {
                stack.pop();
                j++;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
