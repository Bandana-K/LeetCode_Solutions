class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(var i=1; i<nums.length; i++)
            if((nums[i] & 1) == (nums[i-1] & 1)) //If nums[i] has same parity as of nums[i-1] return false
                return false;
        return true;
    }
}