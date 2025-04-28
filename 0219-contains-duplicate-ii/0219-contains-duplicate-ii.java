class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(idxMap.containsKey(nums[i]) && (i - idxMap.get(nums[i])) <= k)
                return true;
            else
                idxMap.put(nums[i], i);
        }
        return false;
    }


    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     boolean result = false;
    //     int n = nums.length;
    //     for(int i = 0; i < (n-k); i++){
    //         for(int l = i+1; l <= (i+k); l++)
    //             if(nums[i] == nums[l]) return true;
    //     }
    //     return false;
    // }
}