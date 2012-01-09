package BlackJack;

import java.util.ArrayList;

public class Hand {
	
	 ArrayList<Card> arrayHand;
	 
	 public Hand(){
		 //Not Sure
		 arrayHand = new ArrayList<Card>();
	 }
 
	 public void addCard(Card c) {
		 arrayHand.add(c);
	 }
	 
	 public Card getCard(int n) {
		 return arrayHand.get(n);
	 }
	
	 public void removeCard(Card c) {
		 for (int i = 0; i < arrayHand.size(); i++) {
			 if (getCard(i).equals(c)) {
				 arrayHand.remove(i);
			 }
		 }
	 }

	 public void removeAll() {
		 arrayHand.clear();
	 }
	 
	 public int getNumOfCards() {
		 return arrayHand.size();
	 }
	 
	 public ArrayList<Card> getAll() {
		 return arrayHand;
	 }
}
