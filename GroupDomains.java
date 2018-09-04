import java.util.ArrayList;

class Solution {
    public int solution(String[] L) {
        // write your code in Java SE 8
    	HashMap<String, ArrayList<String>> maplist = new HashMap<String, ArrayList<String>>();
    	String local = "";
    	String domain = "";
    	String newStr = "";
    	for (int a = 0; a < L.length; a++) {
    		local = L[a].substring(0, L[a].indexOf('@'));
    		domain = L[a].substring(L[a].indexOf('@')+1, L[a].length());
    		if (local.contains("+")) {
    			newStr = local.substring(0, local.indexOf('+'));
    			newStr = newStr.replace(".", "")+domain; 
    		}
    		else {
    			newStr = local.replace(".", "")+domain; 
    		}
    												// strip the local name, 
    												//and rejoin the domain to create the key
    		if (!maplist.containsKey(newStr)) { //check if we have this already
    			ArrayList<String> addin = new ArrayList<String>();
    			addin.add(L[a]);
    			maplist.put(newStr, addin);
    		}
    		else {
    			ArrayList<String> addin2 = maplist.get(newStr);
    			addin2.add(L[a]);
    			maplist.replace(newStr, addin2);
    		}
    	}
    	
    	int total = 0;
    	for (String key: maplist.keySet()) {
    		if (maplist.get(key).size() > 1) {
    			total++;
    		}
    	}
    	
    	return total;
    }
    
}


