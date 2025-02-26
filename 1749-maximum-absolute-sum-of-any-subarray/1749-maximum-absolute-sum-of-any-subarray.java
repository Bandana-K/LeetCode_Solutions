class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            int currSum = nums[i];
            result = Math.max(result, Math.abs(currSum));
            for(int j = i+1; j< nums.length; j++){
                currSum = currSum + nums[j];
                result = Math.max(result, Math.abs(currSum));

            }
        }
        return result;
    }
}