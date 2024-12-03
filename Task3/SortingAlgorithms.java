package Task3;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

    private long bucketSortIterations;
    private long treeSortIterations;

    private List<Integer> bucketSort(List<Integer> aList) {
        int n = aList.size();
        if (n < 2) return aList;
        bucketSortIterations++;
        int minElement = aList.getFirst();
        int maxElement = aList.getFirst();
        for (int element : aList) {
            minElement = Math.min(element, minElement);
            maxElement = Math.max(element, maxElement);
        }
        if (minElement == maxElement) return aList;
        int numberOfBuckets = (int)Math.sqrt(aList.size());
        if (numberOfBuckets == 1) numberOfBuckets = aList.size();
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) { buckets.add(new ArrayList<>()); }

        bucketSortIterations += n;
        for (int element : aList) {
            int bucketIndex = (int)(((long)element - minElement) * numberOfBuckets / ((long)maxElement - minElement + 1));
            bucketIndex = Math.min(numberOfBuckets - 1, bucketIndex);
            buckets.get(bucketIndex).add(element);
        }

        bucketSortIterations += numberOfBuckets;
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.set(i, bucketSort(buckets.get(i)));

        bucketSortIterations += numberOfBuckets;
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            sortedList.addAll(buckets.get(i));
        }
        return sortedList;
    }

    public int[] treeSort(int[] aArray) {
        BinaryTree binaryTree = new BinaryTree();
        int[] sortedArray = binaryTree.sortArray(aArray);
        treeSortIterations = binaryTree.getIterations();
        return sortedArray;
    }

    public int[] bucketSort(int[] aArray) {
        bucketSortIterations = 0;
        List<Integer> list = new ArrayList<>();
        for (int element : aArray) list.add(element);
        list = bucketSort(list);

        int[] sortedArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) { sortedArray[i] = list.get(i); }
        return sortedArray;
    }

    public long getTreeSortIterations()   { return treeSortIterations; }
    public long getBucketSortIterations() { return bucketSortIterations; }
}
