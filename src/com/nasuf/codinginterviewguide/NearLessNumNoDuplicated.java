package com.nasuf.codinginterviewguide;

import java.util.Stack;

/**
 * 单调栈问题 - 无重复数字
 */
public class NearLessNumNoDuplicated {

    public static void main(String[] args) {
        NearLessNumNoDuplicated nearLessNum = new NearLessNumNoDuplicated();
        nearLessNum.getNearLessNum(new int[]{3, 4, 1, 5, 6, 2, 7});
    }

    /**
     * arr = [3,4,1,5,6,2,7]
     */
    public int[][] getNearLessNum(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] ans = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int ind = stack.pop();   // 每次弹出时才会对ans进行赋值操作
                int leftInd = stack.isEmpty() ? -1 : stack.peek();
                int rightInd = i;
                ans[ind] = new int[]{leftInd, rightInd};
            }
            stack.push(i);
        }
        /**
         * 处理栈中剩下的数字，此时从栈顶到栈底完全从大到小排列，rightInd为-1
         */
        while (!stack.isEmpty()) {
            int ind = stack.pop();
            int leftInd = stack.isEmpty() ? -1 : stack.peek();
            int rightInd = -1;
            ans[ind] = new int[]{leftInd, rightInd};
        }
        return ans;
    }

}
