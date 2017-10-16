package com.elements;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.GameWorld;

public class Instructions extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private GameWorld parent;
	
	private JButton btnHowTo;
	private JLabel overlayHowTo;
	
	public Instructions(GameWorld parent) {
		this.parent = parent;
		
		this.initComponents();
		Game.initPanel(this, Game.clrTransparent, Stage.MAX_WIDTH, 0, parent.getWidth()-Stage.MAX_WIDTH, parent.getHeight());	
		
		this.add(btnHowTo);
		this.setVisible(true);
	}
	
	public void initComponents() {
		this.setLayout(new FlowLayout());
		
		this.btnHowTo = new JButton();
		Game.initButtons(this.btnHowTo, "how2play", 124, 550, true, this);
//		this.btnHowTo.setOpaque(false);
//		this.btnHowTo.setContentAreaFilled(false);
		
		this.overlayHowTo = new JLabel();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
