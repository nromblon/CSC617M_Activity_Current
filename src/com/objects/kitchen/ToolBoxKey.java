package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class ToolBoxKey extends InteractableObject{
	
	public ToolBoxKey() {
		super(new String[]{"key", "tool box key", "toolbox key", "silver key", "grey key", "gray key"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setTaken(false);
		this.setTarget(null);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 279;
		this.iY = 296;
		
		this.setX(iX);
		this.setY(iY);

		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(isTaken)
			this.getParent().updateMessage("Looks like a key, for opening things.");
		else
			this.parent.updateMessage("What key?");
	}

	@Override
	public void open() {
		this.getParent().updateMessage("I don't know what you're talking about.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("I don't know what you're talking about.");
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		if(parent.lookupObject("Goblet").isViewed()) {
			if (!this.isTaken()) {
				this.setTaken(true);
				this.getParent().getParent().getInventory().addItem(this, "A key with a picture of a toolbox on the tag.");
				this.lblObject.setVisible(false);
				this.getParent().updateMessage("I took the key.");
			} else
				this.getParent().updateMessage("I already took the key.");
		}
		else
			this.parent.updateMessage("What key?");
	}
	@Override
	public void use() {
		if(isTaken)
			this.getParent().updateMessage("I should try opening random objects with this.");
		else
			this.parent.updateMessage("What key?");
	}

}
