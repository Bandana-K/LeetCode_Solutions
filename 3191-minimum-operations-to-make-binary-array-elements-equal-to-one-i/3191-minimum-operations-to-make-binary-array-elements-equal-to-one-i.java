class Solution {
    public int minOperations(int[] nums) {
        
        int result = 0, n = nums.length;
        
        for(int i = 0; i<n-2; i++ ){

            if(nums[i] == 1) continue;

            result++;
            nums[i+1] = nums[i+1]^1;
            nums[i+2] = nums[i+2]^1;
        }

        if(nums[n-2] == 0 || nums[n-1] == 0) return -1;
        return result;
    }
}