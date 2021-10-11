//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            queue.offer(root);
            levelOrder(queue, result);
            return result;
        }

        public void levelOrder(Queue<TreeNode> queue, List<List<Integer>> result) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
            }
            result.add(list);
            if (!nextQueue.isEmpty()) {
                queue = nextQueue;
                levelOrder(queue, result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}