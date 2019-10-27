import java.util.*;

public class RandomBoxDriver {

	public static void main(String[] args) {

		System.out.println("\n***TESTING GENERIC CLASS***\n");
		RandomBox<String> nameDrawing = new RandomBox<String>();
		fillNames(nameDrawing);
		System.out.println("Random Name Drawing: Should be size 65: " + nameDrawing.size());
		nameDrawing.displayEntries();
		System.out.println("Randomly chosen winner: " + nameDrawing.drawWinner());
		System.out.println("Size is now 64: " + nameDrawing.size());

		RandomBox<Integer> numberDrawing = new RandomBox<Integer>();
		fillNumbers(numberDrawing, 100);
		System.out.println("\nRandom Number Drawing: Should be size 100: " + numberDrawing.size());
		numberDrawing.displayEntries();
		System.out.println("Randomly chosen winner: " + numberDrawing.drawWinner());
		System.out.println("Size is now 99: " + numberDrawing.size());

		// SUGGESTION: CREATE A RANDOMBOX THAT HOLDS SOME OTHER TYPE- ANY CLASS YOU'VE GOT!

		// UNCOMMENT WHEN YOU WRITE YOUR STATIC METHOD

		System.out.println("\n***TESTING GENERIC METHOD***");
		System.out.println("\nRandom Name Drawing: Should be 5 unique winners:");
		List<String> nameWinners = pickMultipleUniqueWinners(nameDrawing, 5);
		System.out.println(nameWinners);
		System.out.println("Size is now 59: " + nameDrawing.size());

		System.out.println("\nRandom Number Drawing: Should be 3 unique winners:");
		List<Integer> numberWinners = pickMultipleUniqueWinners(numberDrawing, 3);
		System.out.println(numberWinners);
		System.out.println("Size is now 96: " + numberDrawing.size());

		System.out.println("\nSmall Contest Drawing: Should be 3 unique winners:");
		RandomBox<String> smallDrawingTest = new RandomBox<String>();
        smallDrawingTest.addEntry("Winner1");
        smallDrawingTest.addEntry("Winner2");
        smallDrawingTest.addEntry("Winner3");
		List<String> smallContestWinners = pickMultipleUniqueWinners(smallDrawingTest, 3);
		System.out.println(smallContestWinners);
		System.out.println("Size is now 0: " + smallDrawingTest.size());

		System.out.println("\nSmall Contest Repeat Drawing: Should be 3 unique winners:");
        smallDrawingTest.addEntry("Winner1"); smallDrawingTest.addEntry("Winner1"); smallDrawingTest.addEntry("Winner1");
        smallDrawingTest.addEntry("Winner2"); smallDrawingTest.addEntry("Winner2"); smallDrawingTest.addEntry("Winner2"); smallDrawingTest.addEntry("Winner2");
        smallDrawingTest.addEntry("Winner3"); smallDrawingTest.addEntry("Winner3"); smallDrawingTest.addEntry("Winner3");
		smallContestWinners = pickMultipleUniqueWinners(smallDrawingTest, 3);
		System.out.println(smallContestWinners);
		System.out.println("Size is now 7: " + smallDrawingTest.size());

		System.out.println("\nNot Enough Entries Drawing: Code should take some logical action but should NOT return a list with duplicate winners or enter an infinite loop.");
		RandomBox<String> insufficientContest = new RandomBox<String>();
		insufficientContest.addEntry("Winner1");
		insufficientContest.addEntry("Winner2");
        insufficientContest.addEntry("Winner3");
		List<String> insufficientWinners = pickMultipleUniqueWinners(insufficientContest, 4);
		System.out.println(insufficientWinners);
        // IMPORTANT NOTE: Depending on your solution, your program might end here.
        // If it does, you should then comment out this section above so you can test
        // the next section.

		System.out.println("\nEmpty Drawing: Code should take some logical action but should NOT enter an infinite loop.");
		RandomBox<Integer> emptyContest = new RandomBox<Integer>();
		List<Integer> emptyWinners = pickMultipleUniqueWinners(emptyContest, 4);
		System.out.println(emptyWinners);
	    // IMPORTANT NOTE: Depending on your solution, your program might end here.


		System.out.println("Program complete!");

	}

