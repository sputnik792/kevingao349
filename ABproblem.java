class ABproblem {
    public String ABproblem(int A, int B) {
        int max, min;
        String maxs, mins;
        String goop = "";
        if (A >= B){
            max = A; min = B;
            maxs = "a"; mins = "b";
        }
        else {
            max = B; min = A;
            maxs = "b"; mins = "a";
        }
        while ((max < 2*(min + 1)) && (min > 0)) {
        	goop = goop + maxs + mins;
        	max--;
        	min--;
        }
        while (min > 0) {
        	goop = goop + maxs + maxs + mins;
        	max--;
        	max--;
        	min--;
        }
        while (max > 0) {
        	goop = goop + maxs;
        	max--;
        }
        
        return goop;
        // write your code in Java SE 8
    }
}
