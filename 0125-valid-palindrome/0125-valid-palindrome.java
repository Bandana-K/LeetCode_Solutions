class Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;
        var upperCaseString = s.toUpperCase();

        for(int i = 0, j = s.length()-1; i <= j; ) {
            var leftChar = upperCaseString.charAt(i);
            var rightChar = upperCaseString.charAt(j);

            if(leftChar == rightChar){
                i++;
                j--;
            } else if(!isValidAlphaNumeric(leftChar)){
                i++;
            } else if(!isValidAlphaNumeric(rightChar)){
                j--;
            } else {
                return false;
            }
        }
        return result;
    }

    boolean isValidAlphaNumeric(char check){
        return ((check >= '0' && check <= '9') || (check >= 'A' && check <= 'Z'));
    }
}

// Accepted
class Other_Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;
        var upperCaseString = s.toUpperCase();

        for(int i = 0, j = s.length()-1; i <= j; ) {
            var leftChar = upperCaseString.charAt(i);
            var rightChar = upperCaseString.charAt(j);

            if(leftChar == rightChar){
                i++;
                j--;
            } else if(!Character.isLetterOrDigit(leftChar)){
                i++;
            } else if(!Character.isLetterOrDigit(rightChar)){
                j--;
            } else {
                return false;
            }
        }
        return result;
    }

    boolean isValidAlphaNumeric(char check){
        return ((check >= '0' && check <= '9') || (check >= 'A' && check <= 'Z'));
    }
}