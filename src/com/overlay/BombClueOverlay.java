package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

import world.GameWorld;

public class BombClueOverlay extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	private boolean isRight;
	
	public BombClueOverlay(GameWorld parent, Character player, boolean isRight) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.isRight = isRight;
		this.initComponents();
		
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		

		this.lblOverlay = new JLabel();
		if(this.isRight)
			Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_right.png"), null);
		else
			Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_left.png"), null);
		
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
	}
}
