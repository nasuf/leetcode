//<p>Given a <strong>1-indexed</strong> array of integers <code>numbers</code> that is already <strong><em>sorted in non-decreasing order</em></strong>, find two numbers such that they add up to a specific <code>target</code> number. Let these two numbers be <code>numbers[index<sub>1</sub>]</code> and <code>numbers[index<sub>2</sub>]</code> where <code>1 &lt;= index<sub>1</sub> &lt; index<sub>2</sub> &lt;= numbers.length</code>.</p>
//
//<p>Return<em> the indices of the two numbers, </em><code>index<sub>1</sub></code><em> and </em><code>index<sub>2</sub></code><em>, <strong>added by one</strong> as an integer array </em><code>[index<sub>1</sub>, index<sub>2</sub>]</code><em> of length 2.</em></p>
//
//<p>The tests are generated such that there is <strong>exactly one solution</strong>. You <strong>may not</strong> use the same element twice.</p>
//
//<p>Your solution must use only constant extra space.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>2</u>,<u>7</u>,11,15], target = 9
//<strong>Output:</strong> [1,2]
//<strong>Explanation:</strong> The sum of 2 and 7 is 9. Therefore, index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>2</u>,3,<u>4</u>], target = 6
//<strong>Output:</strong> [1,3]
//<strong>Explanation:</strong> The sum of 2 and 4 is 6. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 3. We return [1, 3].
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>-1</u>,<u>0</u>], target = -1
//<strong>Output:</strong> [1,2]
//<strong>Explanation:</strong> The sum of -1 and 0 is -1. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>2 &lt;= numbers.length &lt;= 3 * 10<sup>4</sup></code></li>
//	<li><code>-1000 &lt;= numbers[i] &lt;= 1000</code></li>
//	<li><code>numbers</code> is sorted in <strong>non-decreasing order</strong>.</li>
//	<li><code>-1000 &lt;= target &lt;= 1000</code></li>
//	<li>The tests are generated such that there is <strong>exactly one solution</strong>.</li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>二分查找</li></div></div><br><div><li>👍 748</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        int[] result = solution.twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int rightIndex = binarySearch(numbers, i + 1, numbers.length - 1, numbers[i], target);
                if (rightIndex == -1) {
                    continue;
                } else {
                    result[0] = i + 1;
                    result[1] = rightIndex + 1;
                    break;
                }
            }
            return result;
        }

        public int binarySearch(int[] numbers, int low, int high, int first, int target) {
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int sum = first + numbers[mid];
                if (sum == target) {
                    return mid;
                } else if (sum > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}