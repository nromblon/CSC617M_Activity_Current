package com.characters;

import javax.swing.ImageIcon;
import com.elements.Game;

public class Player extends Character {
	
	public Player() {
		super();
		this.initComponents();
	}
	private void initComponents() {
		this.name = this.getClass().getSimpleName();
		Game.initLabels(lblCharacter, this.name+"_R0", null);
		
		this.iiMovLeft = new ImageIcon("images/"+this.name+"_L0.png");
		this.iiMovRight = new ImageIcon("images/"+this.name+"_R0.png");
		
		this.setCenterX(this.lblCharacter.getWidth()/2);
		this.setCenterY(this.lblCharacter.getHeight()/2);
		this.setMaxJumpHeight(this.lblCharacter.getHeight()/2);
	}
}
