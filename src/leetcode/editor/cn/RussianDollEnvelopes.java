/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= envelopes.length <= 10⁵
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 二分查找 动态规划 排序 👍 890 👎 0
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
                }
            });
            return lengthOfLIS(envelopes);
        }

        private int lengthOfLIS(int[][] envelopes) {
            int[] top = new int[envelopes.length];
            int piles = 0;
            for (int i = 0; i < envelopes.length; i++) {
                int left = 0, right = piles;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (top[mid] >= envelopes[i][1]) {
                        right = mid;
                    } else if (top[mid] < envelopes[i][1]) {
                        left = mid + 1;
                    }
                }
                if (left == piles)
                    piles++;
                top[left] = envelopes[i][1];
            }
            return piles;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}