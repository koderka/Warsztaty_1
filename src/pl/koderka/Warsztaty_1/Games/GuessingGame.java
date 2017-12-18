package pl.koderka.Warsztaty_1.Games;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		int secretNumber = random.nextInt(1000);
		int number;		
		System.out.println("Zgadnij liczbę od 0 do 1000: ");
		
		number = getInt("Niepoprawny typ danych - podaj liczbę:");
		
		while(secretNumber != number) {        
			if(secretNumber > number) {
				System.out.println("Za mało!");
			}
			else if(secretNumber < number) {
				System.out.println("Za dużo!");
			}
			number = getInt("Niepoprawny typ danych - podaj liczbę:");
		}	
		System.out.println("Zgadłeś :)!");
	}	
	
	public static int getInt(String message) {
        Scanner scan = new Scanner(System.in);
        while(!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println(message);
        }
        return scan.nextInt();		
	}
}