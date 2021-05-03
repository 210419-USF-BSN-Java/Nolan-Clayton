package com.revature;

public class Application {

	
	public static String printNumberInWord(int number) {
		
		String s;
		
		switch(number) {
		
		case 0:
			s = "ZERO";
			break;
		case 1:
			s = "ONE";
			break;
		case 2:
			s = "TWO";
			break;
		case 3:
			s = "THREE";
			break;
		case 4:
			s = "FOUR";
			break;
		case 5:
			s = "FIVE";
			break;
		case 6:
			s = "SIX";
			break;
		case 7:
			s = "SEVEN";
			break;
		case 8:
			s = "EIGHT";
			break;
		case 9:
			s = "NINE";
			break;
		default:
			s = "OTHER";
			break;
		
		}
		
		return s;
	}

	public static String reverse(String string) {
		
		char[] temp = string.toCharArray();
		char[] ans = new char[temp.length];
		
		int y = 0;
		
		for(int i = temp.length - 1; i >= 0; i--){
			
			ans[y] = temp[i];
			y++;
		}
		
		String finString = new String(ans);
		return finString;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Application.printNumberInWord(5));
		System.out.println(Application.reverse("Nolan Clayton"));

	}

}
