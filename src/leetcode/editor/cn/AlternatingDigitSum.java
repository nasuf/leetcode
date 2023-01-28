/**
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * <p>
 * <p>
 * 返回所有数字及其对应符号的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数学 👍 4 👎 0
 */
package leetcode.editor.cn;

public class AlternatingDigitSum {
    public static void main(String[] args) {
        Solution solution = new AlternatingDigitSum().new Solution();
        solution.alternateDigitSum(521);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int alternateDigitSum(int n) {
            int tmp = 0;
            int count = 0;
            int length = String.valueOf(n).length();
            boolean positive = length % 2 != 0;
            while (n != 0) {
                tmp = n % 10;
                count += positive ? tmp : -tmp;
                n = n / 10;
                positive = !positive;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}