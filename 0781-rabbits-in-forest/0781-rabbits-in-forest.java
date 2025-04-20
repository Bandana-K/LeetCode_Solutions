class Solution {
    public int numRabbits(int[] answers) {
        
        Arrays.sort(answers);
        int n = answers.length, currentSimilar = 0, maxSimilarAllowed = answers[0], result =  answers[0]+1;

        for(int i = 1; i<n; i++){
            // System.out.println("processing i = " + i + " val = " + answers[i] + " currentSimilar = " + currentSimilar + "  maxSimilarAllowed = " + maxSimilarAllowed + " result = " +result);
            if(answers[i] == 0){
                result++;
            } else {
                if(answers[i] == answers[i-1]){
                    currentSimilar++;
                    if(currentSimilar > maxSimilarAllowed){
                        currentSimilar = 0;
                        maxSimilarAllowed = answers[i];
                        result++;
                        result += answers[i];
                    }
                } else {
                    currentSimilar = 0;
                    maxSimilarAllowed = answers[i];
                    result++;
                    result += answers[i];
                }
            }
            // System.out.println("processing completed for i = " + i + " val = " + answers[i] + " currentSimilar = " + currentSimilar + "  maxSimilarAllowed = " + maxSimilarAllowed + " result = " +result);
        }

        return result;
    }
}