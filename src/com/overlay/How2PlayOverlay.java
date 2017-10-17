package com.overlay;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import world.GameWorld;
import com.characters.Character;

public class How2PlayOverlay extends OverlayObject{
	private static final long serialVersionUID = 1L;

	public How2PlayOverlay(GameWorld parent, Character player) {
		this.parent = parent;
		this.player = player;
		
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {
		this.lblOverlay = new JLabel();
		Game.initLabels(lblOverlay, "bg_how2play", this);
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

}
