class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices); // Sort ascending for min cost calculation
        int n = prices.length;

        // Minimum cost calculation
        int minCost = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i];
            i++;        // buy cheapest
            j -= k;     // take k most expensive as freebies
        }

        // Maximum cost calculation
        int maxCost = 0;
        i = n - 1; // start from most expensive
        j = 0;
        while (i >= j) {
            maxCost += prices[i];
            i--;        // buy most expensive
            j += k;     // take k cheapest as freebies
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
