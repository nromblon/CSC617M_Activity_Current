package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BedroomCloset extends InteractableObject{
	
	public BedroomCloset() {
		super(new String[]{"Closet","wardrobe"});
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
		
		this.iX = 150;
		this.iY = 385;
		
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
		this.parent.updateMessage("All the drawers of closet is locked. However, there is a shirt hanged inside it.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("The drawers are locked.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I can't close what has not been opened.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I think this is too heavy to carry around.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't know what you're talking about.");
	}

}
