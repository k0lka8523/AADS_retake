package Task1;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 2, 2, 3, 4, 8, 56, 3, 7, 4};
        int[] y = new int[]{1, 2, 2, 4, 56, 7, 11, 14, 15};
        int[] z = ArrayIntersection.intersect(x, y);
        for (int element : z) System.out.print(element + " ");
        System.out.println();
    }
}
