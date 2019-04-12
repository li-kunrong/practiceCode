package LeetCode.problem;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class DailyTemperatures_739 {
    /**
     * 暴力解决，听说别人会tlm，是我太幸运了？
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 思路：数组实现栈，用栈来保存当初的index，找到比栈顶大的，就不断继续寻找。
     * @param temp
     * @return
     */
    public int[] dailyTemperaturesII(int[] temp) {
        int len = temp.length;
        int res[] = new int[len];
        int stack[] = new int[len];
        int top = -1;
        int index=0;
        for (int i = 0; i < len; i++) {
            while(top != -1 && temp[i] > temp[stack[top]]) {
                index = stack[top--];
                res[index] = i - index;
            }
            stack[++top] = i;
        }
        return res;
    }
    /**
     *思路：使用一个栈来存储之前完成匹配的下标
     *
     */
    public int[] dailyTemperaturesIII(int[] temp) {
        Stack<Integer> stack=new Stack<Integer>();
        int [] res=new int[temp.length];
        for(int i=0;i<temp.length;i++){
            while(!stack.empty()&&temp[i]>temp[stack.peek()]){
                int index=stack.pop();
                res[index]=i-index;
            }
            //将下标存储
            stack.push(i);
        }
        return res;
    }
}
