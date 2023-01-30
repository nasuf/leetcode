/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 128 👎 0
 */
package leetcode.editor.cn;

public class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        ListNode prev = new ListNode();

        public boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) {
                    return false;
                }
                if (prev.val != currentNode.val) {
                    return false;
                }
                prev = prev.next;
            }
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            prev = head;
            return recursivelyCheck(prev);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}