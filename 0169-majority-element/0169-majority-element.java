class Solution {
    public int majorityElement(int[] nums) {
        int countToMatch = (nums.length)/2 + (nums.length % 2);
        
        for(int i = 0 ; i < nums.length; i++){
            int count = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    count++;
            }
            if(count == countToMatch)
                return nums[i];
        }

        //Ideally as per the requirement it should never reach here.
        return 0;
    }
}