/**
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (
 * n-1-i) 个节点 。
 * <p>
 * <p>
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * <p>
 * <p>
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * <p>
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,4,2,1]
 * 输出：6
 * 解释：
 * 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
 * 链表中没有其他孪生节点。
 * 所以，链表的最大孪生和是 6 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [4,2,2,3]
 * 输出：7
 * 解释：
 * 链表中的孪生节点为：
 * - 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
 * - 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
 * 所以，最大孪生和为 max(7, 4) = 7 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,100000]
 * 输出：100001
 * 解释：
 * 链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的节点数目是 [2, 10⁵] 中的 偶数 。
 * 1 <= Node.val <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 链表 双指针 👍 24 👎 0
 */
package leetcode.editor.cn;

public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        Solution solution = new MaximumTwinSumOfALinkedList().new Solution();
        System.out.println(solution.pairSum(ListNode.build(new int[]{4, 2, 2, 3, 20, 7})));
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
        public int pairSum(ListNode head) {
            int count = 0;
            ListNode h = head;
            while (head != null) {
                count++;
                head = head.next;
            }
            head = h;
            int start = count / 2;
            int cnt = 0;
            ListNode newHead = null;

            while (head != null) {
                cnt++;
                if (cnt == start) {
                    newHead = reverseRest(head.next);
                    break;
                }
                head = head.next;
            }
            int max = Integer.MIN_VALUE;
            while (newHead != null) {
                max = Math.max(max, h.val + newHead.val);
                h = h.next;
                newHead = newHead.next;
            }
            return max;
        }

        public ListNode reverseRest(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}