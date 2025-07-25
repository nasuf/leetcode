/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。
 * 所以你应该输出 1。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出 2。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= g.length <= 3 * 10⁴
 * 0 <= s.length <= 3 * 10⁴
 * 1 <= g[i], s[j] <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与 2410. 运动员和训练师的最大匹配数 题相同。
 * <p>
 * Related Topics 贪心 数组 双指针 排序 👍 933 👎 0
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int child_length = g.length;
            int cookie_length = s.length;
            int i = 0, j = 0;
            while (i < child_length && j < cookie_length) {
                if (g[i] <= s[j]) {
                    i++;
                }
                j++;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}