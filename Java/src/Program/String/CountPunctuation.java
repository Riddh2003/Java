package Program.String;

import java.util.*;
public class CountPunctuation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0;
		System.out.println("Enter the String : ");
		String str = sc.next();
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)=='\'' || str.charAt(i)==';' || str.charAt(i)=='!' ||  str.charAt(i)=='\"' || str.charAt(i)==':' || str.charAt(i)=='-' || str.charAt(i)=='?' || str.charAt(i)=='.') {
				count++;
			}
		}
		//Display
		System.out.println("Total Punctuation Character is : "+count);
	}
}