package BlackJack;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class simpleGUI {
  JFrame frame;
  JPanel panel;
  JTextField decks;
  JButton button1;
  JLabel label1;
  JTextField field1;
  FileWriter writer;
  JLabel gameLabel;
  String gameType = "";
  GameFactory factory;
  //GameMaster master;
  GamePanel gamePanel;
  int deckCount;

  public void go() {
    frame=new JFrame("BaseStation GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel=new JPanel();

    button1=new JButton("Start Game");
    button1.addActionListener(new button1Listener());

    label1=new JLabel("Input Game Type:");
    field1=new JTextField(20);
    field1.addActionListener(new button1Listener());

    gameLabel=new JLabel("\n You are currently playing " + gameType);
    decks = new JTextField(22);
    decks.setText("enter number of decks");
    
  
    frame.getContentPane().add(panel);
    panel.add(label1);
    panel.add(field1);
    panel.add(decks);
    panel.add(button1);
    panel.add(gameLabel);
    

    frame.setSize(500,300);
    frame.setVisible(true);
  }

  class button1Listener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
    	gameType = field1.getText(); 
    	try{
    		deckCount = Integer.parseInt(decks.getText());
        	System.out.println("decks: " + deckCount);
        }	
        catch(Exception e){
       		deckCount = 1;
       	}
       	setGameType();
    }
  }

  public void setGameType(){
      gameLabel.setText("\n You are currently playing " + gameType); 
      if(gameType.equalsIgnoreCase("blackjack")){
    	  factory = new BlackJackFactory();
    	  BlackJackGameMaster master = (BlackJackGameMaster)factory.buildMaster();
    	  gamePanel = factory.buildPanel();
    	  Deck d = factory.buildDeck(deckCount);
    	  master.addDeck(d);
    	  master.addPlayerHand((BlackJackHand) factory.buildHand());
    	  master.addDealerHand((BlackJackHand) factory.buildHand());
    	  master.addBlackJackCalcFacade((BlackJackCalcFacade)factory.buildFacade());
    	  gamePanel.add(panel, master);
      }
      else if(gameType.equalsIgnoreCase("indian poker")){
    	  factory = new IndianPokerFactory();
    	  IndianPokerGameChief master = (IndianPokerGameChief)factory.buildMaster();
    	  gamePanel = factory.buildPanel();
    	  Deck d = factory.buildDeck(deckCount);
    	  master.addDeck(d);
    	  master.addIndianPokerHand((IndianPokerHand) factory.buildHand());
    	  master.addIndianPokerCalcFacade((IndianPokerCalcFacade) factory.buildFacade());
    	  gamePanel.add(panel, master);
      }
      else{
    	  gameLabel.setText("game not recognized...");
      }
  }

  public static void main (String[] args) {
    simpleGUI gui=new simpleGUI();
    gui.go(); 
  }
}
