class Solution {
    public boolean areAlmostEqual(String s1, String s2) {

        int misMatch = 0, fMismatch = 0, sMismatch = 0;
        
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
            {
                if(misMatch == 2) return false;
                if(misMatch == 0){
                    fMismatch = i;
                    misMatch++;
                }
                else if(misMatch == 1){
                    sMismatch = i;
                    misMatch++;
                }
            }
        }

        if(misMatch == 0) return true;
        if(misMatch == 1) return false;
        if(s1.charAt(fMismatch) == s2.charAt(sMismatch) && s1.charAt(sMismatch) == s2.charAt(fMismatch))
            return true;
        return false;
    }
}


class Other_Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        var idx = -1;   // index of first mismatch
        
        for(var i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) continue;
            if(idx == -2) return false; // 1 swap was already done
            if(idx == -1) idx = i;      // first mismatch
            else if(s1.charAt(idx) != s2.charAt(i) || s1.charAt(i) != s2.charAt(idx)) return false;  // swapping won't help
            else idx = -2;
        }
        return idx < 0;
    }
}