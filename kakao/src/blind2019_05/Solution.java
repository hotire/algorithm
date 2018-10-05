package blind2019_05;

import java.util.*;


class TreeNode implements Comparable<TreeNode> {
    public int x;
    public int y;
    public int depth;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
    @Override
    public int compareTo(TreeNode o) {
        return Integer.compare(this.y, o.y) == 0 ? Integer.compare(this.x, o.x) : -Integer.compare(this.y, o.y);
    }
}

class BinaryTree {
    private TreeNode root;
    public List<Integer> preTree = new ArrayList<>();
    public List<Integer> postTree = new ArrayList<>();

    private TreeNode add(TreeNode node, TreeNode val) {
        if (node == null) {
            return val;
        }
        if (val.x < node.x) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    public BinaryTree(List<TreeNode> nodes) {
        order = new int[2][nodes.size()];
        nodes.forEach(node -> root = add(root, node));
        preOrder(root);
        postOrder(root);
    }

    private void preOrder(TreeNode node) {
        if (node == null) return;
        preTree.add(node.depth);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postTree.add(node.depth);
    }

}

public class Solution {

    public int[][] solution(int[][] nodeinfo) {
        List<TreeNode> nodes = new ArrayList<>();
        int depth = 1;
        for (int[] node : nodeinfo) {
            nodes.add(new TreeNode(node[0], node[1], depth++));
        }
        Collections.sort(nodes);

        BinaryTree bt = new BinaryTree(nodes);
        int[][] ans = new int[2][nodeinfo.length];

        ans[0] = bt.preTree.stream().mapToInt(i->i).toArray();
        ans[1] = bt.postTree.stream().mapToInt(i->i).toArray();

        return ans;
    }
}
