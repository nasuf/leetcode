/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 367 👎 0
 */
package leetcode.editor.cn;

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] ret = new int[stack.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = stack.pop();
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}