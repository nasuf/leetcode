package com.nasuf.codinginterviewguide;

import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 *
 * Tips: 将当前stackPush中的所有内容pop出来进stackPop，这样出队从stackPop，入队进stackPush
 * 当入队时，如果stackPop为空，则将stackPush放入stackPop；stackPop非空则不能执行此操作
 */
public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    private void pushAllToPopStack() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(Integer data) {
        stackPush.push(data);
        pushAllToPopStack();
    }

    public Integer poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty.");
        }
        pushAllToPopStack();
        return stackPop.pop();
    }

    public Integer peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("queue is empty.");
        }
        pushAllToPopStack();
        return stackPop.peek();
    }


}
