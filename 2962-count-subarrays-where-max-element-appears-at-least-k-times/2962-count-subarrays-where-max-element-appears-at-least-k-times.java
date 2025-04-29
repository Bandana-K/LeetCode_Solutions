class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long result = 0, maxCount = 0;

        for(int left = 0, right = 0; right <n; right++){
            if(nums[right] == max)
                maxCount++;

            while(maxCount == k ){
                if(nums[left] == max)
                    maxCount--;
                left++;
            }
            result += left;
        }

        return result;
    }
}