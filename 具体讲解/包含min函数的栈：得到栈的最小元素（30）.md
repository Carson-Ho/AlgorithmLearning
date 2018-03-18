# 1. 问题描述
定义栈的数据结构，在该结构中实现1个 `min`函数，功能 = 得到栈的最小元素
>要求：调用`min（）`、`push（）`及 `pop（）`的时间复杂度都是`O（1）`


***
# 2. 考察点
- 栈的理解 & 使用
- 解决抽象问题的方法：通过具体例子找出规律

***
# 3. 解题思路

![示意图](http://upload-images.jianshu.io/upload_images/944365-2ce497b5e0ab1c53.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

***
# 4. 算法示意图

![示意图](http://upload-images.jianshu.io/upload_images/944365-d3bee24b347a1770.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

***

# 5. 算法实现
- 具体请看注释

```
import java.util.Stack;

/**
 * Created by Carson_Ho on 17/11/4.
 */

public class Exam_30 {

    /**
     * 测试用例
     */
    public static void main(String[] args){
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

}

    /**
    * 解题类：含min函数的栈结构（类）
    */
    class StackWithMin {

    // 1. 定义2个栈：数据栈、辅助栈
    private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();

    // 2. 定义入栈规则
    public void push(int data){
        // 对于数据栈：正常入栈
        stackData.push(data);

        // 对于辅助栈：
        // 若入栈元素 < 栈顶元素（最小元素），正常入栈；
        // 若入栈元素 > 栈顶元素（最小元素），再次入栈 栈顶元素
        if(stackMin.isEmpty())
            stackMin.push(data);

        else{
            int temp = stackMin.peek();
            if(temp < data)
                stackMin.push(temp);
            else
                stackMin.push(data);
        }
    }

    // 3. 定义出栈规则
    public void pop(){
        // 数据栈 & 辅助栈都正常出栈
        // 注：要判断空栈的情况
        if(!(stackMin.isEmpty())) {
            stackMin.pop();
        }

        if(!(stackData.isEmpty())) {
            stackData.pop();
        }

    }

    // 4. 获得当前数据栈最小元素（不是出栈）
    // 根据上述入栈规则后，辅助栈保证了在与数据栈同步出栈时，每次出栈元素均为当前数据栈中的最小元素
    // 故，若需获得当前数据栈最小元素，直接出栈辅助栈元素即可
    public int min(){
        // 注：要判断空栈的情况
        if(stackMin.isEmpty())
            return -1;

        int num = stackMin.pop();
        stackMin.push(num);
        return num;
    }

    // 5. 获取数据栈栈顶元素
    // 注：不是出栈
    public int top(){
        // 注：要判断空栈的情况
        if(stackData.isEmpty())
            return -1;

        int num = stackData.pop();
        stackData.push(num);
        return num;
    }
}
```

- 测试结果

```
1
2
3
3
-1
```

***
# 6. Demo地址
[Carson_Ho的Github地址：面试30 - 包含min函数的栈](https://github.com/Carson-Ho/AlgorithmLearning)