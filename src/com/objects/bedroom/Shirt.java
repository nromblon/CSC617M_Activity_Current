package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Shirt extends InteractableObject{
	
	public Shirt() {
		super(new String[]{"shirt","clothes","hanger"});
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
		
		this.iX = 158;
		this.iY = 449;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("A hanged shirt.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't see the significance of that.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't see the significance of that.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(!isTaken()) {
			this.setTaken(true);
			this.lblObject.setVisible(false);
			this.parent.updateMessage("I took the shirt. There's a number engraved on the closet. How surprising.");
		}
		else
			this.parent.updateMessage("I already took the shirt.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("What?");
	}

}
