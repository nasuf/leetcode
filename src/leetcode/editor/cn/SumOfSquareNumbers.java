/**
 * <p>Given a non-negative integer <code>c</code>, decide whether there&#39;re two integers <code>a</code> and <code>b</code> such that <code>a<sup>2</sup> + b<sup>2</sup> = c</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> c = 5
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 1 * 1 + 2 * 2 = 5
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> c = 3
 * <strong>Output:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= c &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>双指针</li><li>二分查找</li></div></div><br><div><li>👍 343</li><li>👎 0</li></div>
 */
package leetcode.editor.cn;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b == (int) b) {
                    return true;
                }
            }
            return false;
        }*/

        public boolean judgeSquareSum(int c) {
            long a = 0, b = (long) Math.sqrt(c);
            while (a <= b) {
                long cal = a * a + b * b;
                if (cal == c) {
                    return true;
                } else if (cal < c) {
                    a++;
                } else {
                    b--;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}