/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= numRows <= 30
 * <p>
 * Related Topics 数组 动态规划 👍 754 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int lineNum = 0; lineNum < numRows; lineNum++) {
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
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}