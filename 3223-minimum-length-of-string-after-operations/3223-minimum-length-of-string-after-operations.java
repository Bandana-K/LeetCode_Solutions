class Solution {
    public int minimumLength(String s) {
        int[] charFreq = new int[26];
        for( char c : s.toCharArray()){
            charFreq[c - 'a']++;
        }

        int result = 0;
        for(int i = 0; i < 26; i++){
            if(charFreq[i] > 2){
                if( (charFreq[i] & 1) == 1)  // To check Odd number
                    result++;
                else     
                    result +=2;
            } else {
                result += charFreq[i];
            }
        }
        return result;
    }
}