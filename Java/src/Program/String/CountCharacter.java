package Program.String;

import java.util.*;
public class CountCharacter {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int count = 0;
			System.out.println("Enter the String : ");
			String str = sc.nextLine();
			for(int i = 0;i<str.length();i++) {
				if(str.charAt(i)!=' ') {
					count++;
				}
			}
			System.out.println("Length of String : "+count);
		}
	}
}
