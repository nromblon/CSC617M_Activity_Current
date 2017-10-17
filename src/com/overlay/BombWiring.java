package com.overlay;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

import world.GameWorld;

public class BombWiring extends OverlayObject {
	private static final long serialVersionUID = 1L;
	

	private JButton btnCutRight;
	private JButton btnCutLeft;
	
	private boolean isRight;
	
	public BombWiring(GameWorld parent, Character player, boolean isRight) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(btnCutRight);
		this.add(btnCutLeft);
		this.add(lblOverlay);
		
		this.isRight = isRight;
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
			if(isRight)
				((GameWorld) this.parent).endWorld(true);
			else
				((GameWorld) this.parent).endWorld(false);
			this.close();
		}
		if(e.getSource() == this.btnCutLeft) {
			if(isRight)
				((GameWorld) this.parent).endWorld(false);
			else
				((GameWorld) this.parent).endWorld(true);
			this.close();
		}
	}
}
