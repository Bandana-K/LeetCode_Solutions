class Solution {
    public int climbStairs(int n) {
        int sum1 = 1, sum2 = 2;
        if(n == 1)
            return sum1;
        else if(n == 2)
            return sum2;
        else{
            for(int i = 3; i <= n; i++){
                int sum = sum2+sum1;
                sum1 = sum2;
                sum2 = sum;
            }
        }        
        return sum2;
    }
}

// n = 1, 1 (1)
// n = 2, 2 [(1,1), (2)]
// n = 3, 3 [(1,1,1), (1,2), (2,1)]
// n = 4, 5 [(1,1,1,1), (2,2), (1,1,2), (2,1,1), (1,2,1)]
// n = 5, 8 [(1,1,1,1,1), (1,1,1,2), (1,1,2,1), (1,2,1,1), (2,1,1,1), (2,2,1), (2,1,2), (1,2,2)]