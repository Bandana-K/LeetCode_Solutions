class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length, result = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(nums[i] > max) max = nums[i];
        }

        int left = 1, right = max;
        while(left <= right){

            int mid = (left+right)/2;
            if(isPossibleToRob(mid, nums, k)){
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return result;
    }

    boolean isPossibleToRob(int limit, int[] nums, int k){
        int housesRobbed = 0;
        for(int i =0; i<nums.length && housesRobbed <k; i++){
            if(nums[i] <= limit){
                housesRobbed++;
                i++;
            }
        }
        return housesRobbed >= k;
    }
}