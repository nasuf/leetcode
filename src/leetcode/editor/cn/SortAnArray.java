/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 解释：请注意，nums 的值不一定唯一。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5 * 10⁴
 * -5 * 10⁴ <= nums[i] <= 5 * 10⁴
 * <p>
 * <p>
 * Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 1141 👎 0
 */
package leetcode.editor.cn;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 选择排序
        /*public int[] sortArray(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            for (int i = 0; i < nums.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    minIndex = nums[j] < nums[minIndex] ? j : minIndex;
                }
                swap(nums, minIndex, i);
            }
            return nums;
        }*/

        // 冒泡排序
        /*public int[] sortArray(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            for (int e = nums.length - 1; e > 0; e--) {
                for (int i = 0; i < e; i++) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                }
            }
            return nums;
        }*/

        // 插入排序
        /*public int[] sortArray(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                    swap(nums, j, j + 1);
                }
            }
            return nums;
        }*/

        // 归并排序
        public int[] sortArray(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            process(nums, 0, nums.length - 1);
            return nums;
        }

        public void process(int[] nums, int l, int r) {
            if (l == r) {
                return;
            }
            int m = l + ((r - l) >> 1);
            process(nums, l, m);
            process(nums, m + 1, r);
            merge(nums, l, m, r);
        }

        public int[] merge(int[] nums, int l, int m, int r) {
            int[] help = new int[r - l + 1];
            int i = 0;
            int p1 = l;
            int p2 = m + 1;
            while (p1 <= m && p2 <= r) {
                help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
            }
            while (p1 <= m) {
                help[i++] = nums[p1++];
            }
            while (p2 <= r) {
                help[i++] = nums[p2++];
            }
            for (int j = 0; j < help.length; j++) {
                nums[l + j] = help[j];
            }
            return nums;
        }

        /*public void swap(int[] nums, int i, int j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }*/

        public void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}