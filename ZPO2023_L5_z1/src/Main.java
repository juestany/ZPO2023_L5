import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] A = {22, 45, 33, 66, 55, 34, 77};
        Integer[] B = {33, 2, 83, 45, 3, 12, 55};

        Set<Integer> setA = new HashSet<Integer>(Arrays.asList(A));
        Set<Integer> setB = new HashSet<Integer>(Arrays.asList(B));

        SetsCalculations calculations = new SetsCalculations(setA, setB);

        System.out.println(setA);
        System.out.println(setB);
        System.out.println(calculations.isEqual(setA, setB));
        System.out.println(calculations.sumSets(setA, setB));
        System.out.println(calculations.diffSets(setA, setB));
        System.out.println(calculations.symDiffSets(setA, setB));
        System.out.println(calculations.intersectionSets(setA, setB));
    }
}