package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BathroomShelf extends InteractableObject{
	
	public BathroomShelf() {
		super(new String[]{"shelf","counter"});
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
		
		this.iX = 614;
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
		this.parent.updateMessage("The shelf has three bottles with flower labels on it. I believe the flowers portrayed on the labels are Rose, Daisy, and Lotus.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't know what you mean.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't know what you mean.");
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
		this.parent.updateMessage("??");
	}

}
