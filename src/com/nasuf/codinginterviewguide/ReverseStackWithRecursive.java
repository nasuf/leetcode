package com.nasuf.codinginterviewguide;

import java.util.Stack;

/**
 * 题目：仅使用递归函数和栈操作逆序一个栈
 */
public class ReverseStackWithRecursive {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        ReverseStackWithRecursive reverseStackWithRecursive = new ReverseStackWithRecursive();
        reverseStackWithRecursive.getLast(stack);
    }

    /**
     * 递归调用getLast()方法，是为了将栈底元素先拿出来返回。
     * 每次递归调用pop出来的top元素，暂存在每个递归的函数内部
     */
    public int getLast(Stack<Integer> stack) {
        Integer top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            int last = getLast(stack);
            stack.push(top);    // 所有递归调用完毕后，将上一层递归pop出来的栈底（倒数第二个元素）重新push进栈
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getLast(stack);
        reverse(stack);
        stack.push(i);
    }

}
