class Solution {
    public int maximumSum(int[] nums) {
        int result = -1;
        Map<Long, Integer> digitSumToMaxNum = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            long digitSum = getDigitSum(nums[i]);
            if(digitSumToMaxNum.containsKey(digitSum)){
                int currMaxForSum = digitSumToMaxNum.get(digitSum);
                result = Math.max(result, nums[i]+currMaxForSum);
                digitSumToMaxNum.put(digitSum, Math.max(currMaxForSum, nums[i]));
            } else digitSumToMaxNum.put(digitSum, nums[i]);
            
        }
        return result;
    }

    long getDigitSum(int n){
        long digitSum = 0;
        while(n > 0){
            digitSum += n%10;
            n = n/10;
        }
        return digitSum;
    }
}