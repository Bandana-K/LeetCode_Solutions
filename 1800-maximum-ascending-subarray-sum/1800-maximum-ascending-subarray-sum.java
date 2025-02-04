class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if( nums[i] > nums[i-1]){
                sum += nums[i];
            } else {
                result = Math.max(sum, result);
                sum = nums[i];
            }
        }
        return Math.max(sum, result);
    }
}