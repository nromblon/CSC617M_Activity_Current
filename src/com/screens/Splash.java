package com.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.elements.Game;

public class Splash extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JFrame parent;
	private JButton btnClose;
	private JButton btnStart;
	
	public Splash(JFrame parent) {
		this.parent = parent;
		
		Game.initPanel(this, Color.DARK_GRAY, 0, 0, Game.MAX_WIDTH, Game.MAX_HEIGHT);
		this.initComponents();
		
		this.add(btnClose);
		this.add(btnStart);
		
		this.setVisible(true);
	}

	public void startGame() {
		this.parent.add(new MainMenu(this.parent));
		this.parent.remove(this);
		this.parent.repaint();
		this.parent.revalidate();
	}
	
	private void initComponents() {		
		this.btnClose = new JButton("X");
		Game.initButtons(btnClose, Color.RED, this.getWidth()-50, 0, 50, 50, this);
		
		this.btnStart = new JButton("ARCADE");
		Game.initButtons(btnStart, Color.GRAY, (this.getWidth()-300)/2, this.getHeight()-200, 300, 50, this);
		btnStart.setFont(Game.fntGothamLight20);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor( getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.btnStart) {
			this.startGame();
		}
		if(e.getSource() == this.btnClose) {
			System.exit(0);
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
		// TODO Auto-generated method stub
		
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}
}
