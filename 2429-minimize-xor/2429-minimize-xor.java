// COPIED
class Solution {
    public int minimizeXor(int num1, int num2) {
        var num1set = Integer.bitCount(num1);
        var num2set = Integer.bitCount(num2);
        var mask = 1;
        // if bit count is more in num1, remove higher bits
        // (by setting lower bits to 0 because it will be used for xor)
        while(num1set > num2set){
            // when we find a 1 in num1 binary, set it to 0
            if((num1 & mask) == mask){
                num1 ^= mask;
                num1set--;
            }
            mask <<= 1;
        }
        // if bit count is less in num1, add lower bits
        while(num1set < num2set){
            // when we find a 0 in num1 binary, set it to 1
            if((num1 & mask) != mask){
                num1 |= mask;
                num1set++;
            }
            mask <<= 1;
        }
        
        // if bit count was already same
        // then no operation is needed
        return num1;
    }
}