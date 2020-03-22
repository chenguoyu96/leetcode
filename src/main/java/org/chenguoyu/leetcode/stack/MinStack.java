package org.chenguoyu.leetcode.stack;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    private ArrayList<Integer> arrays;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        arrays = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        arrays.add(x);
    }

    public void pop() {
        Integer integer = arrays.get(arrays.size() - 1);
        arrays.remove(arrays.size() - 1);
        if (integer==min){
            min = Integer.MAX_VALUE;
            for (Integer value : arrays) {
                min = Math.min(value,min);
            }
        }
    }

    public int top() {
        return arrays.get(arrays.size() - 1);
    }

    public int getMin() {
        return min;
    }

    @Test
    public void main() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
