// class Solution {
//     public boolean areAlmostEqual(String s1, String s2) {

//         Map<Character, Integer> charFreq = new HashMap<>();
        
//         for(int i = 0; i < s1.length(); i++){
//             if(s1.charAt(i) != s2.charAt(i))
//             {
//                 if(charFreq.size() == 2) return false;
//                 charFreq.put(s1.charAt(i), i);
//             }
//         }

//         if(charFreq.size() == 0) return true;
//         if(charFreq.size() == 1) return false;

//         var entries = charFreq.entrySet();
//         if(s2.charAt(entries.get(0).value()) == entries.get(1).key()
//             && s2.charAt(entries.get(1).value()) == entries.get(0).key())
//         return true;

//         return false;
//     }

class Solution {
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