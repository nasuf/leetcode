/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 27
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 0
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 9
 * 输出：true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：n = 45
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= n <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 * Related Topics 递归 数学 👍 252 👎 0
 */
package leetcode.editor.cn;

public class PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new PowerOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfThree(int n) {
            while (n != 0 && n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}