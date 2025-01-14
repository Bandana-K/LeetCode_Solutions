class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        boolean[] aPresent = new boolean[A.length+1];
        boolean[] bPresent = new boolean[B.length+1];
        int[] result = new int[A.length];

	    aPresent[A[0]] = true;
	    bPresent[B[0]] = true;
	    result[0] = A[0] == B[0] ? 1 : 0;

        for(int i =1; i<A.length; i++){
            aPresent[A[i]] = true;
            bPresent[B[i]] = true;

            if(A[i] == B[i]){
                result[i] = result[i-1]+1;
            } else {
                int currentIndexMatch = 0;
                if(bPresent[A[i]] == true )
                    currentIndexMatch++; 
            
                if(aPresent[B[i]] == true )
                    currentIndexMatch++; 
            
                result[i] = result[i-1]+currentIndexMatch;
            }
        }

	    return result;
    }
}