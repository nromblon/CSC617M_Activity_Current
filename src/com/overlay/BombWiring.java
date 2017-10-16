package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

public class BombWiring extends OverlayObject {
	private static final long serialVersionUID = 1L;
	

	private JButton btnCutRight;
	private JButton btnCutLeft;
	
	public BombWiring(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(btnCutRight);
		this.add(btnCutLeft);
		this.add(lblOverlay);

		this.close();
	}
	
	private void initComponents() {		
		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_bombwiring.png"), null);

		this.btnCutLeft = new JButton();
		Game.initButtons(btnCutLeft, "btnCutLeft", 142, 290, true, this);
		
		this.btnCutRight = new JButton();
		Game.initButtons(btnCutRight, "btnCutRight", 846, 290, true, this);
	
	}
	
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		super.mouseReleased(e);
		if(e.getSource() == this.btnCutRight) {
			//TODO Check Call Parent
			this.close();
		}
		if(e.getSource() == this.btnCutLeft) {
			//TODO Check Call Parent
			this.close();
		}
	}
}
