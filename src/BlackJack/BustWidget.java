package BlackJack;

import java.util.ArrayList;

public class BustWidget implements StatisticsWidget {

	@Override
	public String calculate(Deck d, ArrayList<Hand> hands) {
		BlackJackHand playerHand;
		if(hands.get(0) instanceof BlackJackHand){
			playerHand = (BlackJackHand) hands.get(0);
		}
		else{
			System.out.println("error: hand not of type BlackJack Hand");
			return null;
		}
		int count = 0;
		int cardsLeft = d.getNumCardsLeft();
		for(int i = 1; i <= 10; ++i){
			if(playerHand.calcHandValue() + i > 21){
				count += d.getNumValueLeft(new Card(1, i));
			}
		}
		int percent = (int) Math.round(((double) count/cardsLeft) * 100);
		return "The chance of a bust is: " + percent + "%";
	}

}
