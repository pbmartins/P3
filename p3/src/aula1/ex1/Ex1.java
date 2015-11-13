package aula1.ex1;
import java.util.*;

public class Ex1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Insert a string:");
		String s = sc.nextLine();
		
		int num = 0;
		int upper = 0;
		int lower = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) num++;
			else if (Character.isLowerCase(c)) lower++;
			else if (Character.isUpperCase(c)) upper++;
		}
		
		System.out.println("Total of numeric characters: " + num);
		if (lower == 0 && upper > 0) System.out.println("The string only has upper case characters.");
		else if (lower > 0 && upper == 0) System.out.println("The string only has lower case characters.");
		System.out.printf("Total of words: %d\n", countWordsFinal(s));
		System.out.println("Inverted characters: " + changeLetters(s, 0));

	}
	
	public static int countWords(String s) {
		int num_words = 0;
		String[] words = s.split(" ");
		
		for (int idx = 0; idx < words.length; idx++) {
			if (words[idx].length() != 0) num_words++;
		}
		
		return num_words;
	}
	
	public static int countWordsFinal(String s) {
		String[] words = s.split("[,;_?! ]+");
		return words.length;
	}
	
	public static String changeLetters(String s, int idx) {
		if (idx == s.length() - 1) return s.charAt(idx) + "";
		else if (idx == s.length()) return "";
		else return s.charAt(idx + 1) + "" + s.charAt(idx) + "" + changeLetters(s, idx + 2);
	}

}
