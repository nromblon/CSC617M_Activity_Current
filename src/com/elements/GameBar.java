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
	private JTextArea lblMessage;
	private JScrollPane scrlMessage;

	private JButton nextBtn;
//	private Queue<String> messageQueue;
	
	public GameBar(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
//		this.type = 1;
		this.initComponents();
		this.lblGamebarOverlay = new JLabel();
		Game.initLabels(this.lblGamebarOverlay, new ImageIcon("images/Gamebar_arcade.png"), null);

		//TODO
//		this.messageQueue = new LinkedList<>();

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
		int offsetY = 20;

		this.lblMessage = new JTextArea();
		Frame.initTextArea(this.lblMessage, Game.fntConsolas20, Game.clrTransparent, 0, 0, lblMessageOverlay.getWidth()-(offsetX*2), lblMessageOverlay.getHeight()-(offsetY*2));
		
		this.lblMessage.setForeground(Color.WHITE);
		this.lblMessage.setEditable(false);
		
		this.scrlMessage = new JScrollPane();
		Game.initScrollPane(scrlMessage, lblMessage, lblMessage.getBounds());
		this.scrlMessage.setLocation(offsetX, this.getHeight()-lblMessage.getHeight()-offsetY);
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
//				if(player.getParent().getParent().getControls().getActionQueue().isEmpty())
//					nextBtn.setVisible(false);
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

		lblMessage.repaint();
		lblMessage.revalidate();
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
		return lblMessage;
	}

	public void setLblMessage(JTextArea lblMessage) {
		this.lblMessage = lblMessage;
	}

	public void addMsgQueue(String message){
		this.lblMessage.setText(message);
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
