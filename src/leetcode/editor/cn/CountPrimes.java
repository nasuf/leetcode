//统计所有小于非负整数 n 的质数的数量。
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 数组 数学 枚举 数论


package leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i=2; i*i <= n; i++) {
                if (isPrime[i]) {
                    // 之所以从i*i开始，因为假设i=5，那么2*5会被2过滤掉，3*5会被3过滤掉，以此类推
                    // j+=i 表示从j=i*i开始，将i的倍数标记为false
                    for (int j=i*i; j < n; j+=i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i=2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}