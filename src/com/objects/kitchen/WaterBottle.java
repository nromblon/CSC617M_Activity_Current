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
		this.getParent().updateMessage(this.getViewResponse());
	}

	@Override
	public void open() {
		this.getParent().updateMessage(this.getOpenResponse());
	}

	@Override
	public void close() {
		this.getParent().updateMessage(this.getCloseResponse());
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage(this.getTakeResponse());
	}
	@Override
	public void use() {
		this.getParent().updateMessage(this.getUseResponse());
	}

}
