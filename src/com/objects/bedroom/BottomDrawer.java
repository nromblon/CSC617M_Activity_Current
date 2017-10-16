package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class BottomDrawer extends InteractableObject{
	
	public BottomDrawer() {
		super(new String[]{"lower drawer","lower compartment","bottom drawer","bottom compartment",
				"2nd Drawer","2nd compartment","second drawer","second compartment"});
		this.viewResponse = "The "+this.objectName+".";
		this.openResponse = "It's empty.";
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
		this.parent.updateMessage("This drawer is unlocked.");
	}

	@Override
	public void open() {
		this.parent.updateMessage(this.openResponse);
	}

	@Override
	public void close() {
		this.parent.updateMessage("It is already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't think I'll gain anything from that.");
	}
	@Override
	public void use() {
		this.parent.updateMessage(this.openResponse);
	}

}
