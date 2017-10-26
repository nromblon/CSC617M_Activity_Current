package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Lamp extends InteractableObject{
	
	public Lamp() {
		super(new String[]{"lamp","nightlight","desk lamp","night light"});
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
		
		this.iX = 691;
		this.iY = 375;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("Seems like an ordinary lamp. I can try opening it on and off.");
	}

	@Override
	public void open() {
		this.getParent().lookupObject("LampLight").open();
	}

	@Override
	public void close() {
		this.getParent().lookupObject("LampLight").close();
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		
	}
	@Override
	public void use() {
	}

}
