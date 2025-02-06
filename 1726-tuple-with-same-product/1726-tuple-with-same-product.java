class Solution {
    public int tupleSameProduct(int[] nums) {

        Map<Integer, Integer> multiMap = new HashMap<>();
        for(int i = 0 ; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                int value = nums[i]*nums[j];
                multiMap.put(value, multiMap.getOrDefault(value, 0)+1);
            }
        }

        int result = 0;
        for(var n : multiMap.values()){
            if(n > 1){
                result += n*(n-1)*4;
            }
        }
        return result;
    }
}