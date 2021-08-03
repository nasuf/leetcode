package com.nasuf.codinginterviewguide;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈问题 - 无重复数字
 */
public class NearLessNumWithDuplicated {

    public static void main(String[] args) {
        NearLessNumWithDuplicated nearLessNum = new NearLessNumWithDuplicated();
        nearLessNum.getNearLessNum(new int[]{3, 4, 1, 5, 6, 2, 7});
    }

    /**
     * arr = [3,4,1,5,6,2,7]
     */
    public int[][] getNearLessNum(int[] arr) {
        Stack<List<Integer>> stack = new Stack<>();
        int[][] ans = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> inds = stack.pop();// 每次弹出时才会对ans进行赋值操作
                int leftInd = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                int rightInd = i;
                for (Integer ind: inds) {
                    ans[ind] = new int[] {leftInd, rightInd};
                }
            }
            if (!stack.isEmpty() && stack.peek().get(0) == arr[i]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        /**
         * 处理栈中剩下的数字，此时从栈顶到栈底完全从大到小排列，rightInd为-1
         */
        while (!stack.isEmpty()) {
            List<Integer> inds = stack.pop();// 每次弹出时才会对ans进行赋值操作
            int leftInd = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            int rightInd = -1;
            for (Integer ind: inds) {
                ans[ind] = new int[] {leftInd, rightInd};
            }
        }
        return ans;
    }

}
