//<p>Given an array <code>arr</code>&nbsp;of positive integers&nbsp;sorted in a <strong>strictly increasing order</strong>, and an integer <code><font face="monospace">k</font></code>.</p>
//
//<p><em>Find the </em><font face="monospace"><code>k<sup>th</sup></code></font><em>&nbsp;positive integer that is missing from this array.</em></p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> arr = [2,3,4,7,11], k = 5
//<strong>Output:</strong> 9
//<strong>Explanation: </strong>The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5<sup>th</sup>&nbsp;missing positive integer is 9.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> arr = [1,2,3,4], k = 2
//<strong>Output:</strong> 6
//<strong>Explanation: </strong>The missing positive integers are [5,6,7,...]. The 2<sup>nd</sup> missing positive integer is 6.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
//	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
//	<li><code>1 &lt;= k &lt;= 1000</code></li>
//	<li><code>arr[i] &lt; arr[j]</code> for <code>1 &lt;= i &lt; j &lt;= arr.length</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 86</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        Solution solution = new KthMissingPositiveNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            if (arr[0] > k) {
                return k;
            }

            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) >> 1;
                int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
                if (x - mid - 1 >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}