class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueCheck = new HashSet<>();
        for(int i : nums){
            if(uniqueCheck.contains(i))
                return true;
            else
                uniqueCheck.add(i);    
        }
        return false;
    }
}

// Other approach is to sort the element in O(nlogn)
// and check next number with current if they are same return true.