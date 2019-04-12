package LeetCode.string;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 Example 1:

 Input: "3+2*2"
 Output: 7

 Example 2:

 Input: " 3/2 "
 Output: 1

 Example 3:

 Input: " 3+5 / 2 "
 Output: 5

 */
public class BasicCalculatorII_227 {
    public static void main(String[] args) {
        String s = "2+2*2";
        int n = new BasicCalculatorII_227().calculate(s);
        System.out.println(n);
    }

    /**
     * Solution：用char来存储最后的运算符号，，首先默认是‘+’，然后转换digit成number
     * 当op是：
     * ‘+’：将转换好的number加到stack中
     * ‘-’：将-num加到stack中
     * ‘*’：栈顶的数乘以num存到栈顶
     * ‘/’；栈顶的数除以num存到栈顶中
     * @param s
     * @return
     */
    public int calculate(String s) {
        int num = 0;
        char op = '+';
        int top = 0;
        int[] stack = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            switch (op) {
                case '+':
                    stack[++top] = num;
                    num = 0;
                    break;
                case '-':
                    stack[++top] = (0 - num);
                    num = 0;
                    break;
                case '*':
                    stack[top] = stack[top] * num;
                    num = 0;
                    break;
                case '/':
                    stack[top] = stack[top] / num;
                    num = 0;
                    break;
            }
            if (i < s.length()) op = s.charAt(i);
        }
        for (int i : stack) {
            num += i;
        }
        return num;
    }
}
