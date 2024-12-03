package Task3;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private long iterations;

    public Node root;

    private Node insertInPlace(Node aNode, int aValue) {
        iterations++;
        if (aNode == null)
        {
            aNode = new Node(aValue);
            return aNode;
        }
        if (aValue <= aNode.value)
            aNode.left = insertInPlace(aNode.left, aValue);
        else
            aNode.right = insertInPlace(aNode.right, aValue);
        return aNode;
    }

    private void inOrderTraversal(Node aNode, List<Integer> aList) {
        if (aNode != null) {
            iterations++;
            inOrderTraversal(aNode.left, aList);
            aList.add(aNode.value);
            inOrderTraversal(aNode.right, aList);
        }
    }

    public BinaryTree() {
        root = null;
        iterations = 0;
    }

    public void insert(int aValue) {
        root = insertInPlace(root, aValue);
    }

    public void insertArray(int[] aArray) {
        for (int element : aArray) insert(element);
    }

    public int[] sortArray(int[] aArray) {
        insertArray(aArray);
        int[] sortedArray = new int[aArray.length];
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        for (int i = 0; i < aArray.length; i++) sortedArray[i] = list.get(i);
        return sortedArray;
    }

    public long getIterations() { return iterations; }
}
