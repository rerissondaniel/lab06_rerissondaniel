package main.util;

public class Util {
	private Util(){
		
	}
	
	public static boolean ehNulaOuVazia(final String str){
		return (str == null || "".equals(str.trim()));
	}
}
