// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//find the shortest time period (in days) for a vacation to visit all places 
//in a schedule A

class Shorten {
    public int shorten(int[] A) {
    	int maxval = 0;
    	
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] > maxval) {
    			maxval = A[i];
    		}
    	}
    	
    	int[] picked = new int[maxval+1];
    	int numbPlaces = 0;
    	for (int k = 0; k < A.length; k++) {
    		if (picked[A[k]] == 0) {
    			picked[A[k]] = 1;
    			numbPlaces++;
    		}
    	}
        
    	int[] places = new int[maxval+1];
    	int[] visited = new int[maxval+1];
    	int acc = 0;
    	int iter = 0;
    	
    	while (acc < numbPlaces) {
    		if (visited[A[iter]] == 0) {
    			visited[A[iter]] = 1;
    			acc++;
    		}
    		places[A[iter]] = iter;
    		iter++;
    	}
    	
    	maxval = 0;
    	int minval = A.length;
    	
    	for (int j = 0; j < places.length; j++) {
    		if (places[j] > maxval) {
    			maxval = places[j];
    		}
    		if ((places[j] < minval)&&(visited[j] == 1)) {
    			minval = places[j];
    		}
    	}
    	
        return (maxval - minval + 1);
        // write your code in Java SE 8
    }
}
