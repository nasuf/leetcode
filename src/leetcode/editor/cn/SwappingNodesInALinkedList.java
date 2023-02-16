/**
 * 给你链表的头节点 head 和一个整数 k 。
 * <p>
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 10⁵
 * 0 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 链表 双指针 👍 74 👎 0
 */
package leetcode.editor.cn;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        Solution solution = new SwappingNodesInALinkedList().new Solution();
        solution.swapNodes(ListNode.build(new int[] {1,2,3,4,5}), 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode h = head;
            ListNode second = head;
            int i = 0;
            ListNode first = null;
            while (head != null) {
                i++;
                if (i == k) {
                    first = head;
                }
                if (i > k) {
                    second = second.next;
                }
                head = head.next;
            }
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}