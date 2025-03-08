class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        char[] result = new char[digits.length];
        
        int i = digits.length-2;
        for(; i>=0; i--){
            if(digits[i] < digits[i+1]) break;
        }

        if(i<0) return -1;
        
        for(int j =0; j<i; j++){
            result[j] = digits[j];
        }

        char currMin = '9', fullMin = '9';
        int k = -1;
        for(int j = i+1; j<digits.length; j++){
            if(digits[j] > digits[i]){
                currMin = digits[j];
                if(currMin < fullMin || k == -1){
                    fullMin = currMin;
                    k = j;
                }
            }
        }


        result[i] = fullMin;
        digits[k] = digits[i];
        digits[i] = fullMin;

        char[] toSort = new char[digits.length-i-1];
        for(int l = 0; l < toSort.length; l++){
            toSort[l] = digits[i+l+1];
        }
        Arrays.sort(toSort);
        
        for(int l = 0; l < toSort.length; l++){
            result[i+l+1] = toSort[l];
        }

        String ans = String.valueOf(result);
        long ansLong = Long.parseLong(ans);
        if(ansLong > Integer.MAX_VALUE) return -1;
        return (int) ansLong;
    }
}