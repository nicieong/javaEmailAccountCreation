package InputValidator;

import java.util.regex.*;

public class Validation {

	private String email;
	private boolean checkEmail = false;	
	private static final String EMAILREGEX = "^[A-Za-z0-9+_.-]+@(.)+[com+net]$";

	private String decision;
	private boolean checkDecision = false;
	
	private String password;
	private String[] pwCheck = new String[8];
	private static final int PASSWORDSIZE = 8;
	
	private boolean passwordContentCheck = false;
	private boolean passwordLengthCheck = false;
	private boolean passwordIntCheck = false;
	private boolean passwordUppercaseCharCheck = false;


	
	public Validation() {
		
	};
	
	public Validation(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	public boolean isCheckDecision() {
		return checkDecision;
	}

	public void setCheckDecision(boolean checkDecision) {
		this.checkDecision = checkDecision;
	}
	
	public boolean isCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(boolean checkEmail) {
		this.checkEmail = checkEmail;
	}

	public String getEmailregex() {
		return EMAILREGEX;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isPasswordContentCheck() {
		return passwordContentCheck;
	}

	public void setPasswordContentCheck(boolean passwordContentCheck) {
		this.passwordContentCheck = passwordContentCheck;
	}
	
	public boolean isPasswordLengthCheck() {
		return passwordLengthCheck;
	}

	public void setPasswordLengthCheck(boolean passwordLengthCheck) {
		this.passwordLengthCheck = passwordLengthCheck;
	}
	
	public boolean isPasswordIntCheck() {
		return passwordIntCheck;
	}

	public void setPasswordIntCheck(boolean passwordIntCheck) {
		this.passwordIntCheck = passwordIntCheck;
	}
	
	public boolean isPasswordUppercaseCharCheck() {
		return passwordUppercaseCharCheck;
	}

	public void setPasswordUppercaseCharCheck(boolean passwordUppercaseChar) {
		this.passwordUppercaseCharCheck = passwordUppercaseChar;
	}
	
	
	
	
	public void checkDecision() {
		if (this.decision.equals("Y")) {
			this.checkDecision = true;
		} else if (this.decision.equals("N")) {
			this.checkDecision = true;
		} else {
			this.checkDecision = false;
		}
	}
	
	
	public void checkEmail() {
		Pattern pattern = Pattern.compile(EMAILREGEX);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) { 
			this.checkEmail = true;
			System.out.println(email + " is valid email address");
		} else {
			this.checkEmail = false;
			System.out.println(email + " is invalid email address");
		}
	}
	
	
	public void checkPasswordLength() {
		if (password.length() == PASSWORDSIZE) {
			this.passwordLengthCheck = true;
		} else {
			this.passwordLengthCheck = false;
			System.out.println("Invalid password. Password must contain 8 characters");
		}
	}
	
	
	public void checkPasswordContent() {
		pwCheck = this.password.split("");
		
		int contentInvalid = 0;
		for (int i = 0; i < pwCheck.length; i++) {
			if (pwCheck[i].matches("[A-Za-z0-9]") != true) {
				contentInvalid ++;
			}	
		}
		
		if (contentInvalid == 0) {
			this.passwordContentCheck = true;
		} else {
			this.passwordContentCheck = false;
			System.out.println("Password can only include characters and digits");
		}
	}
	
	
	public void checkPasswordUpperCase() {
		pwCheck = this.password.split("");
	
	int upperCaseCount = 0;
		for (int i = 0; i< pwCheck.length; i++) {
			if (pwCheck[i].matches("[A-Z]") == true) {
				upperCaseCount ++;
			}
		}
		
		if (upperCaseCount > 0) {
			this.passwordUppercaseCharCheck = true;
		} else {
			this.passwordUppercaseCharCheck = false;
			System.out.println("Password does not have UpperCase letters");
		}
	}
	
	
	public void checkPasswordInt() {
		pwCheck = this.password.split("");
	
	int intCount = 0;
		for (int i = 0; i< pwCheck.length; i++) {
			if (pwCheck[i].matches("[0-9]") == true) {
				intCount ++;
			} 
		}
		
		if (intCount > 1) {
			this.passwordIntCheck = true;
		} else {
			this.passwordIntCheck = false;
			System.out.println("Password does not have enough digits");
		}
	}
	

	
}
