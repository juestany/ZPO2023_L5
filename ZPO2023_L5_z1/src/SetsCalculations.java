import java.util.*;

public class SetsCalculations {
    public Set<Integer> setA;
    public Set<Integer> setB;

    public SetsCalculations(Set<Integer> setA, Set<Integer> setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public Set<Integer> sumSets(Set<Integer> a, Set<Integer> b) {
        Set<Integer> sum = new HashSet<Integer>(a);
        sum.addAll(b);
        return sum;
    }

    public Set<Integer> diffSets(Set<Integer> a, Set<Integer> b) {
        Set<Integer> diff = new HashSet<Integer>(a);
        diff.removeAll(b);
        return diff;
    }

    public Set<Integer> intersectionSets(Set<Integer> a, Set<Integer> b) {
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        return intersection;
    }

    public Set<Integer> symDiffSets(Set<Integer> a, Set<Integer> b) {
        Set<Integer> sum = diffSets(a, b);
        Set<Integer> intersection = intersectionSets(a, b);
        Set<Integer> symDiff = new HashSet<Integer>(sum);
        symDiff.removeAll(intersection);
        return symDiff;
    }

    public boolean isEqual(Set<Integer> a, Set<Integer> b) {
        return (a.containsAll(b) && a.size() == b.size() && a.equals(b));
    }
}
