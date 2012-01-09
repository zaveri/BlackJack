 package BlackJack;

public class BlackJackGameMaster extends GameMaster {
	private static BlackJackGameMaster master;
	Deck gameDeck;
	BlackJackHand playerHand;
	BlackJackHand dealerHand;
	BlackJackCalcFacade stats;
	
	private BlackJackGameMaster() {
		
	}
	
	public static BlackJackGameMaster getInstance() {
		if (master == null) {
			master = new BlackJackGameMaster();
		}
		return master;
	}
	
	public void addDeck(Deck d) {
		gameDeck = d;
	}
	
	public void addBlackJackCalcFacade(BlackJackCalcFacade s) {
		stats = s;
	}
	
	public void addPlayerHand(BlackJackHand pl) {
		playerHand = pl;
	}
	
	public void addDealerHand(BlackJackHand dl) {
		dealerHand = dl;
	}
	
	public void enterNumOfSets(int i) {
		gameDeck.changeNumSets(i);
	}
	
	public void addPlayerCard(BlackJackCard c) {
		playerHand.addCard(c);
		removeCard(c);
	}
	
	public void addDealerCard(BlackJackCard c) {
		dealerHand.addCard(c);
		removeCard(c);
	}
	
	public void newRound() {
		playerHand.removeAll();
		dealerHand.removeAll();
	}
	
	public void shuffle() {
		gameDeck.repopulate();
	}
	
	public String getStats() {
		return stats.getStatistics(gameDeck, playerHand, dealerHand);
	}
	
	public void removeCard(BlackJackCard c) {
		gameDeck.removeCard(c);
	}
}
