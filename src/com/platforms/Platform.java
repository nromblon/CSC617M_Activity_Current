package com.platforms;

import javax.swing.JLabel;

import com.elements.Game;

public class Platform {
	private int x;
	private int y;
	private boolean isPassable;
	private JLabel lblPlatform;
	
	
	public Platform(int x, int y, int width, int height, boolean isPassable) {
		this.x = x;
		this.y = y;
		this.isPassable = isPassable;
		this.lblPlatform = new JLabel();
		if(!isPassable)
			Game.initLabel(this.lblPlatform, Game.fntGothamLight12, Game.clrTransparent, x, y, width, height);
	}

	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isPassable() {
		return isPassable;
	}

	public void setPassable(boolean isPassable) {
		this.isPassable = isPassable;
	}

	public JLabel getLblPlatform() {
		return lblPlatform;
	}

	public void setLblPlatform(JLabel lblPlatform) {
		this.lblPlatform = lblPlatform;
	}
}
