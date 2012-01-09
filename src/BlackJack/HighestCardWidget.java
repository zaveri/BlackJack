package BlackJack;

import java.util.ArrayList;

public class HighestCardWidget implements StatisticsWidget {

	public String calculate(Deck d, Hand hand){
		IndianPokerHand ipHand;
		if(hand instanceof IndianPokerHand){
			ipHand = (IndianPokerHand) hand;
		}
		else return null;
		int count = 0;
		System.out.println(ipHand.getHandValue());
		for(int i = ipHand.getHandValue()+1; i < 14; ++i){
			System.out.println("card " + i);
			count += d.getNumValueLeft(new Card(1, i));
		}
		int cardsLeft = d.getNumCardsLeft();
		int percent = (int) Math.round(((double) count/cardsLeft) * 100);
		return "The chance you have the highest card is " + (percent) + "%";
	}
	
	@Override
	public String calculate(Deck d, ArrayList<Hand> hands) {
		return this.calculate(d, hands.get(0));
	}

}
