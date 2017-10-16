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

//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("The vault is locked with a 4-digit code.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I need to unlock it by entering the PIN code");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't know what you're talking about.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(parent.lookupObject("TopDrawer").isOpened()) {
			if(!this.isTaken) {
				this.getParent().getParent().getInventory().addItem(this);
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
		//TODO: open overlay
	}

}
