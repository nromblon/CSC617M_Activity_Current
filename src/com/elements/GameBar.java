package com.elements;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.characters.Character;
import com.frame.Frame;

public class GameBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel parent;
	private Character player;
	
//	private JLabel lblHealthBar;
//	private JLabel lblHealth;

//	private JLabel lblMagicBar;
//	private JLabel lblMagic;
	
	private JLabel lblGamebarOverlay;
	private JLabel lblPlayer;
	private JLabel lblMessageOverlay;
	private JTextArea lblMessage;
	private JScrollPane scrlMessage;

	private Queue<String> messageQueue;
	
	public GameBar(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
//		this.type = 1;
		this.initComponents();
		this.lblGamebarOverlay = new JLabel();
		Game.initLabels(this.lblGamebarOverlay, new ImageIcon("images/Gamebar_arcade.png"), null);

		this.messageQueue = new LinkedList<>();

		this.add(scrlMessage);
		this.add(lblMessageOverlay);
		this.add(lblGamebarOverlay);
	}
	
	private void initComponents() {		
		this.lblGamebarOverlay = new JLabel();
		this.lblPlayer = new JLabel();		
		
		
//		this.lblHealthBar = new JLabel();
//		this.lblHealthBar.setBounds(117, 674, 329, 17);
//		this.lblHealth = new JLabel();
//		this.lblHealth.setBounds(0, 0, lblHealthBar.getWidth(), lblHealthBar.getHeight());
//		this.lblMagicBar = new JLabel();
//		Game.initLabel(this.lblMagicBar, Game.fntGothamLight12, Color.WHITE, lblHealthBar.getX()+7, 695, 295, 9);
//		this.lblMagic = new JLabel();
//		Game.initLabel(this.lblMagic, Game.fntGothamLight12, Game.clrTurquoise, 0, 0, lblMagicBar.getWidth(), lblMagicBar.getHeight());
//		
//		Game.initLabels(this.lblHealthBar, "Health_bg_1", null);
//		Game.initLabels(this.lblHealth, "Health_points_1", null);
//		this.lblHealth.setHorizontalAlignment(JLabel.RIGHT);
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
//		this.scrlMessage.setLocation(offsetX, 0);
		this.scrlMessage.setLocation(offsetX, this.getHeight()-lblMessage.getHeight()-offsetY);
		this.scrlMessage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrlMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		this.lblMessage.setText("This is a system message.");

	
	}
	
	public void update() {


		lblMessage.repaint();
		lblMessage.revalidate();
		scrlMessage.repaint();
		scrlMessage.revalidate();
//		this.switchBullet();
//		float percent = (float)this.player.getMaxHealth()/(float)this.player.getHealth();
//		this.lblHealth.setSize(Math.round(this.getMaxHealthWidth()/percent), lblHealth.getHeight()); 
//		
//		percent = (float)this.player.getMaxMagic()/(float)this.player.getMagic();
//		this.lblMagic.setSize(Math.round(this.getMaxMagicWidth()/percent), lblMagic.getHeight()); 
	}
	
//	public void switchBullet() {
//		this.deselectAll();
//		switch(this.player.getShotType()) {
//			case 0:
//				this.lblBullet1.setIcon(this.iiBullet1On);
//				break;
//			case 1:
//				this.lblBullet2.setIcon(this.iiBullet2On);
//				break;
//			case 2:
//				this.lblBullet3.setIcon(this.iiBullet3On);
//				break;
//			case 3:
//				this.lblBullet4.setIcon(this.iiBullet4On);
//				break;
//		}
//	}
	
//	public void deselectAll() {
////		this.lblBullet1.setIcon(this.iiBullet1Off);
////		this.lblBullet2.setIcon(this.iiBullet2Off);
////		this.lblBullet3.setIcon(this.iiBullet3Off);
////		this.lblBullet4.setIcon(this.iiBullet4Off);
//		
//		this.lblBullet1.setIcon(this.iiBullet1Able);
//		this.lblBullet2.setIcon(this.iiBullet2Able);
//		this.lblBullet3.setIcon(this.iiBullet3Able);
//		this.lblBullet4.setIcon(this.iiBullet4Able);
//	}
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}
	
//	public int getMaxHealthWidth() {
//		return this.lblHealthBar.getWidth();
//	}
//	public int getMaxMagicWidth() {
//		return this.lblMagicBar.getWidth();
//	}

	public JTextArea getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(JTextArea lblMessage) {
		this.lblMessage = lblMessage;
	}

	public void addMsgQueue(String message){
		this.messageQueue.add(message);
	}

	public void clearMsgQueue(){
		this.messageQueue.clear();
	}
}
