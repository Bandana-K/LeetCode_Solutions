class Solution {
    public int minOperations(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();

        if(k>min) return -1;
        
        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if(k == min) return unique.size() - 1;
        return unique.size();
    }
}