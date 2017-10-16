package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Floorboard extends InteractableObject{
	
	public Floorboard() {
		super(new String[]{"floor panel","floor","floor board","floorboard","board"});
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
		
		this.iX = 860;
		this.iY = 603;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
		this.iiTaken = new ImageIcon("images/"+this.objectName+"_taken.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("I think it's possible to take this floorboard.");
	}

	@Override
	public void open() {
		this.lblObject.setIcon(this.iiTaken);
		this.setTaken(true);
		this.parent.updateMessage("The floorboard lifted off nicely.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("It's already closed.");
		if(this.isTaken)
			this.parent.updateMessage("I don't see the significance of that.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(!isTaken) {
			this.lblObject.setIcon(this.iiTaken);
			this.setTaken(true);
			this.parent.updateMessage("The floorboard lifted off nicely.");
		}
		else
			this.parent.updateMessage("I already took the floorboard off.");
	}
	@Override
	public void use() {
		if(!isTaken) {
			this.lblObject.setIcon(this.iiTaken);
			this.setTaken(true);
			this.parent.updateMessage("The floorboard lifted off nicely.");
		}
		else
			this.parent.updateMessage("I already took the floorboard off.");
	}

}
