package BlackJack;

public class Deck {
	
	int noOfDecks;
	static int totalSets;
	static int[][] arrayDeck;
	private static Deck ref;
	
//	Singleton Pattern *One instance of deck
	//[suit][0] = NULL (e.g. [club][1] = Ace of clubs)
	private Deck(int numOfSets)
	{
		arrayDeck = new int[4][14];		
		for(int i = 0; i < 4; i++){
			for(int x = 1; x < 14; x++){
				arrayDeck[i][x] = numOfSets;
			}
		}
		
	}
	
	public static Deck getSingleton(int numOfSets)
	{
		totalSets = numOfSets;
		if (ref == null)
			ref = new Deck(numOfSets);
		return ref;
		
	}
	
//	private static Deck ref;
	
	
	public static void removeCard(int suit, int cardValue){
		arrayDeck[suit][cardValue] = arrayDeck[suit][cardValue] - 1; 
		
	}
	
	public static void addCard(int suit, int cardValue){
		
		arrayDeck[suit][cardValue] = arrayDeck[suit][cardValue] = 1; 
		
	}
	
	private static int getNumCardsLeft(){
		int totalCount = 0;
		for(int i = 0; i < 4; i++)
			for(int x = 1; x < 14; x++){
				totalCount = totalCount + arrayDeck[i][x];
			}
		return totalCount;
	}
	

	
	// Following two methods used to get Number of Cards Left of a specific suit
	
	//pass in the suit value 0, 1, 2, 3 to correspond to suits
	private static int getNumSuitLeft(int suit){
		int totalSuitCount = 0;
		for (int x = 1; x < 14; x++){
			totalSuitCount = totalSuitCount + arrayDeck[suit][x];
		}
		return totalSuitCount;
	}
	
	// method below takes instance of Card c.
	
	public static int getNumSuitleft(Card c){
		getNumSuitLeft(c.getCardSuit());
		return 0;
	}
	
	
	
	
	
	// Following two methods used to get Number of Cards Left of a specific value 
	
	private static int getNumValueLeft(int cardValue){
		int totalValueCount = 0;
		for (int i = 0; i < 4; i++){
			totalValueCount = totalValueCount + arrayDeck[i][cardValue];
		}
		return totalValueCount;
	}
	
	
	// method below takes instance of Card c.
	
	public static int getNumValueLeft(Card c){
		getNumValueLeft(c.getCardValue());
		return 0;
		
	}
	
	
	
	
	
	// Following two methods used to get Number of Cards Left of a specific suit and value
	
	
	private static int getNumCardLeft(int suit, int CardValue){
		int totalCardValue = 0;
		totalCardValue = arrayDeck[suit][CardValue];
		return totalCardValue;
	}
	
	// method below takes instance of Card c.
	
	public static int getNumCardLeft(Card c){
		getNumCardLeft(c.getCardSuit(), c.getCardValue());
		return 0;
	}
	
	public static void repopulate(){
		ref = new Deck(totalSets);		
	}
	
	public static int getNumDecks(){
		return totalSets;
	}

}
