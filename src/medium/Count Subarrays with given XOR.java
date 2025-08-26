class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum = sum ^ arr[i];
            if(sum == k)
            ++res;
            
            int target = sum ^ k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }

            // Store/update frequency of this prefix XOR
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        return res;
    }
}
