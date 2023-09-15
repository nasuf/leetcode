/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * Related Topics 数组 哈希表 分治 计数 排序 👍 1959 👎 0
 */
package leetcode.editor.cn;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 哈希法
        /*public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            Map.Entry<Integer, Integer> maxEntry = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
            return maxEntry.getKey();
        }*/

        // 排序
        /*public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }*/

        // 随机数
        public int majorityElement(int[] nums) {
            Random random = new Random();
            while (true) {
                int target = nums[random.nextInt(nums.length)];
                int mid = nums.length / 2;
                int count = 0;
                for (int num : nums) {
                    if (num == target) {
                        count++;
                    }
                }
                if (count > mid) {
                    return target;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}