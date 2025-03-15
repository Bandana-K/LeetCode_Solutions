class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, result = 0;
        boolean found = false;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                found = true;
                result = mid;
                break;
            } else if(nums[mid] > target){
                right = mid-1;
            } else left = mid+1;
        }

        return found ? result : left;
    }
}