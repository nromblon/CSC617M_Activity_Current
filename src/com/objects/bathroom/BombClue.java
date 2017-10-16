package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BombClue extends InteractableObject{
	
	public BombClue() {
		super(new String[]{"bomb clue", "letter", "clue"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {
		
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 268;
		this.iY = 415;
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiDefault = new ImageIcon("images/"+this.objectName+"_default.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
	
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().getParent().openOverlayNote();
	}

	@Override
	public void open() {
	}

	@Override
	public void close() {
		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {

	}
	@Override
	public void use() {
	}

}
