package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

import world.GameWorld;

public class BathroomNoteOverlay extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	
	public BathroomNoteOverlay(GameWorld parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		

		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_bathroomnote.png"), null);
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
