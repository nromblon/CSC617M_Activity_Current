package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class WaterBottle extends InteractableObject{
	
	public WaterBottle() {
		super(new String[]{"water bottle", "water", "bottle", "blue bottle", "plastic bottle"});

		this.viewResponse = "A water bottle";
		this.openResponse = "I don't think I need to open it.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {

		this.setTarget(null);
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 157;
		this.iY = 419;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage(this.getViewResponse());
		}
		else
			this.parent.updateMessage("...");
	}


	@Override
	public void open() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage(this.getOpenResponse());
		}
		else
			this.parent.updateMessage("...");
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage(this.getCloseResponse());
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage(this.getTakeResponse());
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void use() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage(this.getUseResponse());
		}
		else
			this.parent.updateMessage("...");
	}
}
