package BlackJack;

import java.util.ArrayList;

public class IndianPokerCalcFacade implements CalcFacade {
	private ArrayList<StatisticsWidget> widgets;
	@Override
	public void addWidget(StatisticsWidget w) {
		widgets = new ArrayList<StatisticsWidget>();
		widgets.add(w);
		
	}

	@Override
	public void addWidgets(ArrayList<StatisticsWidget> w) {
		widgets.addAll(w);
	}

	public String getStatistics(Deck d, Hand hand){
		ArrayList<Hand> hands = new ArrayList<Hand>();
		hands.add(hand);
		return this.getStatistics(d, hands);
	}
	
	@Override
	public String getStatistics(Deck d, ArrayList<Hand> hands) {
		String stats = "";
		for(StatisticsWidget w:widgets){
			stats += w.calculate(d, hands);
			stats += "\n";
		}
		return stats;
	}

	@Override
	public void removeWidget(StatisticsWidget w) {
		if(widgets.contains(w)){
			widgets.remove(w);
		}
	}

}
