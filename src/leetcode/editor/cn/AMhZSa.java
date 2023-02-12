/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2]
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表 L 的长度范围为 [1, 10⁵]
 * 0 <= node.val <= 9
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 93 👎 0
 */
package leetcode.editor.cn;

import java.util.Stack;

public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            ListNode h = head;
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.push(head);
                head = head.next;
            }
            int count = stack.size() / 2 + 1;
            for (int i = 0; i < count; i++) {
                if (stack.pop().val == h.val) {
                    h = h.next;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}