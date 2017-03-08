import java.util.Scanner;
import java.util.ArrayList;

public class Main {
			
			public static ArrayList<String> sort_dec(ArrayList<String> waitlist){
				ArrayList<String> temp = new ArrayList<String>();
				int store;
				int j;
				int compval;
				boolean flag;
				for (int i = 0; i <  waitlist.size(); i = i+4){
					 store = Integer.parseInt(waitlist.get(i + 2)) - 
							 Integer.parseInt(waitlist.get(i + 3));
					 j = 0;
					 flag = false;
					 while ((flag == false)&&(j < temp.size())){
						 compval = Integer.parseInt(waitlist.get(j + 2)) - 
								 Integer.parseInt(waitlist.get(j + 3));
						 if (store > compval){
							 for (int k = 0; k < 4; k = k + 1){
								 temp.add(j+k, waitlist.get(i+k));
								 flag = true;
							 }
						 }
						 else {
							 j = j + 4;
						 }
					 }
					 // append to the end if the value is the smallest
					 if (j >= temp.size()){
						 for (int q = 0; q < 4; q = q + 1){
							 temp.add(waitlist.get(i+q));
						 }
					 }
				}
				return temp;
				
			}
		
			//assumes a sorted ArrayList of waitlisted people is passed into ret_unwelcome
			public static void ret_unwelcome(ArrayList<String> invarr, int total){
				int index = 0;
				int diff;
				boolean flag = true;
				while ((index < invarr.size())&&(flag == true)){
					diff = Integer.parseInt(invarr.get(index + 2)) -
							Integer.parseInt(invarr.get(index + 3));
					if ((total + diff) <= 0 ){
						flag = false;
					}
					else {
						index = index + 4;
						total = total + diff;
					}
				}
				if (index >= invarr.size()){
					System.out.println("Everyone is welcome!");
				}
				else {
					System.out.println("list of people that should not be welcomed: ");
					while (index < invarr.size()){
						System.out.println(invarr.get(index));
						index = index + 4;
					}
				}
			}

		    public static void notwelcome(ArrayList<String> invites, int length){
		    	ArrayList<String> welcome = new ArrayList<String>();
		    	ArrayList<String> temp = new ArrayList<String>();
		    	ArrayList<String> sorted = new ArrayList<String>();
	     		int sze;
		    	int higher;
	    		int lower;
	    		int total = 0;
	    		int next;
		    	for (int j = 0; j < length; j = j+1){
		    		lower = 0;
		    		String currline = invites.get(j);
		    		sze = currline.length();
		    		for (int k = 0; k < 3; k = k+1){
		    			lower = 0;
		    			higher = currline.indexOf(',');
		    			temp.add(currline.substring(lower, higher));
		    			currline = currline.substring(higher + 1, sze);
		    			sze = currline.length();		    		}
		    		temp.add(currline);
		    		next = Integer.parseInt(temp.get(temp.size() - 2)) - 
		    				Integer.parseInt(temp.get(temp.size() - 1));
		    		if (next >= 0){
		    			total = total + next; 
		    			for (int k = 4; k > 0; k = k-1){
		    				welcome.add(temp.get(temp.size()-k));
		    			}
		    			for (int i = 0; i < 4; i = i+1){
			    			temp.remove(temp.size()-1);
		    			}
		    		}		    	}
		    	sorted = sort_dec(temp);
		    	if (temp.size() == 0){
		    		System.out.println("Everyone is welcome!");
		    	}
		    	else {
		    		ret_unwelcome(sorted, total);
		    	}
		    }
		    
		    
		    public static void main(String args[]){
		        System.out.print("How many invites?: \n");
		        Scanner scan = new Scanner(System.in);
				int num = scan.nextInt();
				ArrayList<String> invarr = new ArrayList<String>(); 
				int i = 0;
				System.out.print("type invite in the specified form: \n");
				while (i < num){
		            Scanner sline = new Scanner(System.in);
					invarr.add(sline.next());
					i = i + 1;
				}
		    	notwelcome(invarr, invarr.size());
		    } 
			
		}

	/* Here are some assumptions that I made about the program:
	--the input strings will be entered in one at a time, and the program assumes that the 
	user will enter strings that are of the specified format (ex: Bob,Adam,1,3)
	--the program will only print out a list of names of the people that aren't welcome, assume 
	all names not mentioned are welcome
	--the program assumes that Adam wants to invite as many people as possible, but still wants to 
	have a positive amount of candy leftover for him to eat
	*/





