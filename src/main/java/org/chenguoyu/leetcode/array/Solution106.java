package org.chenguoyu.leetcode.array;

import org.chenguoyu.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class Solution106 {
    HashMap<Integer, Integer> idxMap = new HashMap<>();
    /*
        中序遍历 inorder = [9,3,15,20,7]
        后序遍历 postorder = [9,15,7,20,3]
            3
           / \
          9  20
            /  \
           15   7
    * */
    private int postIdx;
    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;
        return helper(0, postorder.length);
    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        postIdx--;
        Integer index = idxMap.get(rootVal);
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index);
        return root;
    }


    @Test
    public void main() {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode.toString());
    }
}
