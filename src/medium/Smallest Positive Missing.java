class Solution {
    public int missingNumber(int[] arr) {
        int missing = 1;
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<missing){
                continue;
            }
            if(arr[i]==missing){
                missing++;
            }
            else if(arr[i] > missing) {
                return missing;
            }
        }
        return missing;
    }
}
