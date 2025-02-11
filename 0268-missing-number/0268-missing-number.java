class Solution {
    public int missingNumber(int[] nums) {
        int result = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            result = result ^ i ^ nums[i];
        }
        return result^n;
    }
}