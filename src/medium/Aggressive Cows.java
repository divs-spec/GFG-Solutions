class Solution {
    
    public boolean cancows(int[] stalls, int k, int d){
        int count = 1;
        int lp = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lp >= d){
                count++;
                lp = stalls[i];
            }
            if(count >= k) return true;
        }
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int m = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        int l = 1;
        while(l <= m){
            int mid = l + (m - l)/2;
            if(cancows(stalls,k,mid)){
                ans = mid;
                l = mid + 1;
            }
            else{
                m = mid - 1;
            }
        }
        return ans;
    }
}
