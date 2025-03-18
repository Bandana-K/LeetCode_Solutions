class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1, n = nums.length;
        int i = 0, j = i+1, orred = nums[0];
        for(; j<n; j++){
            // System.out.println("i = " + i + " j = " + j + " orred = " +orred);
            if((orred & nums[j]) == 0){
                orred = orred|nums[j];
            } else {
                int currentLength = j-i;
                maxLength = Math.max(currentLength, maxLength);
                // System.out.println("(orred^nums[i]&nums[j]) = " + (orred^nums[i]&nums[j]));
                while(i < j){
                    orred = orred^nums[i];
                    i = i+1;
                    if((orred&nums[j]) == 0)
                        break;
                }
                orred = orred^nums[j];
            }
        }
        return Math.max(j-i, maxLength);
    }
}