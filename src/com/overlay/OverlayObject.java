package com.overlay;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.characters.Character;
import com.elements.Game;

import world.GameWorld;

public abstract class OverlayObject extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;

	protected JButton btnClose;
	protected GameWorld parent;
	protected Character player;
	protected JLabel lblOverlay;
	
	public OverlayObject() {
		this.btnClose = new JButton();
		Game.initButtons(btnClose, "btnClose", 959, 21, true, this);
		this.add(btnClose);
	}
	
	public void open() {
		player.setIsInOverlay(true);
		this.setVisible(true);
	}
	
	public void close() {
		player.setIsInOverlay(false);
		this.setVisible(false);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == this.btnClose) {
			this.close();
		}
	}

	public GameWorld getParent() {
		return parent;
	}

	public void setParent(GameWorld parent) {
		this.parent = parent;
	}
}
