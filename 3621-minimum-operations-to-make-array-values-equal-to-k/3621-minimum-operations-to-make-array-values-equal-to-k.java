class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        for(int x : nums){
            if(x < k) return -1;
            else if(x > k) unique.add(x);
        }
        return unique.size();
    }
}