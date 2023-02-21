/**
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] ==
 * target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 * <p>
 * 返回 abs(i - start) 。
 * <p>
 * 题目数据保证 target 存在于 nums 中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5], target = 5, start = 3
 * 输出：1
 * 解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1], target = 1, start = 0
 * 输出：0
 * 解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 0 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
 * 输出：0
 * 解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10⁴
 * 0 <= start < nums.length
 * target 存在于 nums 中
 * <p>
 * <p>
 * Related Topics 数组 👍 15 👎 0
 */
package leetcode.editor.cn;

public class MinimumDistanceToTheTargetElement {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceToTheTargetElement().new Solution();
        System.out.println(solution.getMinDistance(new int[]{5, 2, 3, 5, 5}, 5, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    min = Math.min(min, Math.abs(i - start));
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}