	// YOUR GENERIC METHOD HERE

	public static <T> List<T> pickMultipleUniqueWinners(RandomBox<T> drawing, int winnerCount) {
		List<T> winners = new ArrayList<>();
		List<T> duplicates = new ArrayList<>();
		Set<T> duplicateTracker = new HashSet<>();
		while (drawing.size() > 0 && winners.size() < winnerCount) {
			T item = drawing.drawWinner();
			if (duplicateTracker.add(item)) {
				winners.add(item);
			} else {
				duplicates.add(item);
			}
		}
		for (T item : duplicates) {
			drawing.addEntry(item);
		}
		return winners;
	}

	public static void fillNames(RandomBox<String> wordBox) {
		wordBox.addEntry("Adam Zapel"); wordBox.addEntry("Al Dente"); wordBox.addEntry("Al Fresco"); wordBox.addEntry("Al K. Seltzer"); wordBox.addEntry("Alf A. Romeo"); wordBox.addEntry("Amanda Lynn"); wordBox.addEntry("Anita Job"); wordBox.addEntry("Anna Conda"); wordBox.addEntry("Anna Graham"); wordBox.addEntry("Anna Prentice "); wordBox.addEntry("Anna Sasin"); wordBox.addEntry("Anne Teak"); wordBox.addEntry("B.A. Ware"); wordBox.addEntry("Barb Dwyer"); wordBox.addEntry("Barb E. Dahl"); wordBox.addEntry("Barbara Seville"); wordBox.addEntry("Barry Cade"); wordBox.addEntry("Bea Minor"); wordBox.addEntry("Dee Major"); wordBox.addEntry("Beau Tye"); wordBox.addEntry("Bill Board"); wordBox.addEntry("Cara Van"); wordBox.addEntry("Chris P. Bacon"); wordBox.addEntry("Constance Noring"); wordBox.addEntry("Crystal Ball"); wordBox.addEntry("Crystal Glass"); wordBox.addEntry("Earl Lee Riser"); wordBox.addEntry("Easton West "); wordBox.addEntry("Ferris Wheeler"); wordBox.addEntry("Flint Sparks"); wordBox.addEntry("Franklin Stein "); wordBox.addEntry("Gene Poole"); wordBox.addEntry("Heidi Clare"); wordBox.addEntry("Helen Back"); wordBox.addEntry("Helen Wiells"); wordBox.addEntry("Holly McRell"); wordBox.addEntry("Holly Wood"); wordBox.addEntry("Jack Pott"); wordBox.addEntry("Joe Kerr"); wordBox.addEntry("Joy Rider"); wordBox.addEntry("Justin Case"); wordBox.addEntry("Justin Time"); wordBox.addEntry("Kandi Apple"); wordBox.addEntry("Laura Norder"); wordBox.addEntry("Leigh King "); wordBox.addEntry("Luke Warm"); wordBox.addEntry("Marsha Mellow"); wordBox.addEntry("Marshall Law"); wordBox.addEntry("Marty Graw"); wordBox.addEntry("Olive Branch"); wordBox.addEntry("Paige Turner"); wordBox.addEntry("Pepe Roni"); wordBox.addEntry("Price Wright"); wordBox.addEntry("Rocky Beach"); wordBox.addEntry("Sandy Beach"); wordBox.addEntry("Sal A. Mander"); wordBox.addEntry("Stanley Cupp"); wordBox.addEntry("Tom Morrow"); wordBox.addEntry("Warren Peace"); wordBox.addEntry("Will Power"); wordBox.addEntry("X. Benedict");
		wordBox.addEntry("Pete Repeaty"); wordBox.addEntry("Pete Repeaty"); wordBox.addEntry("Pete Repeaty"); wordBox.addEntry("Pete Repeaty");
	}

	public static void fillNumbers(RandomBox<Integer> numbersBox, int numberOfNumbers) {
		Random generator = new Random();
		int maxNumber = numberOfNumbers * 10;
		for(int i=0; i<numberOfNumbers; i++) {
			numbersBox.addEntry(generator.nextInt(maxNumber));
		}
	}

}
