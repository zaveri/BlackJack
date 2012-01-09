package BlackJack;

import java.util.ArrayList;

public class WinningWidget implements StatisticsWidget {

	@Override
	public String calculate(Deck d, ArrayList<Hand> hands) {
		BlackJackHand playerHand;
		BlackJackHand dealerHand;
		if(hands.get(0) instanceof BlackJackHand && hands.get(1) instanceof BlackJackHand){
			playerHand = (BlackJackHand) hands.get(0);
			dealerHand = (BlackJackHand) hands.get(1);
		}
		else{
			System.out.println("error: hand not of type BlackJack Hand");
			return null;
		}
		int handValue = playerHand.getHandValue();
		int count = 0;
		for(int i = 1; i < 11; ++i){
			if((dealerHand.getHandValue() + i > handValue) && (dealerHand.getHandValue() + i < 22)){
				count += d.getNumValueLeft(new Card(1, i));
			}
		}
		if((handValue > dealerHand.getHandValue() + 1) && (dealerHand.getHandValue() + 11 > handValue) 
				&& (dealerHand.getHandValue() + 11 < 22)){
			count += d.getNumValueLeft(new Card(1, 1));
			
		}
		int cardsLeft = d.getNumCardsLeft();
		int percent = (int) Math.round(((double) count/cardsLeft) * 100);
		return "The probability that the Dealer is currently winning is " + percent + "%";
	}

}
