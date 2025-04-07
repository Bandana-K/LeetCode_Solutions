//COPIED
public class Solution {
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
    }
}

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i = 0; i<nums.length; i++) sum += nums[i];
//         return canPartition(nums, 0, 0, sum);
//     }

//     private boolean canPartition(int[] nums, int idx, int currentSum, int totalSum){
//         if(idx > nums.length)
//             return false;
//         if((currentSum+nums[idx]) == (totalSum-nums[idx])
//             return true;

//         currentSum += nums[idx];
//         totalSum -= nums[idx]
//         var possible = canPartition(nums, idx+1, currentSum, totalSum);
//         if(possible) return true;
//         currentSum -= nums[idx];
//         totalSum += nums[idx]

//     }
// }


