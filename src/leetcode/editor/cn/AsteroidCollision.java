/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。数组中小行星的索引表示它们在空间中的相对位置。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会
 * 发生碰撞。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= asteroids.length <= 10⁴
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * <p>
 * Related Topics 栈 数组 模拟 👍 552 👎 0
 */
package leetcode.editor.cn;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int asteroid : asteroids) {
                if (asteroid > 0) {
                    stack.push(asteroid);
                } else {
                    boolean alive = true;
                    while (alive && !stack.isEmpty() && stack.peek() > 0) {
                        alive = stack.peek() < Math.abs(asteroid);
                        if (stack.peek() <= Math.abs(asteroid)) {
                            stack.pop();
                        }
                    }
                    if (alive) {
                        stack.push(asteroid);
                    }
                }
            }
            int size = stack.size();
            int[] res = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}