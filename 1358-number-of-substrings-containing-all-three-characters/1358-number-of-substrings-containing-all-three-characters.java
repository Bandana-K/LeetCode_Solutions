class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0, j = 0; j<n ; j++){
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j),0)+1);
            
            if(freq.size() < 3) continue;

            while(freq.size() >= 3){
                result = result + n-j;
                int iCharFreq = freq.get(s.charAt(i));
                if(iCharFreq == 1)
                    freq.remove(s.charAt(i));
                else
                    freq.put(s.charAt(i), iCharFreq-1);
                i++; 
            }
        }
        return result;
    }
}