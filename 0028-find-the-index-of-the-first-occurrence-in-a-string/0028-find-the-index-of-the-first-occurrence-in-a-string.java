class Solution {
    public int strStr(String haystack, String needle) {
        var haystackCharArray = haystack.toCharArray();
        var needleCharArray = needle.toCharArray();
        for(int i = 0; i < (haystack.length() - needle.length())+1; i++){
            boolean perfectMatch = true;
            int k = i;
            for(int j = 0; j < needle.length(); j++, k++){
                if(haystackCharArray[k] != needleCharArray[j]) {
                    perfectMatch = false;
                    break;
                }
            }
            if(perfectMatch == true)
                return i;
        }
        return -1;
    }
}