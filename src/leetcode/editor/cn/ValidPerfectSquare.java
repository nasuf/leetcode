//<p>Given a <strong>positive</strong> integer <i>num</i>, write a function which returns True if <i>num</i> is a perfect square else False.</p>
//
//<p><b>Follow up:</b> <b>Do not</b> use any built-in library function such as <code>sqrt</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> num = 16
//<strong>Output:</strong> true
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> num = 14
//<strong>Output:</strong> false
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= num &lt;= 2^31 - 1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 362</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int low = 0, high = num;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                long square = (long) mid * mid;
                if (square == num) {
                    return true;
                } else if (square > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}