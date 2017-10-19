package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Flask extends InteractableObject{
	
	public Flask() {
		super(new String[]{"flask","science bottle","potion","volumetric flask"});

		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {

		this.setTarget(null);

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 164;
		this.iY = 478;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
//		this.iiUsed = new ImageIcon("images/"+this.objectName+"_used.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.parent.updateMessage("A flask. Usually used for containing harmful liquids.");
		}else
			this.parent.updateMessage("...");
	}

	@Override
	public void open() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.parent.updateMessage("I don't think that's possible.");
		}else
			this.parent.updateMessage("...");
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.parent.updateMessage("I don't think that's possible.");
		}else
			this.parent.updateMessage("...");
	}
	@Override
	public void update() {
	}

	@Override
	public void take() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			if(!isTaken() &&
					this.getParent().lookupObject("FridgeDoor").isOpened()) {
				this.setTaken(true);
				this.getParent().getParent().getInventory().addItem(this, "Used for holding potentially harmful chemicals.");
				this.lblObject.setVisible(false);
				this.getParent().updateMessage("This could probably come in handy.");
			}
			else
				this.parent.updateMessage("I already took the flask.");
		}else
			this.parent.updateMessage("...");
	}
	@Override
	public void use() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.parent.updateMessage("How should I use it?");
		}else
			this.parent.updateMessage("...");
	}

}
