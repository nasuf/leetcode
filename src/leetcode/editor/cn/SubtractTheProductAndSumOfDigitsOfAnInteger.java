/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * <p>
 * Related Topics 数学 👍 98 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();
        solution.subtractProductAndSum(0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public int subtractProductAndSum(int n) {
            List<Integer> list = new ArrayList<>();
            int d = 10;
            char[] chars = String.valueOf(n).toCharArray();
            int a = 0;
            int b = 1;
            for (int i = 0; i < chars.length; i++) {
                int digit = Character.digit(chars[i], 10);
                a += digit;
                b *= digit;
            }
            return b - a;
        }*/
        public int subtractProductAndSum(int n) {
            int a = 0;
            int b = 1;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                a += digit;
                b *= digit;
            }
            return b - a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}