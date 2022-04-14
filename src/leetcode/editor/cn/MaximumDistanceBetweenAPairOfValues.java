/**
 * <p>You are given two <strong>non-increasing 0-indexed </strong>integer arrays <code>nums1</code>​​​​​​ and <code>nums2</code>​​​​​​.</p>
 *
 * <p>A pair of indices <code>(i, j)</code>, where <code>0 &lt;= i &lt; nums1.length</code> and <code>0 &lt;= j &lt; nums2.length</code>, is <strong>valid</strong> if both <code>i &lt;= j</code> and <code>nums1[i] &lt;= nums2[j]</code>. The <strong>distance</strong> of the pair is <code>j - i</code>​​​​.</p>
 *
 * <p>Return <em>the <strong>maximum distance</strong> of any <strong>valid</strong> pair </em><code>(i, j)</code><em>. If there are no valid pairs, return </em><code>0</code>.</p>
 *
 * <p>An array <code>arr</code> is <strong>non-increasing</strong> if <code>arr[i-1] &gt;= arr[i]</code> for every <code>1 &lt;= i &lt; arr.length</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
 * The maximum distance is 2 with pair (2,4).
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [2,2,2], nums2 = [10,10,1]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The valid pairs are (0,0), (0,1), and (1,1).
 * The maximum distance is 1 with pair (0,1).
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
 * The maximum distance is 2 with pair (2,4).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= nums1[i], nums2[j] &lt;= 10<sup>5</sup></code></li>
 * <li>Both <code>nums1</code> and <code>nums2</code> are <strong>non-increasing</strong>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li><li>二分查找</li></div></div><br><div><li>👍 26</li><li>👎 0</li></div>
 */
package leetcode.editor.cn;

public class MaximumDistanceBetweenAPairOfValues {
    public static void main(String[] args) {
        Solution solution = new MaximumDistanceBetweenAPairOfValues().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int l = 0, r = 0;
            while (l < nums1.length && r < nums2.length) {
                if (nums1[l] > nums2[r]) {
                    l++;
                }
                r++;
            }
            return Math.max(r - l - 1, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}