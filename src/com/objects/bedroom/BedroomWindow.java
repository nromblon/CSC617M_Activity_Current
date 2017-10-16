package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BedroomWindow extends InteractableObject{
	
	public BedroomWindow() {
		super(new String[]{"window"});
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
		
		this.iX = 794;
		this.iY = 227;
		
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
		this.parent.updateMessage("I can see grass from here.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("The window is jammed.");
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
		this.parent.updateMessage("I don't think that's a right decision.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("The window is jammed.");
	}

}
