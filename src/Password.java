import java.lang.String;

public class Password {
	
	public static final int WEAK = 3;
	public static final int INVALID = 4;
	public static final int MEDIUM = 2;
	public static final int STRONG = 1;
	
	
	public String string;
	
	public Password(String string) {
		this.string=string;
	}
	public String getText(){return string;}

	public boolean longEnough(int i) {
		
		
		return ((this.getText().length())>=i); 
		
	}

	public boolean containsOneOf(String string) {
		
		
				for(int i=0;i<this.getText().length();i++){
					for(int j=0;j<string.length();j++){
						if(this.getText().charAt(i)==string.charAt(j)){
							return true;
						}
					}
				}
			return false;
			
				
		
	}

	public boolean containsNoneOf(String string) {
		
		return !this.containsOneOf(string); 
	}

	public boolean containsUpperCase() {
		
		return(!(this.getText().toLowerCase().equals(this.getText())));
	}

	public boolean containsLowerCase() {
		
		return (!this.getText().toUpperCase().equals(this.getText())); 
	}

	public int safetyLevel() {
		
		if(this.longEnough(10)&&this.containsNoneOf("./")&&this.containsLowerCase()&&this.containsUpperCase()&&this.containsOneOf("!@#$%^&*()")&&this.containsOneOf("1234567890")){
			return STRONG;
		}
		else if(this.longEnough(8)&&this.containsNoneOf("./")&&this.containsLowerCase()&&this.containsUpperCase()&&this.containsOneOf("1234567890")){
			return MEDIUM;
		}
		else if(this.longEnough(8)&&this.containsNoneOf("./")&&this.containsLowerCase()||this.containsUpperCase()&&this.containsOneOf("1234567890")){
			return WEAK;
		}
		return INVALID;
	}

}
