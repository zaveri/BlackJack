package BlackJack;

import java.util.ArrayList;

public class BlackJackHand extends Hand {
	
	ArrayList<BlackJackCard> arrayBlackJackHand;
	
	
	public BlackJackHand() {
		arrayBlackJackHand = new ArrayList<BlackJackCard>();
	}
	
	
	public void addCard(BlackJackCard c) {
		 arrayBlackJackHand.add(c);
	 }
	
	public BlackJackCard getCard(int n) {
		 return arrayBlackJackHand.get(n);
	 }
	
	 public void removeCard(BlackJackCard c) {
		 for (int i = 0; i < arrayBlackJackHand.size(); i++) {
			 if (getCard(i).equals(c)) {
				 arrayBlackJackHand.remove(i);
			 }
		 }
	 }
	 
	 public void removeAll() {
		 arrayBlackJackHand.clear();
	 }
	 
	 public int getNumOfCards() {
		 return arrayBlackJackHand.size();
	 }
	 
	 // method to return BlackJackHand ArrayList
	 // using ArrayList of Card type just to return BlackJack Hands
	 
	 public ArrayList<Card> getAll() {
		 ArrayList<Card> tempArrayHand;
		 tempArrayHand = new ArrayList<Card>();
		 for(int i = 0; i < arrayBlackJackHand.size(); i++){
			 tempArrayHand.add(arrayBlackJackHand.get(i));
		 }
		 return tempArrayHand;
	 }
	
	
	
	public int getNumOfAces() {
		int numA = 0;
		for (int i = 0; i<arrayBlackJackHand.size(); i++) {
			if (arrayBlackJackHand.get(i).getCardValue() == 1) {
				numA = numA +1;
			}
		 }
		return numA;
	}
	
	public int getHandValue(){
		int noAce = this.calcHandValue();
		int ace = this.calcHandValueAce();
		if (ace <= 21) return ace;
		else return noAce;
	}

	int calcHandValue() {
		int sum = 0;
		for (int i = 0; i < arrayBlackJackHand.size(); i++) {
			sum = sum + arrayBlackJackHand.get(i).getCardValue();
		
		}
		return sum;
	}

	
	int calcHandValueAce() {
		int alt = calcHandValue();
		if (getNumOfAces() > 0) {
			alt = alt + 10;
		}
		return alt;
	}
	
	public boolean isBust() {
		boolean bust = false;
		if (getHandValue() > 21) {
			bust = true;
		}
		return bust;
	}
	
	public boolean hastwentyone() {
		return getHandValue() == 21;
	}
	

}
