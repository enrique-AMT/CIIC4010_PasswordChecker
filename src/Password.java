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
		// TODO Auto-generated method stub
		
		return ((this.getText().length())>=i); //dummy return to avoid compiler error
		
	}

	public boolean containsOneOf(String string) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return !this.containsOneOf(string); //dummy return to avoid compiler error
	}

	public boolean containsUpperCase() {
		// TODO Auto-generated method stub
		return(!(this.getText().toLowerCase().equals(this.getText())));
	}

	public boolean containsLowerCase() {
		// TODO Auto-generated method stub
		return (!this.getText().toUpperCase().equals(this.getText())); //dummy return to avoid compiler error
	}

	public int safetyLevel() {
		// TODO Auto-generated method stub
		if(this.longEnough(10)&&this.containsNoneOf("./")&&this.containsLowerCase()&&this.containsUpperCase()&&this.containsOneOf("!@#$%^&*()")&&this.containsOneOf("1234567890")){
			return Password.STRONG;
		}
		else if(this.longEnough(8)&&this.containsNoneOf("./")&&this.containsLowerCase()&&this.containsUpperCase()&&this.containsOneOf("1234567890")){
			return Password.MEDIUM;
		}
		else if(this.longEnough(8)&&this.containsNoneOf("./")&&this.containsLowerCase()||this.containsUpperCase()&&this.containsOneOf("1234567890")){
			return Password.WEAK;
		}
		return Password.INVALID;
	}

}
