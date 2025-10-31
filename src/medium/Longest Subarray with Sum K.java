import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0, maxLen = 0;
        prefixSumMap.put(0, -1); // base case for sum from start

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // if prefixSum - k seen before, we found a subarray with sum k
            if (prefixSumMap.containsKey(prefixSum - k)) {
                int startIdx = prefixSumMap.get(prefixSum - k);
                maxLen = Math.max(maxLen, i - startIdx);
            }

            // store first occurrence of prefixSum
            prefixSumMap.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}
