class Solution {
    int getLPSLength(String s) {
        // code here
        int n = s.length();
    int[] lps = new int[n];
    int j = 0; // Length of previous longest prefix suffix

    for (int i = 1; i < n; i++) {
        while (j > 0 && s.charAt(i) != s.charAt(j)) {
            j = lps[j - 1];
        }
        if (s.charAt(i) == s.charAt(j)) {
            j++;
        }
        lps[i] = j;
    }

    return lps[n - 1];
    }
}
