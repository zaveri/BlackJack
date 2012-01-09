package BlackJack;

public abstract class GameMaster {
	
	public abstract void addDeck(Deck d);
	
	public abstract void enterNumOfSets(int i);
	
	public abstract void newRound();
	
	public abstract void shuffle();
	
	public abstract String getStats();
	
}
