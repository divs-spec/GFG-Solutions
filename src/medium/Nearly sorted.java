class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        int index = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);

            if (pq.size() > k) {
                arr[index++] = pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}
