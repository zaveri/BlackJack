package BlackJack;

public class IndianPokerFactory implements GameFactory {

	public Card buildCard(int suit, int value) {
		return new Card(suit, value);
	}

	public Deck buildDeck(int numOfSets) {
		return Deck.getSingleton(numOfSets);
	}

	public CalcFacade buildFacade() {
		IndianPokerCalcFacade f = new IndianPokerCalcFacade();
		f.addWidget(new HighestCardWidget());
		return f;
	}

	public Hand buildHand() {
		return new IndianPokerHand();
	}

	public GameMaster buildMaster() {
		IndianPokerGameChief m = IndianPokerGameChief.getInstance();
		return m;
	}

	@Override
	public GamePanel buildPanel() {
		return new IndianPokerPanel();
	}
}
