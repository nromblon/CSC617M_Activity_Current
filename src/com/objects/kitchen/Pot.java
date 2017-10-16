package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Pot extends InteractableObject{
	
	public Pot() {
		super(new String[]{"pot", "casserole"});
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
		
		this.iX = 473;
		this.iY = 390;
		
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
		// TODO Auto-generated method stub
		
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

		
	}
	@Override
	public void use() {
		if(this.getParent().getParent().getInventory().searchIfItemExists("Wrench") &&
				this.getParent().getParent().getInventory().searchIfItemExists("CarBattery")) {
			this.getParent().updateMessage("I can make sulfuric acid with ");
			this.setUsed(true);
		}
	}

}
