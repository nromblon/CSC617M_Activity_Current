package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BathroomLight extends InteractableObject{
	
	public BathroomLight() {
		super(new String[]{"lights","light","lamp","bulb"});
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
		
		this.iX = 215;
		this.iY = 138;
		
		this.setX(iX);
		this.setY(iY);

		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}

	@Override
	public void view() {
		this.parent.updateMessage("This bulb lights up the room.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("The light is already opened. Also, I can't reach it.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I can't reach it and there's no switch nearby");
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't reach it.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I can't reach it.");
	}
}
