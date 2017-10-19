package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class DaisyBubbles extends InteractableObject{
	
	public DaisyBubbles() {
		super(new String[]{"OOOOOOOOOOOOOOOOOOOOOOOO"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.close();
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 886;
		this.iY = 467;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void spawn() {
		lblObject.setLocation(iX, iY);
	}
	
	@Override
	public void view() {

	}

	@Override
	public void open() {
		this.setOpened(true);
		this.lblObject.setVisible(true);
	}

	@Override
	public void close() {
		this.setOpened(false);
		this.lblObject.setVisible(false);
		
	}
	@Override
	public void update() {
		this.parent.updateMessage("");
		
	}
	@Override
	public void take() {
		
	}
	@Override
	public void use() {
		
	}

}
