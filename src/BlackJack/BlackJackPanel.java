package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BlackJackPanel implements GamePanel{
	JTextField cardValField;
	JTextField cardSuitField;
	JButton hitButton;
	JButton removeCardButton;
	JButton calcButton;
	JButton dealerButton;
	JButton shuffleButton;
	JButton newRoundButton;
	BlackJackGameMaster gm;
	JLabel stats;
	
	public void add(JPanel panel, GameMaster master){
		if(master instanceof BlackJackGameMaster){
			gm = (BlackJackGameMaster) master;
		}
		else return;
		cardValField = new JTextField(2);
		cardValField.setText("a");
		panel.add(cardValField);
		cardSuitField = new JTextField(8);
		cardSuitField.setText("diamonds");
		panel.add(cardSuitField);
		hitButton = new JButton("Hit");
		panel.add(hitButton);
		removeCardButton = new JButton("Remove Card");
		panel.add(removeCardButton);
		calcButton = new JButton("Calculate");
		panel.add(calcButton);
		dealerButton = new JButton("Add dealer card");
		panel.add(dealerButton);
		shuffleButton = new JButton("Shuffle");
		panel.add(calcButton);
		newRoundButton = new JButton("New Round");
		panel.add(newRoundButton);
		stats = new JLabel("No statistics to be displayed...");
		panel.add(stats);
		
		
		class hitListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.addPlayerCard(new BlackJackCard(cardSuitField.getText().trim(), cardValField.getText().trim()));
		    }
		  }
		hitButton.addActionListener(new hitListener());
		class removeListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.removeCard(new BlackJackCard(cardSuitField.getText().trim(), cardValField.getText().trim()));
		    }
		  }
		removeCardButton.addActionListener(new removeListener());
		class calcListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	stats.setText(gm.getStats());
		    }
		  }
		calcButton.addActionListener(new calcListener());
		class dealerListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.addDealerCard(new BlackJackCard(cardSuitField.getText().trim(), cardValField.getText().trim()));
		    }
		  }
		dealerButton.addActionListener(new dealerListener());
		class shuffleListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.shuffle();
		    }
		  }
		shuffleButton.addActionListener(new shuffleListener());
		class newRoundListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.newRound();
		    }
		  }
		newRoundButton.addActionListener(new newRoundListener());
		
	}
}
