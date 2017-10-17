package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class FridgeDoor extends InteractableObject{
	
	public FridgeDoor() {
		super(new String[]{"fridge", "fridge door"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		
		this.setOpened(false);
	}
	private void initComponents() {

		
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 45;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
		this.iiClosed = new ImageIcon("images/"+this.objectName+"_default.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {

	}

	@Override
	public void open() {
		if(!this.isOpened()) {
			this.setOpened(true);
			this.lblObject.setVisible(false);
			this.parent.updateMessage("I have opened the fridge door.");
			this.parent.lookupObject("Apple").setTarget(parent.lookupObject("Apple"));
			this.parent.lookupObject("Cheese").setTarget(parent.lookupObject("Cheese"));
			this.parent.lookupObject("Can").setTarget(parent.lookupObject("Can"));
			this.parent.lookupObject("WaterBottle").setTarget(parent.lookupObject("WaterBottle"));
			this.parent.lookupObject("Flask").setTarget(parent.lookupObject("Flask"));
			this.parent.lookupObject("StrawberryJam").setTarget(parent.lookupObject("StrawberryJam"));
		}
		else
			this.parent.updateMessage("It is already opened.");
	}

	@Override
	public void close() {
		if(this.isOpened()) {
			this.setOpened(false);
			this.lblObject.setVisible(true);
			this.parent.updateMessage("I've closed the fridge door. Gotta save energy");
			this.parent.lookupObject("Apple").setTarget(parent.lookupObject(null));
			this.parent.lookupObject("Cheese").setTarget(parent.lookupObject(null));
			this.parent.lookupObject("Can").setTarget(parent.lookupObject(null));
			this.parent.lookupObject("WaterBottle").setTarget(parent.lookupObject(null));
			this.parent.lookupObject("Flask").setTarget(parent.lookupObject(null));
			this.parent.lookupObject("StrawberryJam").setTarget(parent.lookupObject(null));
		}
		else
			this.parent.updateMessage("It is already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't think I'll ever need to carry around a fridge door");
		
	}
	@Override
	public void use() {
		if(this.isOpened()) {
			this.setOpened(false);
			this.lblObject.setVisible(true);
			this.parent.updateMessage("I've closed the fridge door. Gotta save energy");
		}
		else{
			this.setOpened(true);
			this.lblObject.setVisible(false);
			this.parent.updateMessage("I have opened the fridge door.");
		}
	}

}
