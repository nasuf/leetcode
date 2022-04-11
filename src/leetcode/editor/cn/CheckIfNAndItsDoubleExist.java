/**
 * <p>Given an array <code>arr</code> of integers, check if there exists two integers <code>N</code> and <code>M</code> such that <code>N</code> is the double of <code>M</code> ( i.e. <code>N = 2 * M</code>).</p>
 *
 * <p>More formally check if there exists&nbsp;two indices <code>i</code> and <code>j</code> such that :</p>
 *
 * <ul>
 * <li><code>i != j</code></li>
 * <li><code>0 &lt;= i, j &lt; arr.length</code></li>
 * <li><code>arr[i] == 2 * arr[j]</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr = [10,2,5,3]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> N<code> = 10</code> is the double of M<code> = 5</code>,that is, <code>10 = 2 * 5</code>.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr = [7,1,14,11]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> N<code> = 14</code> is the double of M<code> = 7</code>,that is, <code>14 = 2 * 7</code>.
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> arr = [3,1,7,11]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> In this case does not exist N and M, such that N = 2 * M.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= arr.length &lt;= 500</code></li>
 * <li><code>-10^3 &lt;= arr[i] &lt;= 10^3</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>双指针</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 49</li><li>👎 0</li></div>
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new CheckIfNAndItsDoubleExist().new Solution();
        System.out.println(solution.checkIfExist(new int[]{3, 1, 7, 11}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))) {
                    return true;
                } else {
                    set.add(arr[i]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}