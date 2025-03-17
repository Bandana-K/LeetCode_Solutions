class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0)+1);
        }

        for(var val : numFreq.values()){
            if(val%2 == 1) return false;
        }

        return true;
    }
}