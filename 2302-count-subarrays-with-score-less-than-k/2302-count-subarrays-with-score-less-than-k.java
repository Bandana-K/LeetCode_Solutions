class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long result = 0, sum = 0;
        for(int i = 0, j=0; j<n; j++){
            sum += nums[j];
            while(i<=j && (sum * (j-i+1)) >= k){
                sum -= nums[i];
                i++;
            }
            result += (j-i+1);
        }
        return result;
    }
}