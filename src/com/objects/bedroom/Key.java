package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Key extends InteractableObject{
	
	public Key() {
		super(new String[]{"key"});
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
		
		this.iX = 910;
		this.iY = 607;
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiDefault = new ImageIcon("images/"+this.objectName+"_default.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		this.iiTaken = new ImageIcon("images/"+this.objectName+"_taken.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("A key is hidden inside the floor.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("A key is used to open things, I don't think a key can open itself.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("What?");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(getParent().lookupObject("Floorboard").isTaken()) {
			if (!isTaken()) {
				this.setTaken(true);
				this.getParent().getParent().getInventory().addItem(this, "For opening something locked");
				this.lblObject.setIcon(this.iiTaken);
				this.parent.updateMessage("I took the key.");
			} else
				this.parent.updateMessage("I already took the key.");
		}
		else
			this.parent.updateMessage("What key?");
	}
	@Override
	public void use() {
		if(isTaken)
			this.parent.updateMessage("Maybe this key could open the locked top drawer?");
		else
			this.parent.updateMessage("I need to take the key first.");
	}

}
