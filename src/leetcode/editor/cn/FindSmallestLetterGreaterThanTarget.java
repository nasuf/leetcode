//<p>Given a characters array <code>letters</code> that is sorted in <strong>non-decreasing</strong> order and a character <code>target</code>, return <em>the smallest character in the array that is larger than </em><code>target</code>.</p>
//
//<p><strong>Note</strong> that the letters wrap around.</p>
//
//<ul>
//	<li>For example, if <code>target == &#39;z&#39;</code> and <code>letters == [&#39;a&#39;, &#39;b&#39;]</code>, the answer is <code>&#39;a&#39;</code>.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> letters = [&quot;c&quot;,&quot;f&quot;,&quot;j&quot;], target = &quot;a&quot;
//<strong>Output:</strong> &quot;c&quot;
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> letters = [&quot;c&quot;,&quot;f&quot;,&quot;j&quot;], target = &quot;c&quot;
//<strong>Output:</strong> &quot;f&quot;
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> letters = [&quot;c&quot;,&quot;f&quot;,&quot;j&quot;], target = &quot;d&quot;
//<strong>Output:</strong> &quot;f&quot;
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>2 &lt;= letters.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>letters[i]</code> is a lowercase English letter.</li>
//	<li><code>letters</code> is sorted in <strong>non-decreasing</strong> order.</li>
//	<li><code>letters</code> contains at least two different characters.</li>
//	<li><code>target</code> is a lowercase English letter.</li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 208</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int length = letters.length;
            if (target >= letters[length - 1]) {
                return letters[0];
            }
            int low = 0, high = length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (letters[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return letters[low];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}