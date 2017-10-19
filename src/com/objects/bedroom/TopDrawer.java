package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class TopDrawer extends InteractableObject{
	
	public TopDrawer() {
		super(new String[]{"top drawer","top compartment","upper drawer","upper compartment","first drawer","first compartment",
				"1st drawer","1st compartment","higher drawer"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The top drawer is locked.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 683;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.isOpened)
			parent.updateMessage("It's unlocked");
		else
			parent.updateMessage("It's locked");
	}

	@Override
	public void open() {
		
		if(this.isOpened) {
			if(parent.lookupObject("Vault").isTaken())
				parent.updateMessage("It's empty.");
			else {
				parent.updateMessage("There's a small vault inside. Should I take it?");
			}
		}
		else {
			if(parent.lookupObject("Key").isTaken()) {
				this.setOpened(true);
				parent.updateMessage(this.openResponse+" Used the key. There's a small vault inside.");
				this.getParent().getParent().getInventory().removeItem(parent.lookupObject("Key"));
				parent.lookupObject("Vault").setTarget(parent.lookupObject("Vault"));
			}
			else {
				parent.updateMessage(this.openResponse);
			}
		}
	}

	@Override
	public void close() {
		this.parent.updateMessage("I might lock it again if I close it.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't do that.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("You mean 'open'?");
	}

}
