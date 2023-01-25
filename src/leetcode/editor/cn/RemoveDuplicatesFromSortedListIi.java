/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * <p>
 * Related Topics 链表 双指针 👍 1049 👎 0
 */
package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        solution.deleteDuplicates(ListNode.build(new int[]{1, 2, 3, 3, 4, 4, 5}));
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode prev = new ListNode();
            prev.next = head;
            ListNode p = prev;
            while(p.next != null && p.next.next != null) {
                if (p.next.val == p.next.next.val) {
                    int x = p.next.val;
                    while (p.next != null && p.next.val == x) {
                        p.next = p.next.next;
                    }
                } else {
                    p = p.next;
                }
            }
            return prev.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}