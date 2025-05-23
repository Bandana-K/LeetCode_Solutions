//COPIED
class Solution {
    public long countBadPairs(int[] nums) {
        // count how many numbers differ from their index
        var numsCount = nums.length;
        var mismatch = new HashMap<Integer, Integer>();  // key = diff, val = count
        for(var i=0; i<numsCount; i++){
            var diff = nums[i] - i;
            mismatch.put(diff, 1 + mismatch.getOrDefault(diff, 0));
        }

        // a set of numbers with same diff will always make good pairs
        // so we can only pair them with any other no. in the world
        long count = 0;
        for(var freq : mismatch.values()){
            numsCount -= freq;
            count += freq * numsCount;
        }

        return count;
    }
}