//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 302 👎 0


package leetcode.editor.cn;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();
            queue.add(root);
            list.add((double)root.val);
            while(!queue.isEmpty()) {
                TreeNode head = queue.poll();
                if (head.left != null)
                    nextQueue.add(head.left);
                if (head.right != null)
                    nextQueue.add(head.right);
                if (queue.isEmpty() && !nextQueue.isEmpty()) {
                    list.add(getAverage(nextQueue));
                    queue = new LinkedList<>(nextQueue);
                    nextQueue.clear();
                }
            }
            return list;
        }

        public double getAverage(Queue<TreeNode> queue) {
            return queue.parallelStream().mapToDouble(x -> x.val).summaryStatistics().getAverage();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}