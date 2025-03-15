class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(nums[i] > max) max = nums[i];
        }
    
        int low = 1, high = max, result = 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canDivide(mid, nums, threshold)){
                result = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    boolean canDivide(int mid, int[] nums, int threshold){
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            int quo = nums[i]/mid;
            if(nums[i]%mid != 0) quo++;
            sum += quo;
        }
        return sum <= threshold;
    }
}