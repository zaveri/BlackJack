package BlackJack;

import java.util.ArrayList;

public interface CalcFacade {
	public String getStatistics(Deck d, ArrayList<Hand> hands);
	public void addWidget(StatisticsWidget w);
	public void addWidgets(ArrayList<StatisticsWidget> w);
	public void removeWidget(StatisticsWidget w);
}
