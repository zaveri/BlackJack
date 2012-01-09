package BlackJack;

public class BlackJackCard extends Card {
	
	public BlackJackCard (int s, int v) {
		super(s, v);
		suit = s;
		value = v;
	}
	
	public BlackJackCard(String s, String val){
		super(s, val);
	}
	
	public int getValue() {
		if (value == 10) {
			return  10;
		}
		else if (value == 11) {
			return 10;
		}
		else if (value == 12) {
			return 10;
		}
		else if (value == 13) {
			return 10;
		}
		else {
			return value;
		}
	}
	
	

}
