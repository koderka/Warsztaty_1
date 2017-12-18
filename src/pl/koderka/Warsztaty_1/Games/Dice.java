package pl.koderka.Warsztaty_1.Games;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj kod kostki");
		String diceCode = scan.nextLine();
		
		System.out.println("Wynik rzutu kostką to: " + diceThrow(diceCode));
	}
	
	public static int diceThrow(String diceCode) {
		StringTokenizer tok = new StringTokenizer(diceCode, "D+-");
		String[] tabTok = new String[tok.countTokens()];
		for(int i = 0; tok.hasMoreTokens(); i++) {
			tabTok[i] = tok.nextToken();
		}
//		System.out.println(Arrays.toString(tabTok));
		
		int[] dice = {1, 6, 0};
		
		if(diceCode.indexOf('+') > -1) {
			dice[2] = Integer.parseInt(tabTok[tabTok.length-1]);
			dice[1] = Integer.parseInt(tabTok[tabTok.length-2]);
			if(tabTok.length == 3) {
				dice[0] = Integer.parseInt(tabTok[0]);
			}
		}
		else if(diceCode.indexOf('-') > -1) {
			dice[2] = -Integer.parseInt(tabTok[tabTok.length-1]);
			dice[1] = Integer.parseInt(tabTok[tabTok.length-2]);
			if(tabTok.length == 3) {
				dice[0] = Integer.parseInt(tabTok[0]);
			}
		} else {
			dice[1] = Integer.parseInt(tabTok[tabTok.length-1]);
			if(tabTok.length == 2) {
				dice[0] = Integer.parseInt(tabTok[0]);
			}
		}
//		System.out.println(Arrays.toString(dice));
		
		int result = dice[2];
		for(int i = 0; i < dice[0]; i++) {
			Random rnd = new Random();
			int tempRnd = rnd.nextInt(dice[1]) + 1;
			result += tempRnd;
//		System.out.println(tempRnd);
		}
		return result;
	}

}
