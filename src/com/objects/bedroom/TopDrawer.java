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
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
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
				parent.updateMessage(this.openResponse+" Used the key.");
				this.getParent().getParent().getInventory().removeItem(parent.lookupObject("Key"));
			}
			else {
				parent.updateMessage(this.openResponse);
			}
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
