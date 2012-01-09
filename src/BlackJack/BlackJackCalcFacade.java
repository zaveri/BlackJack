package BlackJack;

import java.util.ArrayList;

public class BlackJackCalcFacade implements CalcFacade{
	private ArrayList<StatisticsWidget> widgets;
	public BlackJackCalcFacade(){
		widgets = new ArrayList<StatisticsWidget>();
	}
	
	public String getStatistics(Deck d, BlackJackHand playerHand, BlackJackHand dealerHand){
		ArrayList<Hand> al = new ArrayList<Hand>();
		al.add(playerHand);
		al.add(dealerHand);
		return this.getStatistics(d, al);
	}
	
	public String getStatistics(Deck d, ArrayList<Hand> hands){
		String stats = "";
		for(StatisticsWidget w: widgets){
			stats += w.calculate(d, hands);
			//stats += "\n";
		}
		return stats;
	}
	public void addWidget(StatisticsWidget w){
		widgets.add(w);
	}
	public void addWidgets(ArrayList<StatisticsWidget> w){
		widgets.addAll(w);
	}
	public void removeWidget(StatisticsWidget w){
		if(widgets.contains(w))
			widgets.remove(w);
		return;
	}
}
