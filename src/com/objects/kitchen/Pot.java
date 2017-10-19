package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Pot extends InteractableObject{
	
	public Pot() {
		super(new String[]{"pot", "casserole"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setUsed(false);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 473;
		this.iY = 390;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(isUsed)
			this.parent.updateMessage("It reeks of acid.");
		else
			this.parent.updateMessage("I could cook something with this...");
	}

	@Override
	public void open() {
		if(isUsed)
			this.parent.updateMessage("I probably shouldn't touch that.");
		else
			this.parent.updateMessage("It's empty.");
	}

	@Override
	public void close() {
		if(isUsed)
			this.parent.updateMessage("I probably shouldn't touch that");
		else
			this.parent.updateMessage("It's already closed.");
		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't think it's productive to carry that around.");
		
	}
	@Override
	public void use() {
		if(this.getParent().getParent().getInventory().searchIfItemExists("Wrench") &&
				this.getParent().getParent().getInventory().searchIfItemExists("CarBattery") &&
				this.getParent().getParent().getInventory().searchIfItemExists("AcidRecipe") &&
				!this.getParent().getParent().getInventory().searchIfItemExists("Flask")) {
			this.getParent().updateMessage("I can make sulfuric acid with this, but I'll need something to put it in.");

		}
		else if(!this.isUsed() &&
				this.getParent().getParent().getInventory().searchIfItemExists("Wrench") &&
				this.getParent().getParent().getInventory().searchIfItemExists("CarBattery") &&
				this.getParent().getParent().getInventory().searchIfItemExists("AcidRecipe") &&
				this.getParent().getParent().getInventory().searchIfItemExists("Flask")) {
			this.getParent().updateMessage("I poured the battery fluid in the pot. Now all I have to do is heat it up.");
			
			this.getParent().getParent().getInventory().removeItem("CarBattery");
			this.setUsed(true);
		}
		else if(this.isUsed() && 
				!this.getParent().getParent().getInventory().searchIfItemExists("SulfuricAcid")) {
			this.getParent().updateMessage("All that's left is to heat it up.");
			
		}
		else {
			this.getParent().updateMessage("What am I supposed to use this with?");
		}
	}
}
