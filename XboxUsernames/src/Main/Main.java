package Main;

public class Main {

	public static void main(String[] args) {
	
	String charters = "0123456789abcdefghijklmnopqrstuvwxyz";
	String userName = "";
	char firstChar;
	char secondChar;
	char thridChar;
	char fourthChar;
	
	for (int i = 0; i < 36; ++i) {
		for (int j = 0; j < 36; ++j) {
			for (int k = 0; k < 36; ++k) {
				for (int l = 0; l < 36; ++l) {
					firstChar = charters.charAt(i);
					secondChar = charters.charAt(j);
					thridChar = charters.charAt(k);
					fourthChar = charters.charAt(l);
	if (firstChar == secondChar && secondChar == thridChar) {
		continue;
	}
	if (secondChar == thridChar && thridChar == fourthChar) {
		continue;
	}
	userName = String.valueOf(firstChar) + String.valueOf(secondChar) 
	+ String.valueOf(thridChar) + String.valueOf(fourthChar);
	System.out.println(userName);
	}
			}
		}
	}
}
}
