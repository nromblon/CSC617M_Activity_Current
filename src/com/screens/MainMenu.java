package com.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.characters.Player;
import com.elements.Game;
import com.frame.Frame;

import world.Room;

public class MainMenu extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private JFrame parent;
	private MapSelect mapSelect;
	
	private boolean isSet;
	private boolean isReady;
	private boolean isEscape;
	
	private int selectedChara;
	private int selectedClass;
	
	private JLabel gameTitle;
	private JLabel startPrompt;
	
	private JButton btnStart;
	private Timer tmrFocus;


	public MainMenu(JFrame parent) {
		this.parent = parent;
		this.initComponents();		

//		this.add(this.mapSelect);
		this.add(btnStart);
		this.add(gameTitle);
//		this.add(startPrompt);
		
		this.parent.revalidate();
		this.parent.repaint();
		
		this.selectedChara = 1;
		this.selectedClass = 1;
		this.select(this.selectedChara);
		
		this.isSet = false;
		this.isReady = false;
		this.isEscape = false;

		this.tmrFocus = new Timer(0, this);
		this.tmrFocus.start();
	}
	
	public void initComponents() {
		Game.initPanel(this, Color.BLACK, 0, 0, Game.MAX_WIDTH, Game.MAX_WIDTH);
		
		this.btnStart = new JButton();
		Game.initButtons(this.btnStart, "startbtn", 0, 0, true, this);
		this.btnStart.setBounds(600, 600, btnStart.getWidth(), btnStart.getHeight());
		this.btnStart.setOpaque(false);
		this.btnStart.setContentAreaFilled(false);
		
		this.gameTitle = new JLabel();
		Game.initLabels(gameTitle, "Game_title", null);
		
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(new TAdapter());
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor( getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	public void selectClass(int selected) {
		this.deselectAllClass();		
		
		this.repaint();
	}
	
	public void deselectAllClass() {

	}
	
	public void select(int selected) {

		Game.M.play("SE1.wav", 0);
		this.deselectAll();
		this.selectedClass = 1;
	
		this.selectedChara = selected;
//		this.lblClass.setText(this.lblName.getText());
		this.selectClass(1);
		this.repaint();
//		Game.M.stop();
//		Game.M.play("SE1.wav", 1);
	}
	
	public void deselectAll() {
	}
	
	public void start() {
//		this.mapSelect.setVisible(true);

		this.tmrFocus.stop();
		this.addPlayer();
		this.parent.remove(this);
	}
	
	public void addPlayer() {
		this.parent.add(new Room(parent, new Player()));
	}	
	
	public void toSplash() {
//		this.setVisible(false);
		this.tmrFocus.stop();
		this.parent.add(new Splash(parent));
		this.parent.remove(this);
		this.parent.repaint();
		this.parent.revalidate();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.btnStart) {
			this.start();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		if(e.getSource() == this.btnChara1 ||
//				e.getSource() == this.btnChara2 ||
//				e.getSource() == this.btnChara3 ||
//				e.getSource() == this.btnChara4 ||
//				e.getSource() == this.btnChara5 ||
//				e.getSource() == this.btnChara6 ||
//				e.getSource() == this.btnChara7 ||
//				e.getSource() == this.btnChara8 ||
//				e.getSource() == this.btnChara9 ||
//				e.getSource() == this.btnChara10 ||
//				e.getSource() == this.btnChara11 ||
//				e.getSource() == this.btnChara12 ||
//				e.getSource() == this.btnClass1 ||
//				e.getSource() == this.btnClass2 ||
//				e.getSource() == this.btnClass3) {
//			Game.M.stopSound();
//			Game.M.sound("SE1.wav", Clip.LOOP_CONTINUOUSLY);
//			Game.M.play("SE1.wav", 0);
//		}
	}
	
	private class TAdapter extends KeyAdapter {	
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				isEscape = true;
			}
			else {
				if(!isSet) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						setSelectedChara(selectedChara-3);
						break;
					case KeyEvent.VK_DOWN:
						setSelectedChara(selectedChara+3);
						break;
					case KeyEvent.VK_LEFT:
						setSelectedChara(selectedChara-1);
						break;
					case KeyEvent.VK_RIGHT:
						setSelectedChara(selectedChara+1);
						break;
					case KeyEvent.VK_Z:
						isSet = true;
						break;
					}		
				}
				else if(!isReady) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						setSelectedClass(selectedClass-1);
						break;
					case KeyEvent.VK_DOWN:
						setSelectedClass(selectedClass+1);
						break;
					case KeyEvent.VK_LEFT:
						setSelectedClass(selectedClass-1);
						break;
					case KeyEvent.VK_RIGHT:
						setSelectedClass(selectedClass+1);
						break;
					case KeyEvent.VK_X:
						isSet = false;
						break;
					case KeyEvent.VK_Z:
						isReady = true;
						break;
					}	
				}
				else {
					switch(e.getKeyCode()) {
					case KeyEvent.VK_X:
						isReady = false;
						break;
					}
				}	
			}			
		}		
	}

	public int getSelectedChara() {
		return selectedChara;
	}
	
	public void setSelectedChara(int selectedChara) {
		if(selectedChara < 1)
			selectedChara = 1;
		if(selectedChara > 11)
			selectedChara = 11;
		this.selectedChara = selectedChara;
		
		this.selectedChara = selectedChara;
		this.select(this.selectedChara);
	}
	
	public int getSelectedClass() {
		return selectedClass;
	}
	
	public void setSelectedClass(int selectedClass) {
		this.selectedClass = selectedClass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		requestFocus();
		if(isReady)
			this.start();
		if(isEscape) {
			this.toSplash();
		}
	}
}
