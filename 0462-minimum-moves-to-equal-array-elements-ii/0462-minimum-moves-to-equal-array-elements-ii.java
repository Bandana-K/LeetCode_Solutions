class Solution {
    public int minMoves2(int[] nums) {
        //Sort and then get the element at mid position
        //Then one by one for each element check if it can be converted to median element if yes count the operation
        
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n/2];

        int result = 0;
        for(int i = 0; i< n; i++)
            result += Math.abs(nums[i]-median);
        
        return result;
    }
}