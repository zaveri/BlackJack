package BlackJack;

public class IndianPokerGameChief extends GameMaster {
	private static IndianPokerGameChief master;
	Deck gameDeck;
	IndianPokerHand hand;
	IndianPokerCalcFacade stats;
	
	private IndianPokerGameChief() {
		
	}
	
	public static IndianPokerGameChief getInstance() {
		if (master == null) {
			master = new IndianPokerGameChief();
		}
		return master;
	}
	
	public void addDeck(Deck d) {
		gameDeck = d;
	}
	
	public void addIndianPokerCalcFacade(IndianPokerCalcFacade s) {
		stats = s;
	}
	
	public void addIndianPokerHand(IndianPokerHand h) {
		hand = h;
	}
	
	public void enterNumOfSets(int i) {
		gameDeck.changeNumSets(i);
	}
	
	public void addCard(Card c) {
		hand.addCard(c);
		removeCard(c);
	}
	
	public void newRound() {
		hand.removeAll();
	}
	
	public void shuffle() {
		gameDeck.repopulate();
	}
	
	public void removeCard(Card c) {
		gameDeck.removeCard(c);
	}
	
	public String getStats() {
		System.out.println(hand.getNumOfCards());
		return stats.getStatistics(gameDeck, hand);
	}
}
