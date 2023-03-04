package InputValidator;

import java.util.Scanner;

public class CreateEmail {

	public static void main(String[] args) {
		
		String email;
		boolean checkemail = false; 
		
		String decision;
		boolean checkDecision = false;
		
		String password;
		boolean passwordLengthCheck = false;
		boolean passwordIntCheck = false;
		boolean passwordUppercaseCharCheck = false;
		boolean passwordContentCheck = false;
		
		String pwReenter;
		boolean pwReenterCheck = false;
		
		Scanner keyboard = new Scanner(System.in);
		Validation validation = new Validation();
		PasswordGenerator passwordGenerator = new PasswordGenerator();

		
		while (checkemail == false) {
			System.out.println("Create an email account (example: example@example.com): ");
			email = keyboard.nextLine();
			validation.setEmail(email);
			
			validation.checkEmail();
			checkemail = validation.isCheckEmail();
		};

		System.out.println("------------------------");
		
		System.out.println("Create a password for your email:");
	
		System.out.println("Do you need a random password?  (Y/N)");
		
		while (checkDecision == false) {
			decision = keyboard.nextLine();
			validation.setDecision(decision);
			
			validation.checkDecision();
			checkDecision = validation.isCheckDecision();
			
			if (decision.equals("Y")) {
				password = passwordGenerator.passwordGenerator();
				System.out.println(password);
				validation.setPassword(password);
			} else if (decision.equals("N")) {
				System.out.println("Create your own password");
				
				while (passwordLengthCheck == false || passwordContentCheck == false || passwordIntCheck == false || passwordUppercaseCharCheck == false) {	

					System.out.println("1. Password must contain 8 characters");
					System.out.println("2. Password can only include characters and digits");
					System.out.println("3. Has at least 1 Uppercase letter");
					System.out.println("4. Has at least 2 digits");
					
					password = keyboard.nextLine();
					validation.setPassword(password);

					validation.checkPasswordLength();
					passwordLengthCheck = validation.isPasswordLengthCheck();
				
					validation.checkPasswordContent();
					passwordContentCheck = validation.isPasswordContentCheck();
				
					validation.checkPasswordUpperCase();
					passwordUppercaseCharCheck = validation.isPasswordUppercaseCharCheck();
					
					validation.checkPasswordInt();
					passwordIntCheck = validation.isPasswordIntCheck();
				}
				
			} else {
				System.out.println("Please input (Y/N)");
			}
			
		}
		
		System.out.println("------------------------");
		
		while (pwReenterCheck == false) {
			System.out.println("Please re-enter your password:");
			pwReenter = keyboard.nextLine();
			
			if (pwReenter.equals(validation.getPassword())) {
				System.out.println("Password is correctly re-entered");
				pwReenterCheck = true;
			} 
		}

		System.out.println("");
		System.out.println("------------------------");
		System.out.println("*** Program ends ***");
	}
}
