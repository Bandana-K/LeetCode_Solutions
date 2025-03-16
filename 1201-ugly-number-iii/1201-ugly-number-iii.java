class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE, result = 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canGetNUglyNumbers(n, a, b, c, mid)){
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    boolean canGetNUglyNumbers(int n, int a, int b, int c, int mid){
        long count = 0;
        count = count + mid/a + mid/b + mid/c - mid/lcm(a,b) - mid/lcm(a,c) - mid/lcm(b,c) + mid/lcm(a, lcm(b,c));
        return count >= n;
    }

    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}