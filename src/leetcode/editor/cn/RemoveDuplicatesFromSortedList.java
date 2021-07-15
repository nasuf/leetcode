//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表


package leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode node = new RemoveDuplicatesFromSortedList().new ListNode(1);
        node.next = new RemoveDuplicatesFromSortedList().new ListNode(2);
        node.next.next = new RemoveDuplicatesFromSortedList().new ListNode(2);
        node.next.next.next = new RemoveDuplicatesFromSortedList().new ListNode(3);
        node.next.next.next.next = new RemoveDuplicatesFromSortedList().new ListNode(4);
        ListNode node1 = solution.deleteDuplicates(node);
        System.out.println(node1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            while (head != null && head.next != null && head.val == head.next.val)
                head.next = head.next.next;
            if (head != null && head.next != null)
                deleteDuplicates(head.next);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}