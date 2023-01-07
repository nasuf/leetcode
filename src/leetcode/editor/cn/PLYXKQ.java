/**
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = []
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：matrix = ["0"]
 * 输出：0
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：matrix = ["1"]
 * 输出：1
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：matrix = ["00"]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-rectangle/
 * <p>
 * <p>
 * Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 69 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
        System.out.println(solution.maximalRectangle(new String[]{"10100","10111","11111","10111"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix.length == 0) return 0;
            int[][] height = new int[matrix.length][matrix[0].length()];
            for (int i = 0; i < matrix.length; i++) {
                String line = matrix[i];
                for (int j = 0; j < line.length(); j++) {
                    if (i == 0) {
                        height[i][j] = matrix[i].charAt(j) == '1' ? 1 : 0;
                    } else {
                        height[i][j] = matrix[i].charAt(j) == '1' ? (height[i - 1][j] + 1) : 0;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < height[i].length; j++) {
                    Stack<Integer> stack = new Stack<>();
                    for (int k = j; k < height[i].length; k++) {
                        if ((!stack.isEmpty() && stack.peek() > height[i][k])) {
                            // calculate square now
                            max = Math.max(Collections.min(stack) * stack.size(), max);
                        }
                        if (height[i][k] != 0) {
                            stack.add(height[i][k]);
                        } else if (height[i][k] == 0 && !stack.isEmpty()) {
                            // calculate square now
                            max = Math.max(Collections.min(stack) * stack.size(), max);
                            stack.clear();
                        }
                        if (k == height[i].length - 1 && !stack.isEmpty()) {
                            // calculate square now
                            max = Math.max(Collections.min(stack) * stack.size(), max);
                            stack.clear();
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}