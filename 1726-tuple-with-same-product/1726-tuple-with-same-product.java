class Solution {
    public int tupleSameProduct(int[] nums) {

//The idea is to calculate the product of possible pairs and keep the number of pairs resulting into the product in map.
        Map<Integer, Integer> multiMap = new HashMap<>();
        for(int i = 0 ; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                int value = nums[i]*nums[j];
                multiMap.put(value, multiMap.getOrDefault(value, 0)+1);
            }
        }

// Once we have the prduct we need to check for how many of them we have more than 1 pair, and then check how to arrange those 2 or more pairs using basics combinations. In each tuple we can have 2 pairs only. Let's say to acheive 12 we have 3 pairs [(1,12),(2,6),(3,4)]. Now to achieve a tuple of a*b referred as I, c*d referred as J, we can select of 3 only 1 for I position and for J position we can select only 1 out of the left over 2 items. So to acheive a*b and c*d we can select 3C1 * 2C1. Now each pair itself can be arranged in 2 options a*b or b*a. Similarly c*d and d*c. So the total way of achieving it is (2 * 3C1) * (2 * 2C1) ==> 3C1 * 2C1 * 4.   nCr = n!/(r! * (n-r)!). Using this for 3C1 * 2C1 * 4 ==> 3*2* 4

        int result = 0;
        for(var n : multiMap.values()){
            if(n > 1){
                result += n*(n-1)*4;
            }
        }
        return result;
    }
}