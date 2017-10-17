package com.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.characters.Player;
import com.elements.Game;

import world.Room;

public class MainMenu extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private JFrame parent;
	private boolean isReady;
	
	private JLabel gameTitle;
	private JButton btnStart;
	private Timer tmrFocus;


	public MainMenu(JFrame parent) {
		this.parent = parent;
		this.initComponents();		

		this.add(btnStart);
		this.add(gameTitle);
		
		this.parent.revalidate();
		this.parent.repaint();
		
		this.isReady = false;

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
	
	public void start() {
		this.tmrFocus.stop();
		this.addPlayer();
		this.parent.remove(this);
	}
	
	public boolean randomSolution() {
		Random random = new Random();
		boolean randomWire = random.nextBoolean();
		return randomWire;
	}
	
	public void addPlayer() {
		boolean solution = randomSolution();
		this.parent.add(new Room(parent, new Player(), solution));
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.btnStart) {
			this.start();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private class TAdapter extends KeyAdapter {	
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER) {
				isReady = true;
			}	
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		requestFocus();
		if(isReady)
			this.start();
	}
}
