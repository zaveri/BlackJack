package BlackJack;

public interface GameFactory {
	
	public Card buildCard(int suit, int value);
	public Deck buildDeck(int numOfSets);
	public Hand buildHand();
	public CalcFacade buildFacade();
	public GameMaster buildMaster();
	public GamePanel buildPanel();
	
}
