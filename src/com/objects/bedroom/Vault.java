package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Vault extends InteractableObject{
	
	public Vault() {
		super(new String[]{"vault"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.target = null;
	}
	private void initComponents() {
		
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();

		this.lblObject.setVisible(false);
		Game.initLabels(lblObject, "TopDrawer_default", null);
		
		this.iX = 683;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");

		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(parent.lookupObject("TopDrawer").isOpened())
			this.parent.updateMessage("The vault is locked with a 4-digit code.");
		else
			this.parent.updateMessage("What vault?");
	}

	@Override
	public void open() {
		if(parent.lookupObject("TopDrawer").isOpened())
			this.parent.updateMessage("I need to unlock it by entering the PIN code");
		else
			this.parent.updateMessage("What vault?");
	}

	@Override
	public void close() {
		if(parent.lookupObject("TopDrawer").isOpened())
			this.parent.updateMessage("I don't know what you're talking about.");
		else
			this.parent.updateMessage("What vault?");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(parent.lookupObject("TopDrawer").isOpened()) {
			if(!this.isTaken) {
				this.getParent().getParent().getInventory().addItem(this, "It has 4-digit PIN code.");
				this.setTaken(true);
				this.parent.updateMessage("I took the vault.");
			}
			else
				this.parent.updateMessage("I already took the vault");
		}
		else
			this.parent.updateMessage("What vault?");
	}
	@Override
	public void use() {
		if(parent.lookupObject("TopDrawer").isOpened()) {
			if(isTaken)
				parent.getParent().openOverlayVault();
			else
				parent.updateMessage("I should take it first.");
		}
		else{
			parent.updateMessage("What vault?");
		}

	}

}
