package BinarySearchTree;

public class ReplaceSumOfLarger {
    // Replace each node's value with sum of all larger nodes
    public void replaceWithSumOfLarger() {
        sum = 0;
        replaceWithSumOfLarger(root);
    }

    private int sum = 0;

    private void replaceWithSumOfLarger(Node node) {
        if (node == null) return;

        // Reverse Inorder (Right → Node → Left)
        replaceWithSumOfLarger(node.right);

        sum += node.data;
        node.data = sum;

        replaceWithSumOfLarger(node.left);
    }
}
