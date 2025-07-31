/**
 * 现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
 * <p>
 * <p>
 * 只能从架子的左上角开始拿珠宝
 * 每次可以移动到右侧或下侧的相邻位置
 * 到达珠宝架子的右下角时，停止拿取
 * <p>
 * <p>
 * 注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：frame = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：12
 * 解释：路径 1→3→5→2→1 可以拿到最高价值的珠宝
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 < frame.length <= 200
 * 0 < frame[0].length <= 200
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 554 👎 0
 */
package leetcode.editor.cn;

public class LiWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
        solution.jewelleryValue(new int[][]{
                {1, 2, 5},
                {3, 2, 1}
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jewelleryValue(int[][] frame) {
            int m = frame.length; // m 行
            int n = frame[0].length; // n 列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    if (i == 0)
                        frame[i][j] += frame[i][j - 1];
                    else if (j == 0)
                        frame[i][j] += frame[i - 1][j];
                    else
                        frame[i][j] += Math.max(frame[i - 1][j], frame[i][j - 1]);
                }
            }
            return frame[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}