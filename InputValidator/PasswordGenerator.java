package InputValidator;

import java.lang.Math;
import java.util.Arrays;

public class PasswordGenerator {
	
	/*
	 * Password must meet below 4 criteria:
	 * 1. Password must contain 8 characters
	 * 2. Password can only include characters and digits
	 * 3. Has at least 1 Uppercase letter
	 * 4. Has at least 2 digits
	 */
	public String passwordGenerator() {
	
		String[] randPassword = new String[8];
		int alphabetNum = 26;
		int digitCount = 0;
		int lowercaseCount = 0;
		int uppercaseCount = 0;
		
		
		do {
			for (int i = 0; i < randPassword.length; i++ ) {
				// assign each element with different random password component
				randPassword[i] = Integer.toString((int)(Math.random() * 3));
				
				if (randPassword[i].equals("1")) {
					digitCount += 1;
				} else if (randPassword[i].equals("2")) {
					lowercaseCount += 1;
				} else {
					uppercaseCount += 1;
				}
			}
		} while (digitCount < 2 && uppercaseCount < 1);  // back to the random generator loop if conditions are not matched
		
		
		for (int j = 1; j < randPassword.length; j++) {
			
			// do the random generation first before assigning values to each element in password array
			
			// random digit
			String digit = Integer.toString((int)(Math.random() * 10));
			
			// random lowercase letter
			int lowercaseStart = 97;	// follow ASCII values
			int randLowercase = (int)(Math.random() * alphabetNum) + lowercaseStart;
			String lowercaseLetter = Character.toString((char)randLowercase); 
			
			// random uppercase letter
			int uppercaseStart = 65;	// follow ASCII values
			int randUppercase = (int)(Math.random() * alphabetNum) + uppercaseStart;
			String uppercaseLetter = Character.toString((char)randUppercase);
			
			// assign corresponding value into random password array
			if (randPassword[j].equals("1")) {
				randPassword[j] = digit;
			} else if (randPassword[j].equals("2")) {
				randPassword[j] = lowercaseLetter;
			} else {
				randPassword[j] = uppercaseLetter;
			}
		}
			
		
		// concatenate elements to form a generated password
		String passwordGen = String.join("", randPassword);
		
		return passwordGen;
		
	}
}
