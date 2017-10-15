package com.slider;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile {
	
	private JButton btnTile;
	private boolean isFree;
	private int x;
	private int y;
	
	public Tile(ImageIcon icon, boolean isFree, int x, int y) {
		this.btnTile = new JButton(icon);
		this.btnTile.setPreferredSize(new Dimension(100, 100));
		this.btnTile.setFocusPainted(false);
		this.btnTile.setContentAreaFilled(false);
		
		this.setIsFree(isFree);
		
		this.setX(x);
		this.setY(y);
	}
	
	public JButton getBtnTile() {
		return this.btnTile;
	}
	
	public void setBtnTile(JButton btnTile) {
		this.btnTile = btnTile;
	}
	
	public boolean isFree() {
		return this.isFree;
	}
	
	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
