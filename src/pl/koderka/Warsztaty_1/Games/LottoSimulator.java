package pl.koderka.Warsztaty_1.Games;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoSimulator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wytypuj 6 losowych liczb między 1 a 49");
			
		int[] numbers = new int[6];
			
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = getInt();
		
			while(numbers[i] < 1 || numbers[i] > 49) {        
			System.out.println("Liczba spoza zakresu - podaj liczbę jeszcze raz:");
			numbers[i] = getInt();
			}
			
			for(int j = 0; j < i; j++) {
				while(numbers[j] == numbers[i]) {
					System.out.println("Powtarzająca się liczba - podaj jeszcze raz");
					numbers[i] = getInt();
					j = 0;
				}
			}
		}
		System.out.println("Wytypowanie liczby to:");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " "); 
		}
		System.out.println();
	
	
		Integer[] lottoNumbers = new Integer[49];
		for(int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = i + 1;
		}

		Collections.shuffle(Arrays.asList(lottoNumbers));
		System.out.println("Wylosowane liczby to: ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(lottoNumbers[i] + " "); 
		}
		System.out.println();
		
		int count = 0;
		for(int number: numbers) {
			for(int j = 0; j < numbers.length; j++) {
				if(number == lottoNumbers[j]) {
					count++;
				}
			}
		}
		switch(count) {
		case 6:
			System.out.println("Gratulacje! Jesteś milionerem!");
			break;
		case 5:
			System.out.println("Blisko! Wytypowałeś piątkę!");
			break;
		case 4:
			System.out.println("Nieźle! Udało się wytypować czwórkę :)");
			break;
		case 3:
			System.out.println("Całkiem całkiem, trójka jest :)");
			break;
		default:
			System.out.println("Tym razem się nie udało :( próbuj dalej");
		}
		
	}
	
	public static int getInt() {
	        Scanner scan = new Scanner(System.in);
	        while(!scan.hasNextInt()) {
	            scan.next();
	            System.out.println("Niepoprawny typ danych - podaj liczbę:");
	        }
	        return scan.nextInt();
	    }
}