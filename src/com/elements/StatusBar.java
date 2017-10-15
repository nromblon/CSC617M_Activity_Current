package com.elements;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.characters.Character;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel parent;

	private Character owner;
	private JLabel lblHealthBar;
	private JLabel lblHealth;

	private JLabel lblMagicBar;
	private JLabel lblMagic;
	
	private int padding;
	
	public StatusBar(JPanel parent, Character owner) {
		this.parent = parent;
		this.setOwner(owner);
		Game.initPanel(this, Game.clrBlack70, 0, 0, 70, 30);	
		this.initComponents();
		
		this.add(lblHealthBar);
		this.add(lblMagicBar);
	}
	
	private void initComponents() {
		this.padding = 1;
		
		this.lblHealthBar = new JLabel();
		Game.initLabel(this.lblHealthBar, Game.fntGothamLight12, Color.WHITE, 0, 0, 70, 10);
		
		this.lblHealth = new JLabel();
		Game.initLabel(this.lblHealth, Game.fntGothamLight12, Color.RED, this.padding, this.padding, lblHealthBar.getWidth()-(this.padding*2), lblHealthBar.getHeight()-(this.padding*2));
		
		this.lblHealthBar.add(lblHealth);

		
		
		this.lblMagicBar = new JLabel();
		Game.initLabel(this.lblMagicBar, Game.fntGothamLight12, Color.WHITE, 10, lblHealthBar.getY()+lblHealthBar.getHeight()+10, 70, lblHealthBar.getHeight()/2);
		
		this.lblMagic = new JLabel();
		Game.initLabel(this.lblMagic, Game.fntGothamLight12, Color.BLUE, this.padding, this.padding, lblMagicBar.getWidth()-(this.padding*2), lblMagicBar.getHeight()-(this.padding*2));

		this.lblMagicBar.add(lblMagic);
	}
	
	public void update() {
//		float percent = (float)this.owner.getMaxHealth()/(float)this.owner.getHealth();
//		this.lblHealth.setSize((int)(this.getMaxHealthWidth()/percent), lblHealth.getHeight()); 

//		percent = (float)this.owner.getMaxMagic()/(float)this.owner.getMagic();
//		this.lblMagic.setSize((int)(this.getMaxMagicWidth()/percent), lblMagic.getHeight()); 
		
		this.setLocation(owner.getLblCharacter().getX()+owner.getLblCharacter().getWidth()/2-this.getWidth()/2, owner.getLblCharacter().getY()-this.getHeight());
		
	}
	

	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}
	
	public int getMaxHealthWidth() {
		return this.lblHealthBar.getWidth()-(this.padding*2);
	}
	public int getMaxMagicWidth() {
		return this.lblMagicBar.getWidth()-(this.padding*2);
	}

	public Character getOwner() {
		return owner;
	}

	public void setOwner(Character owner) {
		this.owner = owner;
	}
}
