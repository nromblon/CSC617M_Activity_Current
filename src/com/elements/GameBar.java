package com.elements;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import com.characters.Character;
import com.frame.Frame;

public class GameBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel parent;
	private Character player;
	
	private JLabel lblGamebarOverlay;
	private JLabel lblPlayer;
	private JLabel lblMessageOverlay;
	private JTextArea txtaMessage;
	private JScrollPane scrlMessage;

	private JButton nextBtn;
//	private Queue<String> messageQueue;
	
	public GameBar(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		this.lblGamebarOverlay = new JLabel();
		Game.initLabels(this.lblGamebarOverlay, new ImageIcon("images/Gamebar_arcade.png"), null);

		this.add(nextBtn);
		this.add(scrlMessage);
		this.add(lblMessageOverlay);
		this.add(lblGamebarOverlay);

		this.setComponentZOrder(nextBtn,0);
	}
	
	private void initComponents() {		
		this.lblGamebarOverlay = new JLabel();
		this.lblPlayer = new JLabel();

		Game.initLabels(this.lblGamebarOverlay, new ImageIcon("images/Gamebar_versus_player1.png"), null);
		Game.initLabels(this.lblPlayer, this.player.getName()+"_playerOverlay_1", null);			
		this.lblPlayer.setLocation(30, 658);
		
		
		this.lblMessageOverlay = new JLabel();
		Game.initLabels(this.lblMessageOverlay, "lblMessage_trans", null);
		this.lblMessageOverlay.setLocation(0, this.getHeight()-lblMessageOverlay.getHeight());
		
		int offsetX = 34;

		this.txtaMessage = new JTextArea();
		Frame.initTextArea(this.txtaMessage, Game.fntConsolas20, Color.WHITE, 0, 0, 1050-offsetX*2, 147);
		this.txtaMessage.setLineWrap(true);
		this.txtaMessage.setWrapStyleWord(true);
		this.txtaMessage.setForeground(Color.WHITE);
		this.txtaMessage.setEditable(false);
		
		this.scrlMessage = new JScrollPane();
		Game.initScrollPane(scrlMessage, txtaMessage, txtaMessage.getBounds());
		this.scrlMessage.setLocation(offsetX, this.getHeight()-txtaMessage.getHeight()+25);
		this.scrlMessage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrlMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


		this.nextBtn = new JButton();
		Game.initButtons(nextBtn, "next", 1000, this.getHeight() - 48, true, new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
//				if(messageQueue.peek() != null) {
//					lblMessage.setText(messageQueue.remove());
//				}
				player.setInAction(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		
		this.nextBtn.setVisible(false);

	}
	
	public void update() {

		txtaMessage.repaint();
		txtaMessage.revalidate();
		scrlMessage.repaint();
		scrlMessage.revalidate();
		nextBtn.repaint();
		nextBtn.revalidate();
	}
	
	public JPanel getParent() {
		return parent;
	}

	public JButton getNextBtn() {
		 return nextBtn;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}

	public JTextArea getLblMessage() {
		return txtaMessage;
	}

	public void setLblMessage(JTextArea lblMessage) {
		this.txtaMessage = lblMessage;
	}

	public void addMsgQueue(String message){
		this.txtaMessage.setText(message);
//		if(lblMessage.getText().equals(""))
//			this.lblMessage.setText(message);
//		else {
//			this.messageQueue.add(message);
//		}
	}

//	public void clearMsgQueue(){
//		this.messageQueue.clear();
//	}
}
