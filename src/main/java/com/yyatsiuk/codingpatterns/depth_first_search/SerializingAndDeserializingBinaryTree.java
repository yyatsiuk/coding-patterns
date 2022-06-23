package com.yyatsiuk.codingpatterns.depth_first_search;

import com.yyatsiuk.codingpatterns.common.TreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
 */
public class SerializingAndDeserializingBinaryTree {

    public String serialize(TreeNode root) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        serializeHelper(root, stringJoiner);
        return stringJoiner.toString();
    }

    private void serializeHelper(TreeNode root, StringJoiner stringJoiner) {
        if (root == null) {
            stringJoiner.add("x");
            return;
        }

        stringJoiner.add(String.valueOf(root.val));
        serializeHelper(root.left, stringJoiner);
        serializeHelper(root.right, stringJoiner);
    }

    public TreeNode deserialize(String deserializedTree) {
        Iterator<String> iterator = Arrays.stream(deserializedTree.strip().split(" ")).iterator();

        return deserializeHelper(iterator);
    }

    private TreeNode deserializeHelper(Iterator<String> iter) {
        String node = iter.next();
        if (Objects.equals(node, "x")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializeHelper(iter);
        root.right = deserializeHelper(iter);

        return root;
    }

    public static void main(String[] args) {
        SerializingAndDeserializingBinaryTree solution = new SerializingAndDeserializingBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(6);

        String serialize = solution.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = solution.deserialize(serialize);
        TreeNode.printLevelOrder(deserialize);
    }
}
