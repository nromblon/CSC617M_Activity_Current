package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Flask extends InteractableObject{
	
	public Flask() {
		super(new String[]{"flask","science bottle","potion","volumetric flask"});

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
		
		this.iX = 164;
		this.iY = 478;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(!isTaken() &&
				this.getParent().lookupObject("FridgeDoor").isOpened()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this);
			this.lblObject.setVisible(false);
		}
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}