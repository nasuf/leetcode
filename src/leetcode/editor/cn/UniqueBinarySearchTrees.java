//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树


package leetcode.editor.cn;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 假设G(n)为n个节点组成的二叉搜索树个数，f(i)为以i为根节点组成的二叉搜索树个数，则：
         * G(n) = f(1) + f(2) + ... + f(n);
         * 对于f(i)，以i为根节点，那么1 ~ i-1在i的左节点，i+1 ~ n在i的右节点，因此：
         * f(i) = G(i-1) * G(n-i)
         *
         * => G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
         *
         * 特殊情况：
         * 当i = 0; G(n) = 1;
         * 当i = 1; G(n) = 1;
         */
        public int numTrees(int n) {
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j-1] * dp[i-j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}