import java.util.Scanner;

public class StringPalindrome {
	private static String input = "Input: ";
	private static String longestPal = "Longest Palindrome: ";
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		sc.close();
		String longestPalindrome = getLongestPalindrome(inputString);
		System.out.println(input+inputString);
		System.out.println(null != longestPalindrome ? longestPal+longestPalindrome : longestPal+"None");
	}//end of the method main()
	

	/**
	 * Method to obtain the longest palindrome
	 * @param s - String word to get the largest palindrome
	 * @return - returns the longest palindrome
	 */
	public static String getLongestPalindrome(String s) {
		if (s == null) return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			
			//odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			if(checkPalindromeLength(palindrome, longest)){
				longest = palindrome;
			}
			
			//even cases like 1221
			palindrome = intermediatePalindrome(s, i, i + 1);
			if(checkPalindromeLength(palindrome, longest)){
				longest = palindrome;
			}
		}//end of loop
		return longest;
	}//end of method longestPalindromeString() 
	
	/**
	 * Method to find the intermediate palindrome
	 * @param s - palindrome word to iterate through
	 * @param left - left position of the word
	 * @param right - right position of the word
	 * @return - returns palindrome
	 */
	public static String intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}//end of method intermediatePalindrome()
	
	
	/**
	 * Substring comparison method
	 * @param pal - palindrome to compare the length with the substring
	 * @param lon - longest substring to compare the palindrome with 
	 * @return - boolean after the length comparison of palindrome against the substring
	 */
	public static boolean checkPalindromeLength(String pal, String lon){
		return (pal.length() > lon.length()) ? true : false;
	}//end of method checkPalindromeLength()
	
}//end of class
