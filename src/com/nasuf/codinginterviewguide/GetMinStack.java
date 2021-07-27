package com.nasuf.codinginterviewguide;

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，在实现栈的基本功能基础上，再实现返回栈中最小元素的操作。
 * 要求：
 *  1. pop、push、getMin时间复杂度为O(1)
 *  2. 设计的栈类型可以使用现成的栈结构
 *
 * Tips: 要求是说在实现栈的功能基础上，在pop或者push的任意操作之后，实现返回当前栈中的最小元素的操作。
 */
public class GetMinStack {

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     */
    class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        MyStack1() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(Integer newData) {
            stackData.push(newData);
            if (stackMin.isEmpty() || newData < getMin()) {
                stackMin.push(newData);
            }
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty.");
            }
            if (stackData.peek() == getMin()) {
                stackMin.pop();
            }
            return stackData.pop();
        }

        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty.");
            } else {
                return stackMin.peek();
            }
        }
    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     */
    class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        MyStack2() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(Integer newData) {
            stackData.push(newData);
            if (stackMin.isEmpty()) {
                stackMin.push(newData);
            } else if (getMin() <= newData) {
                stackMin.push(stackMin.peek());
            } else {
                stackMin.push(newData);
            }
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty.");
            } else {
                stackMin.pop();
                return stackData.pop();
            }
        }

        public Integer getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty.");
            } else {
                return stackMin.peek();
            }
        }

    }

}
