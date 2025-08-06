/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * <p>
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * <p>
 * <p>
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * <p>
 * <p>
 * Related Topics 脑筋急转弯 数学 动态规划 博弈 👍 441 👎 0
 */
package leetcode.editor.cn;

public class DivisorGame {
    public static void main(String[] args) {
        Solution solution = new DivisorGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public boolean divisorGame(int n) {
            return n % 2 == 0;
        }*/

        public boolean divisorGame(int n) {
            boolean[] dp = new boolean[n + 1];
            dp[1] = false;
            if (n >= 2) {
                dp[2] = true;
            }
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    if (i % j == 0 && !dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}