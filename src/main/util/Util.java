package main.util;

public class Util {
	private Util(){
		
	}
	
	public static boolean ehNulaOuVazia(final String str){
		return ("".equals(str.trim()) || str == null);
	}
}
