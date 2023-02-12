package utils;


public class utility {

	public static void print(String...messaggio) {
		String messag="";
		for(String s: messaggio) {
			messag+= s+"\n";
		}
		
		System.out.printf("%s",messag);
	}
	
	public static void print(Exception exception) {
		utility.print("Exception"+exception.getMessage());
		exception.printStackTrace();
	}
	
	
}
