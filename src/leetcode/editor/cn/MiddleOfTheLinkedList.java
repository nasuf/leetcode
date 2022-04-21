/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
 * NULL.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 * <p>
 * Related Topics 链表 双指针 👍 548 👎 0
 */
package leetcode.editor.cn;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode first = head;
            ListNode second = head;
            while (second.next != null) {
                first = first.next;
                second = second.next;
                if (second == null) {
                    return first.next;
                } else if (second.next != null) {
                    second = second.next;
                } else {
                    // coming to last
                    return first;
                }
            }
            return first;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/
