/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 0 <= rowIndex <= 33
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 * Related Topics 数组 动态规划 👍 395 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> result = new ArrayList<>();
            for (int lineNum = 0; lineNum < rowIndex + 1; lineNum++) {
                List<Integer> line = new ArrayList<>();
                line.add(1);
                if (lineNum == 0)  {
                    result.add(line);
                    continue;
                }
                int count = lineNum - 1;
                if (count > 0) {
                    for (int j = 1; j <= count; j++) {
                        line.add(result.get(lineNum - 1).get(j - 1) + result.get(lineNum - 1).get(j));
                    }
                }
                line.add(1);
                result.add(line);
            }
            return result.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}