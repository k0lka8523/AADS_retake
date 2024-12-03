package Task3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int numberOfElements = 1000;
        int[] array = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt();
        }

        SortingAlgorithms sortAlg = new SortingAlgorithms();

        int[] sortedArray1 = sortAlg.treeSort(array);
        int[] sortedArray2 = sortAlg.bucketSort(array);

        String output;
        if (sortAlg.getTreeSortIterations() < sortAlg.getBucketSortIterations())
            output = "Tree sort has less iterations";
        else if (sortAlg.getTreeSortIterations() > sortAlg.getBucketSortIterations())
            output = "Bucket sort has less iterations";
        else
            output = "Tree sort and Bucket sort have the same number of iterations";

        System.out.println(output);

        System.out.println("Tree sort   - " + sortAlg.getTreeSortIterations());
        System.out.println("Bucket sort - " + sortAlg.getBucketSortIterations());

        for (int i = 0; i < sortedArray1.length; i++) {
            if (sortedArray1[i] != sortedArray2[i]) {
                System.out.println("Arrays are not the same!!!");
                return;
            }
        }
        System.out.println("Arrays are the same)");
    }
}
