package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;
import com.slider.SliderPanel;

public class SliderGame extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	private SliderPanel pnlSlider;
	
	public SliderGame(JPanel parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(pnlSlider.getUI());
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		
		this.pnlSlider = new SliderPanel();
		int size = 400;
		pnlSlider.getUI().setBounds((Stage.MAX_WIDTH-size)/2, (Stage.MAX_HEIGHT-size)/2, size, size);
		
		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_overlay.png"), null);
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
