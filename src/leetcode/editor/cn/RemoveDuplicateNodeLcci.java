/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * <p>
 * 示例2:
 * <p>
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 173 👎 0
 */
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
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
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return head;
            }
            Set<Integer> occurred = new HashSet<Integer>();
            occurred.add(head.val);
            ListNode pos = head;
            // 枚举前驱节点
            while (pos.next != null) {
                // 当前待删除节点
                ListNode cur = pos.next;
                if (occurred.add(cur.val)) {
                    pos = pos.next;
                } else {
                    pos.next = pos.next.next;
                }
            }
            pos.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}