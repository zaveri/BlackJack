package BlackJack;

public class BlackJackFactory implements GameFactory {

	public Card buildCard(int suit, int value) {
		return new Card(suit, value);
	}

	public Deck buildDeck(int numOfSets) {
		return Deck.getSingleton(numOfSets);
	}

	public CalcFacade buildFacade() {
		BlackJackCalcFacade f = new BlackJackCalcFacade();
		f.addWidget(new BustWidget());
		f.addWidget(new WinningWidget());
		return f;
	}

	public Hand buildHand() {
		return new BlackJackHand();
	}

	public GameMaster buildMaster() {
		BlackJackGameMaster m = BlackJackGameMaster.getInstance();
		return m;
	}

	public GamePanel buildPanel() {
		return new BlackJackPanel();
	}
}
