package IHM;

public class InputControl {
	public InputControl() {
		
	}
	
	public Boolean VerifJeu(String s) {
		int a=Character.getNumericValue(s.charAt(0));
		if (a==1||a==2) {
			return true;
		}
		
		else return false;
	}
	
	public Boolean VerifMode(String s) {
		int a=Character.getNumericValue(s.charAt(0));
		if (a==1||a==2||a==3) {
			return true;
		}
		
		else return false;
	}
}
