package Sword_to_offer.problem;

import java.util.Stack;

/**
 * 题目：

 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O（1）。

 思路：

 要使时间复杂度是O（1），需要每次压入一个新元素进栈时，将栈里的所有元素排序，
 让最小的元素位于栈顶。但是这种想法不能保证最后压入栈的元素能够最先出栈，因为这个数据结构已经不是栈了。

 于是借助于一个辅助的成员变量来存放最小的元素。每次压入一个新元素进栈的时候，如果该元素比当前最小的元素还要小，
 则更新最小元素，但是如果当前做小的元素被弹出栈了，怎么得到下一个最小元素是一个问题。
 分析到这里我们发现仅仅添加一个成员变量存放最小元素是不够的，也就是说当最小元素被弹出栈的时候，
 我们希望能够得到次小的元素。因此在压入最小元素之前，我们要把次小元素保存起来。故可以借助一个辅助栈把每次的最小元素都保存起来。

 例子佐证：


 */
public class Min_Stack_21 {
    Stack<Integer> data = new Stack<Integer>(); //存放元素栈
    Stack<Integer> min = new Stack<Integer>(); //辅助栈，data栈中每次进入一个元素，min辅助栈就存放当前data栈中的最小元素

    //data栈和min栈进入元素
    public void stackWithMinPush(int item){
        data.push(item);
        if(min.size() == 0 || item < min.peek()){
            min.push(item);
        }else{
            min.push(min.peek());
        }
    }

    //data栈和min栈弹出元素
    public void stackWithMinPop(){
        if(data.size() > 0 && min.size() > 0){
            data.pop();
            min.pop();
        }
    }

    //data栈的栈顶元素
    public int stackWithDataTop(){
        if(data.size() > 0){
            return data.peek();
        }
        return 0;
    }
    //min栈的栈顶元素，栈顶元素为data栈中现有元素的最小元素
    public int stackWithMinMin(){
        if(data.size() > 0 && min.size() > 0){
            return min.peek();
        }
        return 0;
    }
}
