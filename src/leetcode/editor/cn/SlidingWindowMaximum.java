//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列）


package leetcode.editor.cn;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ret = new int[nums.length - k + 1];
            LinkedList<Integer> qmax = new LinkedList<>();
            int retIndex = 0;
            for (int i=0; i < nums.length; i++) {
                while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                    qmax.pollLast();
                }
                qmax.addLast(i);
                if (qmax.peekFirst() == i - k) {
                    // 队首索引过期，应移除
                    qmax.pollFirst();
                }
                if (i >= k-1) {
                    // 窗口出现
                    ret[retIndex++] = nums[qmax.peekFirst()];
                }
            }
            return ret;
        }

        /*public int[] maxSlidingWindow(int[] nums, int k) {
            int retSize = nums.length - k + 1;
            int[] ret = new int[retSize];
            ret[0] = getMax(nums, 0, k);
            for (int i = 1; i < retSize; i++) {
                if (ret[i - 1] == nums[i - 1]) {
                    ret[i] = getMax(nums, i, k);
                } else if (nums[i + k - 1] > ret[i - 1]) {
                    ret[i] = nums[i + k - 1];
                } else {
                    ret[i] = ret[i - 1];
                }
            }
            return ret;
        }

        private int getMax(int[] nums, int start, int k) {
            int max = nums[start];
            for (int i = start + 1; i < start + k; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}