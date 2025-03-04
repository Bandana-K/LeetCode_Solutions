class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            var rem = n%3;
            if(rem != 1 && rem != 0) return false;
            n = n / 3;
        }
        return true;
    }
}