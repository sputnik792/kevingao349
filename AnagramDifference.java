import java.util.ArrayList;
import java.util.List;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
    	int length = a.size();
    	String astr, bstr;
    	List<Integer> answer = new ArrayList<Integer>();
    	int[] letters1; //97 is the start
    	int[] letters2;
    	for (int x = 0; x < length; x++) {
    		astr = a.get(x);
    		bstr = b.get(x);
    		if (astr.length() != bstr.length()) {
    			answer.add((-1));
    		}
    		else {
    			letters1 = new int[26];
    			letters2 = new int[26];
    			int i = 0;
    			while (i < astr.length()) {
    				letters1[((int) astr.charAt(i)) - 97]++ ;
    				letters2[((int) bstr.charAt(i)) - 97]++ ;
    				i++;
    			}
    			int total = astr.length();
    			int min = 0;
    			for (int z = 0; z < 26; z++) {
    				if (letters1[z] > letters2[z]) {
    					min = letters2[z];
    				}
    				else { 
    					min = letters1[z];
    				}
    				total = total - min;
    			}
    			answer.add(total);
    		}
    	}
    	
		return answer;
    // Write your code here
        
    }

}
