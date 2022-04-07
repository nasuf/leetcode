//<p>You have <code>n</code> coins and you want to build a staircase with these coins. The staircase consists of <code>k</code> rows where the <code>i<sup>th</sup></code> row has exactly <code>i</code> coins. The last row of the staircase <strong>may be</strong> incomplete.</p>
//
//<p>Given the integer <code>n</code>, return <em>the number of <strong>complete rows</strong> of the staircase you will build</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/arrangecoins1-grid.jpg" style="width: 253px; height: 253px;" />
//<pre>
//<strong>Input:</strong> n = 5
//<strong>Output:</strong> 2
//<strong>Explanation:</strong> Because the 3<sup>rd</sup> row is incomplete, we return 2.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/04/09/arrangecoins2-grid.jpg" style="width: 333px; height: 333px;" />
//<pre>
//<strong>Input:</strong> n = 8
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> Because the 4<sup>th</sup> row is incomplete, we return 3.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>二分查找</li></div></div><br><div><li>👍 202</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            int total = 0;
            int lines = 1;
            while (total <= n && lines < (n - total)) {
                total += lines;
                lines++;
            }
            if (lines == (n - total)) {
                return lines;
            } else {
                return lines - 1;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}