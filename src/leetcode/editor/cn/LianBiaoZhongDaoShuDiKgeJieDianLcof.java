/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * Related Topics 链表 双指针 👍 424 👎 0
 */
package leetcode.editor.cn;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
        public ListNode getKthFromEnd(ListNode head, int k) {
            int i = 1;
            ListNode first = head;
            ListNode second = head;
            while (head != null) {
                i++;
                head = head.next;
                if (i == k) {
                    second = head;
                    break;
                }
            }
            ListNode s = second;
            ListNode f = first;
            while (s.next != null) {
                s = s.next;
                f = f.next;
            }
            return f;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}