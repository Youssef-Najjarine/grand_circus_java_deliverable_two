package grand_circus_java_deliverable_two;

import java.util.Random;
import java.util.Scanner;

public class Deliverable2 {

	public static void main(String[] args) {
		System.out.println("Welcome to the COIN FLIP CHALLENGE!");
		System.out.print("What is your name? ");
		
		Scanner scanner = new Scanner(System.in);
		String nameEntered = scanner.nextLine().trim();
		String invalidEntryMessage = "Valid entry not entered.";
		String userResponse;
		Integer roundAmount;
		Integer score = 0;
		Boolean invalidResponse;
		// Play Game Loop Validation
		do {
			System.out.print(String.format("Welcome %s. Do you want to do the COIN FLIP CHALLENGE? Yes/No ",nameEntered));
			userResponse = scanner.nextLine().trim().toLowerCase();
			invalidResponse = !userResponse.equals("yes") && !userResponse.equals("no");
			if (invalidResponse) System.out.println(invalidEntryMessage);
		} while (invalidResponse);
		
		// Deny game Check
		if (userResponse.toLowerCase().trim().equals("no")) {
			System.out.println(String.format("You are a coward %s",nameEntered));
			scanner.close();
			return;
		}
		
		// Round Number Entered Loop Validation
		do {
			System.out.print("How many rounds do you want to play? 5 or 10? ");
			userResponse = scanner.nextLine().trim();
			invalidResponse = !userResponse.equals("5") && !userResponse.equals("10");
			if (invalidResponse) System.out.println(invalidEntryMessage);
		} while (invalidResponse);
		roundAmount = Integer.parseInt(userResponse.trim());
		Random random = new Random();
		for (Integer i = 1; i <= roundAmount;i++) {
			// Coin Side Entered Loop Validation
			do {
				System.out.print("Heads or Tails?");
				userResponse = scanner.nextLine().trim().toLowerCase();
				invalidResponse = !userResponse.equals("heads") && !userResponse.equals("tails");
				if (invalidResponse) System.out.println(invalidEntryMessage);
			} while (invalidResponse);
			
			Integer coinFlip = random.nextInt(0,2);
			String coinFlipResult = coinFlip == 0 ? "heads" : "tails";
			Boolean isCorrectAnswer = coinFlipResult.equals(userResponse);
			if (isCorrectAnswer) {
				score++;
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong!");
			}
		}
		
		System.out.println(String.format("Thank you %s. You got a score of %,d!",nameEntered, score));
		scanner.close();
	}

}
