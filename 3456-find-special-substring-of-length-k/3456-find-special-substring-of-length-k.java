class Solution {
    public boolean hasSpecialSubstring(String s, int k) {

        int i = 1, j = 0;
        for(; i< s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))continue;
            else {
                var length = i-j;
                if(length == k) return true;
                j = i;
            }
        }
        var length = i-j;
        if(length == k) return true;
        return false;
        
    }
}