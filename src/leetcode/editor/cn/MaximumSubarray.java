//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划


package leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        solution.maxSubArray(new int[]{-2,10,-1,3,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1. 首先保证找到第一个正数，因为如果前面都是负数，那么对sum无增益效果
     * 2. 累加之后每一项，判断之前的累加之和与当前累加之和的最大值，赋值给ans
     * （如果当前项为正数自然有增益效果，判断max的时候肯定是要加上这一项的；
     * 如果为负数，但是没有导致sum为负，那么判断max的时候，肯定是不包含这一项，sum为之前项的和
     */
    class Solution {
        /*public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int sum = 0;
            for(int num: nums) {
                if(sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }*/

        /**
         * 动态规划算法
         * dp[i]定义为：以nums[i]为结尾的最大连续子数组
         */
        /*public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                result = Math.max(result, dp[i]);
            }
            return result;
        }*/

        /**
         * 动态规划算法
         * 由于dp[i]仅与dp[i-1]有关，所以可以进一步压缩空间
         */
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int dp_0 = nums[0], dp_1 = 0, res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp_1 = Math.max(nums[i], nums[i] + dp_0);
                dp_0 = dp_1;
                res = Math.max(res, dp_1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}