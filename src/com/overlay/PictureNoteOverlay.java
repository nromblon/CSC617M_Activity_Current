package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;

public class PictureNoteOverlay extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	
	
	public PictureNoteOverlay(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		

		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_picturenote.png"), null);
	}
	
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		super.mouseReleased(e);
	}
}
