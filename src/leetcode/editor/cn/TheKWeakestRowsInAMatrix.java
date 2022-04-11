/**
 * <p>You are given an <code>m x n</code> binary matrix <code>mat</code> of <code>1</code>&#39;s (representing soldiers) and <code>0</code>&#39;s (representing civilians). The soldiers are positioned <strong>in front</strong> of the civilians. That is, all the <code>1</code>&#39;s will appear to the <strong>left</strong> of all the <code>0</code>&#39;s in each row.</p>
 *
 * <p>A row <code>i</code> is <strong>weaker</strong> than a row <code>j</code> if one of the following is true:</p>
 *
 * <ul>
 * <li>The number of soldiers in row <code>i</code> is less than the number of soldiers in row <code>j</code>.</li>
 * <li>Both rows have the same number of soldiers and <code>i &lt; j</code>.</li>
 * </ul>
 *
 * <p>Return <em>the indices of the </em><code>k</code><em> <strong>weakest</strong> rows in the matrix ordered from weakest to strongest</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * <strong>Output:</strong> [2,0,3]
 * <strong>Explanation:</strong>
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * <strong>Output:</strong> [0,2]
 * <strong>Explanation:</strong>
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == mat.length</code></li>
 * <li><code>n == mat[i].length</code></li>
 * <li><code>2 &lt;= n, m &lt;= 100</code></li>
 * <li><code>1 &lt;= k &lt;= m</code></li>
 * <li><code>matrix[i][j]</code> is either 0 or 1.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>矩阵</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 150</li><li>👎 0</li></div>
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            List<int[]> power = new ArrayList<int[]>();
            for (int i = 0; i < m; ++i) {
                int l = 0, r = n - 1, pos = -1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (mat[i][mid] == 0) {
                        r = mid - 1;
                    } else {
                        pos = mid;
                        l = mid + 1;
                    }
                }
                power.add(new int[]{pos + 1, i});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    if (pair1[0] != pair2[0]) {
                        return pair1[0] - pair2[0];
                    } else {
                        return pair1[1] - pair2[1];
                    }
                }
            });
            for (int[] pair : power) {
                pq.offer(pair);
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; ++i) {
                ans[i] = pq.poll()[1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}