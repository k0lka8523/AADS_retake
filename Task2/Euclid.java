package Task2;

public class Euclid {
    public static int GCD(int a, int b) {
        if (a * b == 0) return a + b;
        if (a < b)      return GCD(b, a);
        return GCD(b, a % b);
    }
}
