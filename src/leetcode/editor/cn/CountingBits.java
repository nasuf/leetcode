/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 * <p>
 * <p>
 * Related Topics 位运算 动态规划 👍 1169 👎 0
 */
package leetcode.editor.cn;

public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * Brian Kernighan 算法
         */
        /*public int[] countBits(int n) {
            int[] ret = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                ret[i] = count(i);
            }
            return ret;
        }

        private int count(int i) {
            int count = 0;
            while (i > 0) {
                i &= i - 1;
                count++;
            }
            return count;
        }*/

        /**
         * 动态规划 - 最高有效位算法
         */
        public int[] countBits(int n) {
            int[] bits = new int[n + 1];
            int high = 0;
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) {
                    high = i;
                }
                bits[i] = bits[i - high] + 1;
            }
            return bits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}