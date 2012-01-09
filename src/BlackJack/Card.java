package BlackJack;

public class Card {
	
	protected int suit;
	protected int value;
	
	public Card(int s, int v) {
		suit = s;
		value = v;
	}
	
	public Card(String s, String val){

		for(int i = 1; i < 11; ++i){
			try{
				if(Integer.parseInt(val) == i){
					value = i;
				}
			}				
			catch(Exception e){}
			
		}
		if(val.equalsIgnoreCase("j")){
			value = 11;
		}
		if(val.equalsIgnoreCase("q")){
			value = 12;
		}
		if(val.equalsIgnoreCase("k")){
			value = 13;
		}
		if(val.equalsIgnoreCase("a")){
			value = 1;
		}
		
		if(s.equalsIgnoreCase("clubs")){
			suit = 0;
		}
		if(s.equalsIgnoreCase("spades")){
			suit = 1;
		}
		if(s.equalsIgnoreCase("hearts")){
			suit = 2;
		}
		if(s.equalsIgnoreCase("diamonds")){
			suit = 3;
		}
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
