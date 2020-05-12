package org.chenguoyu.leetcode.array;

import org.chenguoyu.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class Solution105 {
    HashMap<Integer, Integer> idxMap = new HashMap<>();
    /*
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
            3
           / \
          9  20
            /  \
           15   7
    * */
    private int preIdx;
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int val : inorder) {
            idxMap.put(val, index++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }
        int rootValue = preorder[preIdx];
        TreeNode root = new TreeNode(rootValue);
        int index = idxMap.get(rootValue);
        preIdx++;
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;
    }


    @Test
    public void main() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode.toString());
    }
}
