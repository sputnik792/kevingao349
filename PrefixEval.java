import java.lang.Math;
import java.util.Stack;
import java.util.Scanner;

public class PrefixEval {

public static boolean isOperator(String s)
{
	// we will only be using the four basic functions, +,-,*, and /
	// we also include exponents ^
	char c = s.charAt(0);
	if(c == 43 || c == 45 || c == 42 || c == 47 || c == 94)
		return true;
	else
		return false;
}

public static boolean isNumber(String s) {
	if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
		return true;
	}
	else {
		return false;
	}
}

public static double evaluatePrefix(String s)
{
	Stack<Double> Stack = new Stack<Double>();

	int header;
	String tempstr;
	while (s.length() > 0) {
		if (s.contains(" ")) {
			header = s.lastIndexOf(" ");
			tempstr = s.substring(header+1, s.length());
		}
		else {
			tempstr = s.substring(0, s.length());
			header = 0;
		}
		// Push operand to Stack
		if (isNumber(tempstr)) { 
			Stack.push((double)(Integer.parseInt(tempstr)));
		}
		else if (isOperator(tempstr)){

			// Operator encountered
			// Pop two elements from Stack
			double o1 = Stack.peek();
			Stack.pop();
			double o2 = Stack.peek();
			Stack.pop();

			if (tempstr.charAt(0) == '+') {
				Stack.push(o1 + o2);
			}
			else if (tempstr.charAt(0) == '-') {
				Stack.push(o1 - o2);
			}
			else if (tempstr.charAt(0) == '*') {
				Stack.push(o1 * o2);
			}
			else if (tempstr.charAt(0) == '/') {
				Stack.push(o1 / o2);
			}
			else if (tempstr.charAt(0) == '^') {
				Stack.push(Math.pow(o1, o2));
			}
		}
		if (header > 0) {
			s = s.substring(0, header);
		}
		else {
			s = "";
		}
	}

	return Stack.peek();
}

/* Driver program to test above function */
public static void main(String[] args) {
	String s = "";
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter a prefix expression: ");
	s = scan.nextLine();
	System.out.println(evaluatePrefix(s));
	scan.close();
	}
}