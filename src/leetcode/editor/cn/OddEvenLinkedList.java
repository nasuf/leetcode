/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * <p>
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * <p>
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * n == 链表中的节点数
 * 0 <= n <= 10⁴
 * -10⁶ <= Node.val <= 10⁶
 * <p>
 * <p>
 * Related Topics 链表 👍 679 👎 0
 */
package leetcode.editor.cn;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        solution.oddEvenList(ListNode.build(new int[]{}));
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
        /*public ListNode oddEvenList(ListNode head) {
            int count = 0;
            ListNode a = null;
            ListNode b = null;
            ListNode a1 = null;
            ListNode b1 = null;
            while (head != null) {
                count++;
                if (count % 2 == 1) {
                    if (a == null) {
                        a1 = head;
                        a = head;
                    } else {
                        a.next = head;
                        a = a.next;
                    }
                } else {
                    if (b == null) {
                        b1 = head;
                        b = head;
                    } else {
                        b.next = head;
                        b = b.next;
                    }
                }
                head = head.next;
            }
            if (a != null && a.next != null)
                a.next = null;
            if (b != null && b.next != null)
                b.next = null;
            ListNode prev = new ListNode();
            ListNode p = prev;
            prev.next = a1;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = b1;
            return p.next;
        }*/

        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}