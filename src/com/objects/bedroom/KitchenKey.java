package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class KitchenKey extends InteractableObject{
	
	public KitchenKey() {
		super(new String[]{"key", "tool box key", "toolbox key", "silver key", "grey key", "gray key"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setTaken(false);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 279;
		this.iY = 296;
		
		this.setX(iX);
		this.setY(iY);

		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		
	}

	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		if(!this.isTaken()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this, "A key with a chef's hat and fork on the tag.");
			this.lblObject.setVisible(false);

		}
	}
	@Override
	public void use() {

	}

}
