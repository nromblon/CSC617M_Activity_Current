package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class CoffeePot extends InteractableObject{
	
	public CoffeePot() {
		super(new String[]{"coffee pot"});
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
		
		this.iX = 927;
		this.iY = 433;
		
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
		this.getParent().updateMessage("A coffee pot. The coffee inside looks old.");
	}

	@Override
	public void open() {
		this.getParent().updateMessage("I opened it and it smells terrible. I should leave it closed.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("I should leave it closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.getParent().updateMessage("Nahh...");
	}
	@Override
	public void use() {
		this.getParent().updateMessage("I bet it tastes horrible.");
	}

}
