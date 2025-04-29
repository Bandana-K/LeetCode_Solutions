class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i =0, j=0; j<n; j++){
            sum += nums[j];
            if((j-i+1) > k){
                sum -= nums[i];
                i++;
            }
            if(j-i+1 == k)
                maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum/k;
    }
}