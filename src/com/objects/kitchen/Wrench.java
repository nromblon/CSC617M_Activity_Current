package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Wrench extends InteractableObject{
	
	private boolean isVisible;
	public Wrench() {
		super(new String[]{"wrench", "dark grey tool", "third tool box item",
				"third toolbox item", "3rd tool", "third tool", "3rd toolbox item",
				"3rd tool box item"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setTaken(false);
		this.setUsed(false);
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
		this.lblObject.setVisible(this.isVisible());
	}
	
	@Override
	public void view() {
		if(isVisible)
			this.parent.updateMessage("A wrench.");
	}

	@Override
	public void open() {
		if(this.isTaken()) {
			this.close();
		}
		else {
			this.lblObject.setVisible(true);
			this.setVisible(true);
			this.setTarget(this);
		}
	}

	@Override
	public void close() {
		this.lblObject.setVisible(false);
		this.setVisible(false);
		this.setTarget(null);
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(!isTaken() &&
				this.getParent().lookupObject("ToolBox").isOpened()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this, "could be used for opening stuff.");
			this.lblObject.setVisible(false);
			this.setVisible(false);
			this.parent.updateMessage("I took the wrench.");
		}
		else
			parent.updateMessage("...");
	}
	@Override
	public void use() {
		this.setUsed(true);
	}

	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
}
