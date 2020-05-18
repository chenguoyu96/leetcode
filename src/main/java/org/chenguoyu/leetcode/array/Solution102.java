package org.chenguoyu.leetcode.array;

import com.alibaba.fastjson.JSONObject;
import org.chenguoyu.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution102 {
    /*
        二叉树：[3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：
        [
          [3],
          [9,20],
          [15,7]
        ]
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
            List<TreeNode> treeNodes = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                curr = queue.poll();
                res.add(curr.val);
                if (curr.left != null) {
                    treeNodes.add(curr.left);
                }
                if (curr.right != null) {
                    treeNodes.add(curr.right);
                }
            }
            result.add(res);
            for (TreeNode treeNode : treeNodes) {
                queue.add(treeNode);
            }
        }
        return result;
    }

    @Test
    public void main() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(JSONObject.toJSON(lists));
    }
}
