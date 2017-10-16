package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Stove extends InteractableObject{
	
	public Stove() {
		super(new String[]{"stove"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setOpened(false);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 459;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
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
		if(!this.isOpened() &&
				this.getParent().lookupObject("Pot").isUsed()) {
			this.setOpened(true);
			this.setUsed(true);
			
			this.getParent().getParent().getInventory().removeItem("Flask");
			this.getParent().getParent().getInventory().addItem(new SulfuricAcid());
			this.getParent().updateMessage("I now have a flask full of sulfuric acid. This is strong enough to corrode metal.");
		}
		else {
			this.getParent().updateMessage("There's no point in turning this on.");
		}
		
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void use() {
		this.open();
	}

}
