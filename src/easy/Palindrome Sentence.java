class Solution {
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder clean = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }

        String cleanedStr = clean.toString();
        String reversedStr = clean.reverse().toString();

        return cleanedStr.equals(reversedStr);
    }
}
