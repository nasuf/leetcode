//<p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>
//
//<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>
//
//<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
//<strong>Output:</strong> [3,4]
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
//<strong>Output:</strong> [-1,-1]
//</pre><p><strong>Example 3:</strong></p>
//<pre><strong>Input:</strong> nums = [], target = 0
//<strong>Output:</strong> [-1,-1]
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
//	<li><code>nums</code> is a non-decreasing array.</li>
//	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1592</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{1}, 1).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int left = -1, right = -1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target) {
                    for (int i = mid; i >= 0; i--) {
                        if (nums[i] == target) {
                            left = i;
                            continue;
                        } else {
                            left = i + 1;
                            break;
                        }
                    }
                    for (int i = mid; i < nums.length; i++) {
                        if (nums[i] == target) {
                            right = i;
                            continue;
                        } else {
                            right = i - 1;
                            break;
                        }
                    }
                    break;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return new int[]{left, right};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}