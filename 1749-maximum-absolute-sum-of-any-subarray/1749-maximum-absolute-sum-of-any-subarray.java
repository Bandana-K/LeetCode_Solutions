//Idea is to calculate maxPositiveSum and minNegativeSum for the entire array.
//The final array will be the max of (maxPositiveSum,  abs(minNegativeSum))
class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxPosSum = nums[0], currPosSum = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(currPosSum + nums[i] < nums[i])
                currPosSum = nums[i];
            else 
                currPosSum += nums[i];
            maxPosSum = Math.max(maxPosSum, currPosSum);
        }

        int minNegSum = nums[0], currNegSum = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(currNegSum + nums[i] > nums[i])
                currNegSum = nums[i];
            else 
                currNegSum += nums[i];
            minNegSum = Math.min(minNegSum, currNegSum);
        }

        // System.out.println("maxPosSum = " + maxPosSum + " minNegSum = " + minNegSum);
        return Math.max(maxPosSum, minNegSum*-1);

    }
}