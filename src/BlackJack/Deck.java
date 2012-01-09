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
	
	
	public void removeCard(int suit, int cardValue){
		arrayDeck[suit][cardValue] = arrayDeck[suit][cardValue] - 1; 
		
	}
	
	public void removeCard(Card c){
		removeCard(c.getCardSuit(), c.getCardValue());
	}
	
	public void addCard(int suit, int cardValue){
		
		arrayDeck[suit][cardValue] = arrayDeck[suit][cardValue] = 1; 
		
	}
	
	public int getNumCardsLeft(){
		int totalCount = 0;
		for(int i = 0; i < 4; i++)
			for(int x = 1; x < 14; x++){
				totalCount = totalCount + arrayDeck[i][x];
			}
		return totalCount;
	}
	

	
	// Following two methods used to get Number of Cards Left of a specific suit
	
	//pass in the suit value 0, 1, 2, 3 to correspond to suits
	private int getNumSuitLeft(int suit){
		int totalSuitCount = 0;
		for (int x = 1; x < 14; x++){
			totalSuitCount = totalSuitCount + arrayDeck[suit][x];
		}
		return totalSuitCount;
	}
	
	// method below takes instance of Card c.
	
	public int getNumSuitleft(Card c){
		return getNumSuitLeft(c.getCardSuit());
	}
	
	
	
	
	
	// Following two methods used to get Number of Cards Left of a specific value 
	
	private int getNumValueLeft(int cardValue){
		int totalValueCount = 0;
		for (int i = 0; i < 4; i++){
			totalValueCount = totalValueCount + arrayDeck[i][cardValue];
		}
		return totalValueCount;
	}
	
	
	// method below takes instance of Card c.
	
	public int getNumValueLeft(Card c){
		return getNumValueLeft(c.getCardValue());
		
	}
	
	
	
	
	
	// Following two methods used to get Number of Cards Left of a specific suit and value
	
	
	private int getNumCardLeft(int suit, int CardValue){
		int totalCardValue = 0;
		totalCardValue = arrayDeck[suit][CardValue];
		return totalCardValue;
	}
	
	// method below takes instance of Card c.
	
	public int getNumCardLeft(Card c){
		return getNumCardLeft(c.getCardSuit(), c.getCardValue());
	}
	
	public void repopulate(){
		ref = new Deck(totalSets);		
	}
	
	public int getNumSets(){
		return totalSets;
	}
	
	public void changeNumSets(int numOfSets) {
		totalSets = numOfSets;		
		for(int i = 0; i < 4; i++){
			for(int x = 1; x < 14; x++){
				arrayDeck[i][x] = numOfSets;
			}
		}
	}

}
