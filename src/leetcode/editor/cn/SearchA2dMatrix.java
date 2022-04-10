//<p>Write an efficient algorithm that searches for a value <code>target</code> in an <code>m x n</code> integer matrix <code>matrix</code>. This matrix has the following properties:</p>
//
//<ul>
//	<li>Integers in each row are sorted from left to right.</li>
//	<li>The first integer of each row is greater than the last integer of the previous row.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;" />
//<pre>
//<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//<strong>Output:</strong> true
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;" />
//<pre>
//<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//<strong>Output:</strong> false
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>m == matrix.length</code></li>
//	<li><code>n == matrix[i].length</code></li>
//	<li><code>1 &lt;= m, n &lt;= 100</code></li>
//	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>矩阵</li></div></div><br><div><li>👍 616</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{
                {1, 1}, {3, 3}
        }, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*public boolean searchMatrix(int[][] matrix, int target) {
            int width = matrix[0].length;
            int height = matrix.length;
            if (target < matrix[0][0] || target > matrix[height - 1][width - 1]) {
                return false;
            }
            if (width == 1) {
                int low = 0, high = height - 1;
                while (low <= high) {
                    int mid = (high - low) / 2 + low;
                    if (matrix[mid][0] == target) {
                        return true;
                    } else if (matrix[mid][0] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                return false;
            }


            int low = 0, high = height - 1;
            int heightIndex = -1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] < target && matrix[mid][width - 1] >= target) {
                    heightIndex = mid;
                    break;
                } else if (matrix[mid][0] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (heightIndex == -1) {
                return false;
            }

            int l = 0, h = width - 1;
            while (l <= h) {
                int mid = (h - l) / 2 + l;
                if (matrix[heightIndex][mid] == target) {
                    return true;
                } else if (matrix[heightIndex][mid] > target) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return false;
        }*/

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int x = matrix[mid / n][mid % n];
                if (x < target) {
                    low = mid + 1;
                } else if (x > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}