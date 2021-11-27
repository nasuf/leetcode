//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 
// 👍 91 👎 0


package leetcode.editor.cn;

import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;

public class BinodeLcci {
    public static void main(String[] args) {
        Solution solution = new BinodeLcci().new Solution();
        /**
         *           7
         *        3    10
         *       2 4  8 11
         *      1   5
         */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(11);
        solution.convertBiNode(root);
        System.out.println(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        TreeNode min;

        public TreeNode convertBiNode(TreeNode root) {
            if (root == null) return null;
            convertBiNode(root.right);
            root.right = min;
            min = root;
            convertBiNode(root.left);
            root.left = null;
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}