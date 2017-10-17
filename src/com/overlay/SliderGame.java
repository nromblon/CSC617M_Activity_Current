package com.overlay;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.characters.Character;
import com.elements.Game;
import com.elements.Stage;
import com.slider.SliderPanel;

import world.GameWorld;

public class SliderGame extends OverlayObject {
	private static final long serialVersionUID = 1L;
	
	private SliderPanel pnlSlider;

	private GameWorld parent;
	
	public SliderGame(GameWorld parent, Character player) {
		this.parent = parent;
		this.player = player;
		Game.initPanel(this, Game.clrTransparent, 0, 0, Stage.MAX_WIDTH, Game.MAX_HEIGHT);
		
		this.initComponents();
		
		this.add(pnlSlider.getUI());
		this.add(lblOverlay);
		this.close();
	}
	
	private void initComponents() {		
		this.pnlSlider = new SliderPanel(this);
		int size = 400;
		pnlSlider.getUI().setBounds((Stage.MAX_WIDTH-size)/2, (Stage.MAX_HEIGHT-size)/2, size, size);
		
		this.lblOverlay = new JLabel();
		Game.initLabels(this.lblOverlay, new ImageIcon("images/bg_overlay.png"), null);
	}
	
	public GameWorld getParent() {
		return parent;
	}

	public void setParent(GameWorld parent) {
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
	}
}
