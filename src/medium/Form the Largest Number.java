class Solution {
    public String findLargest(int[] arr) {
        // code here
         if (arr.length == 0) {
            return "0";
        }

        // Convert int array to String array
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = String.valueOf(arr[i]);
        }

        // Sort the String array using a custom comparator
        Arrays.sort(arr1, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (arr1[0].equals("0")) {
            return "0";
        }

        // Build the largest number using a StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            sb.append(arr1[i]);
        }

        return sb.toString();
    }
}
