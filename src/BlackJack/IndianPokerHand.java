package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class IndianPokerHand extends Hand {
	
	ArrayList<Integer> arrayHandInt;
	
	public IndianPokerHand() {
		arrayHand = new ArrayList<Card>();
		arrayHandInt = new ArrayList<Integer>();
	}
	
	public int getHandValue() {
		int maxvalue = 0;
		for (int i = 0; i < arrayHand.size(); i++) {
			if(arrayHand.get(i).getCardValue() > maxvalue){
				maxvalue = arrayHand.get(i).getCardValue();
			}
		}
		return maxvalue;
	}
}
