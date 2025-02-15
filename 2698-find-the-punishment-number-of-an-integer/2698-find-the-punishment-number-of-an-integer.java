class Solution {
    public int punishmentNumber(int n) {
        if(n == 1)
            return 1;
        return checkPunishment(n) + punishmentNumber(n-1);
    }

    private int checkPunishment(int n){
        int sqNum = n*n;
        if(sumOfDigitMatchesNum(sqNum, n))
            return sqNum;
        return 0;    
    }

    private boolean sumOfDigitMatchesNum(int sqNum, int target){
        if(sqNum == target) return true;
        if(sqNum < target) return false;

        String checkSum = String.valueOf(sqNum);
        for(int i = 1; i< checkSum.length(); i++){
            int num1 = Integer.parseInt(checkSum.substring(0, i));
            int num2 = Integer.parseInt(checkSum.substring(i, checkSum.length()));
            if(sumOfDigitMatchesNum(num2, target-num1)) return true;
        }
        return false;
    }
}