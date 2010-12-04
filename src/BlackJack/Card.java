package BlackJack;

public class Card {
	
	private int suit;
	private int value;
	
	public Card(int s, int v) {
		suit = s;
		value = v;
	}
	
	public int getCardSuit(){
		return suit;
	}
	
	public int getCardValue(){
		return value;
	}
	
	public boolean equals(Card c){
		boolean equality = false;
		if (c.getCardSuit() == suit && c.getCardValue() == value) {
			equality = true;
		}
		return equality;
	}
		
}
