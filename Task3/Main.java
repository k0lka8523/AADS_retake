package Task3;

import java.util.Random;

public class Main {
    public static void main(String[] aArgs) {
        Random random = new Random();
        int numberOfElements = 1000;
        int[] array = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = random.nextInt();
        }

        SortingAlgorithms sortAlg = new SortingAlgorithms();

        sortAlg.treeSort(array);
        sortAlg.bucketSort(array);

        String output;
        if (sortAlg.getTreeSortIterations() < sortAlg.getBucketSortIterations())
            output = "Tree sort has less iterations";
        else if (sortAlg.getTreeSortIterations() > sortAlg.getBucketSortIterations())
            output = "Bucket sort has less iterations";
        else
            output = "Tree sort and Bucket sort have the same number of iterations";

        System.out.println(output);
    }
}
