// finds the largest sibling number of N

class LargestSibling {
    public int LargestSibling(int N) {
        int a = N;
        int b;
        int[] digits = new int[10];
        
        while (a > 0){
            b = a % 10;
            a = a / 10;
            digits[b]++;
        }
        String goop = "";
        for (int x = 9; x >= 0; x--) {
        	for (int y = 0; y < digits[x] ; y++) {
        		goop = goop + x;
       		}
        }
        
        return Integer.parseInt(goop);
        // write your code in Java SE 8
    }
}
