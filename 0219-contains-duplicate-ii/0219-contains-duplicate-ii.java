class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(idxMap.containsKey(nums[i]) && (i - idxMap.get(nums[i])) <= k)
                return true;
            idxMap.put(nums[i], i);
        }
        return false;
    }
}