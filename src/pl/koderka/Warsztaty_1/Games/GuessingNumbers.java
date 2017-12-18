package pl.koderka.Warsztaty_1.Games;

import java.util.Scanner;

public class GuessingNumbers {

	public static void main(String[] args) {
		
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach");
		
		int min = 0;
		int max = 1001;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			guess = (int)((max - min)/2) + min;
			System.out.println("Czy jest to liczba " + guess + "?");
			switch(scan.nextLine()) {
			case "mniej":
				max = guess;
				break;
			case "wiecej":
				min = guess;
				break;
			case "zgadles":
				System.out.println("Wygrałem!");
				return;
			default:
				System.out.println("Oszukujesz...");
				i--;
				break;
			}
		}

	}

}
