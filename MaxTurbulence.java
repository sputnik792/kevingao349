class MaxTurbulence {
    public int MaxTurbulence(int[] A) {
        // write your code in Java SE 8
    	if (A.length == 1) {
    		return 1;
    	}
    	else {
    		int max = 1;
    		int curr = 1;
    		int cond = 0; //condition for the next iteration: 0 = up, 1 = down
    		int d = 1;
    		while (d < A.length) {
    			if (cond == 0) {
    				if (A[d] > A[d - 1]) {
    					curr++;
    					cond = 1;
    					d++;
    				}
    				else {
    					if (curr > max) {
    						max = curr;
    					}
    					curr = 1;
    					if (A[d] < A[d - 1]) {
    						cond = 1;
    					}
    					else {
    						d++;
    					}
    				}
    			}
    			else {
    				if (A[d] < A[d - 1]) {
    					curr++;
    					cond = 0;
    					d++;
    				}
    				else {
    					if (curr > max) {
    						max = curr;
    					}
    					curr = 1;
    					if (A[d] > A[d - 1]) {
    						cond = 0;
    					}
    					else {
    						d++;
    					}
    				}
    			}
    		}
    		if (curr > max) {
    			max = curr;
    		}
    		return max;
    	}
    }
