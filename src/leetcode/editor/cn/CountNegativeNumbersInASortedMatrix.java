//<p>Given a <code>m x n</code> matrix <code>grid</code> which is sorted in non-increasing order both row-wise and column-wise, return <em>the number of <strong>negative</strong> numbers in</em> <code>grid</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//<strong>Output:</strong> 8
//<strong>Explanation:</strong> There are 8 negatives number in the matrix.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> grid = [[3,2],[1,0]]
//<strong>Output:</strong> 0
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>m == grid.length</code></li>
//	<li><code>n == grid[i].length</code></li>
//	<li><code>1 &lt;= m, n &lt;= 100</code></li>
//	<li><code>-100 &lt;= grid[i][j] &lt;= 100</code></li>
//</ul>
//
//<p>&nbsp;</p>
//<strong>Follow up:</strong> Could you find an <code>O(n + m)</code> solution?<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>矩阵</li></div></div><br><div><li>👍 91</li><li>👎 0</li></div>
package leetcode.editor.cn;

public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
    }

    /**
     * 211111111111
     * 1-1-1-1-1-1-1
     * -1-1-1-1-1-1-1-1
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0, width = grid[0].length, pos = grid[0].length - 1;
            for (int i = 0; i < grid.length; i++) {
                int j;
                for (j = pos; j >= 0; j--) {
                    if (grid[i][j] >= 0) {
                        if (j + 1 < width) {
                            pos = j + 1;
                            count += width - pos;
                        }
                        break;
                    }
                }
                if (j == -1) {
                    count += width;
                    pos = -1;
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}