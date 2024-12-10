class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0)
        return 0;

        int j = 0;

        for(int i =0; i < nums.length; i++){
            if( j == 0 || nums[i] != nums[j-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}