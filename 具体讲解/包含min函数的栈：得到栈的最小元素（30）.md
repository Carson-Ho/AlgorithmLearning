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


```

/**
  * 解题思路：通过辅助栈 & 数据栈来实现（栈自己用数组实现）
  *       a. 分别创建1个数据栈 & 辅助栈：数据栈，正常存放数据；辅助栈存放当前数据栈内最小元素
  *       b. 入栈时：
  *          1. 数据栈:正常入栈
  *          2. 辅助栈:若入栈元素 < 栈顶元素（最小元素）,正常入栈;若入栈元素 > 栈顶元素（最小元素）再次入栈 栈顶元素
  *       c. 出栈时：数据栈、辅助栈 同时正常出栈；经过步骤2后，辅助栈内的栈顶元素永远是当前数据栈中的最小元素
  */

import java.util.Iterator;


// 实现栈
public class MinStack<T extends Comparable<T>> {
    private ArrayStack<T> dataStack = new ArrayStack<>();
    private ArrayStack<T> minStack = new ArrayStack<>();

    public void push(T node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            T min = minStack.peek();
            if (min.compareTo(node) > 0) {
                minStack.push(node);
            }else {
                minStack.push(min);
            }
        }
    }

    public void pop() {
        minStack.pop();
        dataStack.pop();
    }

    public T top() {
        return dataStack.peek();
    }

    public T min() {
        return minStack.peek();
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(3);
        System.out.println("top:" + stack.top());
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

// 栈的自身实现（数组）
class ArrayStack<T> implements Iterable<T> {

    private T[] mArray = (T[]) new Object[1];
    private int mSize = 0;

    public boolean isEmpty() {
        return mSize == 0;
    }

    public int size() {
        return mSize;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < mSize; i++)
            temp[i] = mArray[i];
        mArray = temp;
    }

    public void push(T t) {
        if (mSize == mArray.length) resize(2 * mArray.length);
        mArray[mSize++] = t;
    }

    public T pop() {
        T item = mArray[--mSize];
        mArray[mSize] = null;
        if (mSize > 0 && mSize == mArray.length / 4) resize(mArray.length / 2);
        return item;
    }

    public T peek(){
        if (mSize > 0) {
            return mArray[mSize - 1];
        }else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = mSize;

        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            return mArray[--i];
        }

        public void remove() {
        }
    }

}
```