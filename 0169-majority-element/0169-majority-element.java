class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); 
        int n = nums.length / 2; 
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0; 
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                ans = entry.getKey(); 
            }
        }
        return ans; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority element in nums1: " + solution.majorityElement(nums1));  
        System.out.println("Majority element in nums2: " + solution.majorityElement(nums2));  
    }
}