package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class CarBattery extends InteractableObject{
	private boolean isVisible;
	
	public CarBattery() {
		super(new String[]{"battery", "car battery", "carbattery"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setTaken(false);
		this.close();
		this.setVisible(lblObject.isVisible());
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 268;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
	
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void spawn() {
		super.spawn();
		this.close();
		this.lblObject.setVisible(this.isVisible());
	}
	
	@Override
	public void view() {

	}

	@Override
	public void open() {
		if(this.isTaken()) {
			this.close();
		}
		else {
			this.lblObject.setVisible(true);
			this.setVisible(true);
		}
	}

	@Override
	public void close() {
		this.lblObject.setVisible(false);
		this.setVisible(false);
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(!isTaken() &&
				this.getParent().lookupObject("ToolBox").isOpened()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this);
			this.lblObject.setVisible(false);
			this.setVisible(false);
		}
	}
	@Override
	public void use() {
		
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
