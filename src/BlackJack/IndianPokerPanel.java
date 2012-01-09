package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IndianPokerPanel implements GamePanel {

	JTextField cardValField;
	JTextField cardSuitField;
	JButton hitButton;
	JButton removeCardButton;
	JButton calcButton;
	JButton shuffleButton;
	JButton newRoundButton;
	IndianPokerGameChief gm;
	JLabel stats;
	@Override
	public void add(JPanel panel, GameMaster master) {
		if(master instanceof IndianPokerGameChief){
			gm = (IndianPokerGameChief) master;
		}
		else return;
		cardValField = new JTextField(2);
		cardValField.setText("a");
		panel.add(cardValField);
		cardSuitField = new JTextField(8);
		cardSuitField.setText("diamonds");
		panel.add(cardSuitField);
		hitButton = new JButton("Add Card");
		panel.add(hitButton);
		removeCardButton = new JButton("Remove Card");
		panel.add(removeCardButton);
		calcButton = new JButton("Calculate");
		panel.add(calcButton);
		shuffleButton = new JButton("Shuffle");
		panel.add(calcButton);
		newRoundButton = new JButton("New Round");
		panel.add(newRoundButton);
		stats = new JLabel("No statistics to be displayed...");
		panel.add(stats);
		
		class hitListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.addCard(new Card(cardSuitField.getText().trim(), cardValField.getText().trim()));
		    }
		  }
		hitButton.addActionListener(new hitListener());
		class removeListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	gm.removeCard(new Card(cardSuitField.getText().trim(), cardValField.getText().trim()));
		    }
		  }
		newRoundButton.addActionListener(new removeListener());
		class calcListener implements ActionListener {
		    public void actionPerformed(ActionEvent event) {
		    	stats.setText(gm.getStats());
		    }
		  }
		calcButton.addActionListener(new calcListener());
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
