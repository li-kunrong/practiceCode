package LeetCode.problem;

import java.util.Stack;

/**
 *给定一个整数数组 asteroids，表示在同一行的行星。

 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向
 （正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。

 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
 如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

 示例 1:

 输入:
 asteroids = [5, 10, -5]
 输出: [5, 10]
 解释:
 10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。

 示例 2:

 输入:
 asteroids = [8, -8]
 输出: []
 解释:
 8 和 -8 碰撞后，两者都发生爆炸。

 示例 3:

 输入:
 asteroids = [10, 2, -5]
 输出: [10]
 解释:
 2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。

 示例 4:

 输入:
 asteroids = [-2, -1, 1, 2]
 输出: [-2, -1, 1, 2]
 解释:
 -2 和 -1 向左移动，而 1 和 2 向右移动。
 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。

 说明:

 数组 asteroids 的长度不超过 10000。
 每一颗行星的大小都是非零整数，范围是 [-1000, 1000] 。


 */
public class AsteroidCollision_735 {
    /**
     * 思路：
     *  1.遇到栈不为空和负数时，进行碰撞测试
     *  2.其他情况全部进栈即可。
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < asteroids.length; i++) {
            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] <0){
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i]) ) { //少于负行星
                    stack.pop();
                    stack.push(asteroids[i]);
                    collide(stack);//继续查看以前的情况，如果比头部小的（相反方向），就继续碰撞
                }else if (Math.abs(stack.peek()) == Math.abs(asteroids[i]) ){//相等的就抵消了。
                    stack.pop();
                }
            }else {
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        int i = stack.size();
        while(!stack.isEmpty()){
            result[--i] = stack.pop();
        }
        return result;
    }

    public void collide(Stack<Integer> stack) {
        do{
            int top = stack.pop();
            if (!stack.isEmpty() && stack.peek() * top <0){
                if (Math.abs(stack.peek()) < Math.abs(top)){
                    stack.pop();
                    stack.push(top);
                }else if (Math.abs(stack.peek()) == Math.abs(top)) {
                    stack.pop();
                    break;
                }else {
                    break;
                }
            }else if (stack.isEmpty() || stack.peek() * top > 0) {
                stack.push(top);
                break;
            }
        }while(!stack.isEmpty());
    }

}
