class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1;
        int sum = 1;
        for(int i = 1; i < n; i++){
            sum = sum + 4*i;
        }
        return sum;
    }
}