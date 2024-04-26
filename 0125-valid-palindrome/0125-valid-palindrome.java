public class Solution {
    public boolean isPalindrome(String s) {
        // Normalize the string
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Initialize two pointers
        int left = 0;
        int right = cleaned.length() - 1;

        // Check palindrome using two pointers
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // should return true
        System.out.println(sol.isPalindrome("race a car")); // should return false
        System.out.println(sol.isPalindrome(" ")); // should return true
    }
}
