/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2³¹ - 1
 * 0 <= amount <= 10⁴
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 动态规划 👍 3098 👎 0
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        // 自顶向下迭代解法
        /*public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -666);
            return change(coins, amount);
        }

        public int change(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            if (memo[amount] != -666)
                return memo[amount];
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int sub = change(coins, amount - coin);
                if (sub == -1) continue;
                res = Math.min(res, sub + 1);
            }
            memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
            return memo[amount];
        }*/

        // 自底向上迭代解法
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1 ? -1 : dp[amount]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}