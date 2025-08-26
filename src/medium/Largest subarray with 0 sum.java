class Solution {
    int maxLength(int arr[]) {
        // code here
        /*int res = 0, flag, sum;
        for(int i = 0; i < arr.length; i++){
            flag = 0;
            sum = 0;
            for(int j = i; j < arr.length; j++){
                ++flag;
                sum += arr[j];
                if(sum == 0)
                    res = Math.max(res,flag);
            }
            
        }
        return res;*/
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                // subarray from 0..i
                maxLen = i + 1;
            }

            if (map.containsKey(prefixSum)) {
                // subarray between previous index and current
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // store first occurrence of this prefix sum
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
