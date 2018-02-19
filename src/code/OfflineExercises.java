package code;
import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original,
	// there are two chars.

	// doubleChar("The") → "TThhee"
	// doubleChar("AAbb") → "AAAAbbbb"
	// doubleChar("Hi-There") → "HHii--TThheerree"

	public String doubleChar(String input) {
		String output = "";
		for (int i=0; i<input.length(); i++) {
			output = output.concat(Character.toString(input.charAt(i)));
			output = output.concat(Character.toString(input.charAt(i)));
		}
		return output;
	}
	//
	// A sandwich is two pieces of bread with something in between. Return the
	// string that is between the first and last appearance of "bread" in the
	// given string, or return the empty string "" if there are not two pieces
	// of bread.

	// getSandwich("breadjambread") → "jam"
	// getSandwich("xxbreadjambreadyy") → "jam"
	// getSandwich("xxbreadyy") → ""
	
	// indexOf("bread") = first instance
	// lastIndexOf("bread")

	public String getSandwich(String input) {
		String[] firstBreadSplitString = input.split("bread", 2);
		if (firstBreadSplitString[1].contains("bread")) {
			String[] splitString = input.split("bread");
			return splitString[1];
		}
		return "";
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int small=0;
		int medium=0;
		int large=0;
		int[] inputArray = {a, b, c};
		small = Integer.MAX_VALUE;
		for (int element : inputArray) {
			if (element < small)
				small = element;
		}
		large = Integer.MIN_VALUE;
		for (int element : inputArray) {
			if (element > large)
				large = element;
		}
		medium = 0;
		for (int element : inputArray) {
			if (element > small && element < large)
				medium = element;
		}
		return (medium - small == small && large - small == medium);
	}

	// Given a string and an int n, return a string made of the first and last n
	// chars from the string. The string length will be at least n.

	// nTwice("Hello", 2) → "Helo"
	// nTwice("Chocolate", 3) → "Choate"
	// nTwice("Chocolate", 1) → "Ce"

	public String nTwice(String input, int a) {
		String first = input.substring(0, a);
		String second = input.substring(input.length()-a, input.length());
		return first.concat(second);
	}

	// Given a string, return true if it ends in "ly".

	// endsLy("oddly") → true
	// endsLy("y") → false
	// endsLy("oddy") → false

	public boolean endsly(String input) {
		if (input.length() < 2)
			return false;
		String end = input.substring(input.length()-2, input.length());
		return "ly".equals(end);	
	}

	// Given a string, return recursively a "cleaned" string where adjacent
	// chars that are the same have been reduced to a single char. So "yyzzza"
	// yields "yza".

	// stringClean("yyzzza") → "yza"
	// stringClean("abbbcdd") → "abcd"
	// stringClean("Hello") → "Helo"
	public String stringClean(String input) {
		ArrayList<Character> charArray = new ArrayList<Character>();
		for (int i=0; i<input.length(); i++) {
			if (!charArray.contains(input.charAt(i)))
				charArray.add(input.charAt(i));
		}

		String output = "";
		for (Character element : charArray) {
			output = output.concat(element.toString());
		}
		return output;
	}

	// The fibonacci sequence is a famous bit of mathematics, and it happens to
	// have a recursive definition. The first two values in the sequence are 0
	// and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	// previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	// 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	// fibonacci number, with n=0 representing the start of the sequence.

	// fibonacci(0) → 0
	// fibonacci(1) → 1
	// fibonacci(2) → 1

	public int fibonacci(int input) {
		int last=0;
		int current=1;
		int temp=0;
		int count=0;
		while (count < input) {
			temp = last + current;
			last = current;
			current = temp;
			count++;
		}
		return last;
	}

	// We have a number of bunnies and each bunny has two big floppy ears. We
	// want to compute the total number of ears across all the bunnies
	// recursively (without loops or multiplication).
	//
	// bunnyEars(0) → 0
	// bunnyEars(1) → 2
	// bunnyEars(2) → 4

	public int bunnyEars(int input) {
		if (input == 0)
			return 0;
		return 2 + bunnyEars(input - 1);
	}

	// Hollow diamond exercise

	public boolean hollowDiamond(int width) {
		for (int i=0; i<width; i++)
			hollowDiamondLineOut(width-i, i);

		for (int i=0; i<width; i++)
			hollowDiamondLineIn(i, width-i);
		return true;
	}

	public void hollowDiamondLineOut(int beginningWidth, int middleWidth) {
		for (int i=0; i<beginningWidth; i++) {
			System.out.print(" ");
		}
		System.out.print("/");
		for (int i=0; i<middleWidth*2; i++) {
			System.out.print(" ");
		}
		System.out.println("\\");
	}

	public void hollowDiamondLineIn (int beginningWidth, int middleWidth) {
		for (int i=0; i<beginningWidth+1; i++) {
			System.out.print(" ");
		}
		System.out.print("\\");
		for (int i=0; i<middleWidth*2-2; i++) {
			System.out.print(" ");
		}
		System.out.println("/");
	}
}
