package Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
    public static int[] intersect(int[] aX, int[] aY) {
        Map<Integer, Integer> numberFreq = new HashMap<>();
        for (int element : aX)
            if (numberFreq.containsKey(element))
                numberFreq.put(element, numberFreq.get(element) + 1);
            else
                numberFreq.put(element, 1);
        List<Integer> zList = new ArrayList<>();
        for (int element : aY)
            if (numberFreq.containsKey(element) && numberFreq.get(element) != 0) {
                numberFreq.put(element, numberFreq.get(element) - 1);
                zList.add(element);
            }
        int[] z = new int[zList.size()];
        for (int i = 0; i < zList.size(); i++) z[i] = zList.get(i);
        return z;
    }
}
