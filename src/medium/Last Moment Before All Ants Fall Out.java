class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int maxTime = 0;

        // Left-moving ants fall off in 'pos' seconds
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // Right-moving ants fall off in 'n - pos' seconds
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}
