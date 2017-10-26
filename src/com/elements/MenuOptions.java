package com.elements;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import world.GameWorld;

public class MenuOptions extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private GameWorld parent;
	
	private JLabel line1;
	private JButton btnHowTo;

	private JLabel line2;
	private JButton btnExit;
	private JLabel line3;
	
	public MenuOptions(GameWorld parent) {
		this.parent = parent;
		
		this.initComponents();
		Game.initPanel(this, Game.clrTransparent, Stage.MAX_WIDTH, 0, parent.getWidth()-Stage.MAX_WIDTH, parent.getHeight());	
		
		this.add(line1);
		this.add(btnHowTo);
		this.add(line2);
		this.add(btnExit);
		this.add(line3);
		
		this.setVisible(true);
	}
	
	public void initComponents() {
		this.setLayout(new FlowLayout());
		
		this.line1 = new JLabel();
		Game.initLabels(line1, "lineSeparator", null);
		this.line1.setLocation(0, 600);
		
		this.btnHowTo = new JButton();
		Game.initButtons(this.btnHowTo, "how2play", 0, this.line1.getY() + this.line1.getHeight(), true, this);

		this.line2 = new JLabel();
		Game.initLabels(line2, "lineSeparator", null);
		this.line2.setLocation(0, btnHowTo.getY() + btnHowTo.getHeight());
		
		this.btnExit = new JButton();
		Game.initButtons(btnExit, "btnExit", 0, this.line2.getY() + this.line2.getHeight(), true, this);
		
		this.line3 = new JLabel();
		Game.initLabels(line3, "lineSeparator", null);
		this.line3.setLocation(0, btnExit.getY() + btnExit.getHeight());
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource().equals(btnExit)) {
			System.exit(1);
		} else if(arg0.getSource().equals(btnHowTo)) {
			this.parent.openHow2PlayOverlay();
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

}
