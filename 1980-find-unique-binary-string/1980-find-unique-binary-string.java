class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> stringSet = new HashSet<>(Arrays.asList(nums));
        StringBuilder currentVal = new StringBuilder(); 
        var missing = findMissingNumber(stringSet, currentVal);
        if(missing) return currentVal.toString();
        return "";  //unreachable code 
    }

    Boolean findMissingNumber(Set<String> stringSet, StringBuilder currentVal){
        if(currentVal.length() == stringSet.size()){
            return !stringSet.contains(currentVal.toString());
        }

        for(char c = '0'; c <= '1'; c++){
            currentVal.append(c);
            var missing = findMissingNumber(stringSet, currentVal);
            if(missing) return true;
            currentVal.deleteCharAt(currentVal.length()-1);
        }

        return false;
    }
}