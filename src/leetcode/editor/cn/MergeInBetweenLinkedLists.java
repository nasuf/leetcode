/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,10000
 * 03,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= list1.length <= 10⁴
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 10⁴
 * <p>
 * <p>
 * Related Topics 链表 👍 59 👎 0
 */
package leetcode.editor.cn;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        Solution solution = new MergeInBetweenLinkedLists().new Solution();
        solution.mergeInBetween(ListNode.build(new int[]{0, 1, 2}), 1, 1, ListNode.build(new int[]{1000, 1001, 1002}));
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
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode prev = new ListNode();
            prev.next = list1;
            ListNode p = prev;
            int index = -1;
            ListNode start = new ListNode();
            ListNode end = new ListNode(-1);
            while (p.next != null) {
                index++;
                if (index == a) {
                    start = p;
                } else if (index == b) {
                    end = p.next.next;
                    p.next = null;
                    break;
                }
                p = p.next;
            }
            if (end.val == -1)
                end = null == start.next.next ? null : start.next.next;
            start.next = list2;
            while (start.next != null) {
                start = start.next;
            }
            start.next = end;
            return prev.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}