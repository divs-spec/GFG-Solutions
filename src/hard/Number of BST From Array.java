import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    // Function to precompute Catalan numbers
    private long[] computeCatalan(int n) {
        long[] cat = new long[n + 1];
        cat[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                cat[i] = (cat[i] + (cat[j] * cat[i - j - 1]) % MOD) % MOD;
            }
        }
        return cat;
    }

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Precompute Catalan numbers up to n
        long[] catalan = computeCatalan(n);

        // Step 2: Sort array to know relative ranks
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rank.put(sorted[i], i);
        }

        // Step 3: For each arr[i], calculate number of BSTs
        for (int i = 0; i < n; i++) {
            int pos = rank.get(arr[i]);
            int left = pos;           // smaller elements
            int right = n - pos - 1;  // greater elements
            long ways = (catalan[left] * catalan[right]) % MOD;
            result.add((int) ways);
        }

        return result;
    }
}
