package com.elements;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class OverlayObject extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;

	protected JButton btnClose;
	
	
	public OverlayObject() {
		this.btnClose = new JButton();
		Game.initButtons(btnClose, "btnClose", 959, 21, true, this);
		this.add(btnClose);
	}
	
	public void open() {
		this.setVisible(true);
	}
	
	public void close() {
		this.setVisible(false);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == this.btnClose) {
			this.close();
		}
	}
}
