package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Fridge extends InteractableObject{
	
	public Fridge() {
		super(new String[]{"fridge","refrigerator","freezer"});
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
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(!this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.parent.updateMessage("A normal fridge. I wonder what's inside...");
		}
		else{
			this.parent.updateMessage("There's an apple, a soda can, cheese, a water bottle, a flask, and some strawberry jam.");
		}
	}

	@Override
	public void open() {
		if(!this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.getParent().lookupObject("FridgeDoor").open();
		}
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.getParent().lookupObject("FridgeDoor").close();
		}
		
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't carry something that heavy...");
	}
	@Override
	public void use() {
		if(!this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.getParent().lookupObject("FridgeDoor").open();
		}
		else{
			this.getParent().lookupObject("FridgeDoor").close();
		}
	}

}
