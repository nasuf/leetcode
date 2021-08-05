//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈


package leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        solution.trap(new int[] {0,1,3,2,1,0,1,3,2,1,2,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * [2,1,3,2,1,0,1,3,2,1,2,1]
     * 如果 height[i] > height[top]，则得到一个可以接雨水的区域，该区域的宽度是 i−left−1，
     * 高度是 min( height[left], height[i] ) − height[top]
     */
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int top = stack.pop();
                    if (!stack.isEmpty()) {
                        int width = i - stack.peek() - 1;
                        int h = Math.min(height[stack.peek()], height[i]) - height[top];
                        ans += width * h;
                    }
                }
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}