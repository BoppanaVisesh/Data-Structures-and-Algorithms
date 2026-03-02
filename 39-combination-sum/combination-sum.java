import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        f(candidates, 0, target, new ArrayList<>(), r);
        return r;
    }

    void f(int[] a, int i, int t, List<Integer> c, List<List<Integer>> r) {
        if (t == 0) {
            r.add(new ArrayList<>(c));
            return;
        }
        if (i == a.length) return;

        int x = a[i];
        int m = t / x;

        for (int k = 0; k <= m; k++) {
            for (int j = 0; j < k; j++) c.add(x);
            f(a, i + 1, t - k * x, c, r);
            for (int j = 0; j < k; j++) c.remove(c.size() - 1);
        }
    }
}