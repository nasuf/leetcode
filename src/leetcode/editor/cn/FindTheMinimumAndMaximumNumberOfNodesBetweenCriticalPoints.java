/**
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * <p>
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个 局部极大值点 。
 * <p>
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个 局部极小值点 。
 * <p>
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * <p>
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界
 * 点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,1]
 * 输出：[-1,-1]
 * 解释：链表 [3,1] 中不存在临界点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,3,1,2,5,1,2]
 * 输出：[1,3]
 * 解释：存在三个临界点：
 * - [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
 * - [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
 * - [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
 * 第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
 * 第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,3,2,2,3,2,2,2,7]
 * 输出：[3,3]
 * 解释：存在两个临界点：
 * - [1,3,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
 * - [1,3,2,2,3,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
 * 最小和最大距离都存在于第二个节点和第五个节点之间。
 * 因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
 * 注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,3,3,2]
 * 输出：[-1,-1]
 * 解释：链表 [2,3,3,2] 中不存在临界点。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数量在范围 [2, 10⁵] 内
 * 1 <= Node.val <= 10⁵
 * <p>
 * <p>
 * Related Topics 链表 👍 16 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints().new Solution();
        System.out.println(Arrays.toString(solution.nodesBetweenCriticalPoints(ListNode.build(new int[]{3, 1}))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int index = 0;
            int prev_val = head.val;
            int trend = 0;
            List<Integer> list = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            while (head != null) {
                if (head.val > prev_val) {
                    if (trend != 1) {
                        if (trend == -1) {
                            list.add(index);
                            min = getMin(min, list);
                        }
                        trend = 1;
                    }
                } else if (head.val < prev_val) {
                    if (trend != -1) {
                        if (trend == 1) {
                            list.add(index);
                            min = getMin(min, list);
                        }
                        trend = -1;
                    }
                } else if (head.val == prev_val) {
                    trend = 0;
                }
                index++;
                prev_val = head.val;
                head = head.next;
            }
            if (list.size() < 2) {
                return new int[]{-1, -1};
            } else {
                return new int[]{min, list.get(list.size() - 1) - list.get(0)};
            }
        }

        public int getMin(int curMin, List<Integer> list) {
            if (list.size() > 1) {
                return Math.min(curMin, list.get(list.size() - 1) - list.get(list.size() - 2));
            } else {
                return curMin;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}