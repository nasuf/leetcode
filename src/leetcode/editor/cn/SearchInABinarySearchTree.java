//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 二叉搜索树 二叉树


package leetcode.editor.cn;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 递归算法
        /*public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val) return root;
            if (val > root.val)
                return searchBST(root.right, val);
            else
                return searchBST(root.left, val);
        }*/

        // 迭代算法
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = val > root.val ? root.right : root.left;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}