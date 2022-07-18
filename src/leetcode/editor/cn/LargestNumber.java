/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10⁹
 * <p>
 * Related Topics 贪心 字符串 排序 👍 970 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int length = nums.length;
            String[] arr = new String[length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(arr, (a, b) ->
                    (b + a).compareTo(a + b)
            );
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            String result = sb.toString();
            int k = 0;
            while (k < result.length() - 1 && result.charAt(k) == '0')
                k++;
            return result.substring(k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}