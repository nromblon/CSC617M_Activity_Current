package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Fridge extends InteractableObject{
	
	public Fridge() {
		super(new String[]{"fridge","refrigerator","freezer"});
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
		
		this.iX = 45;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
//		if(!this.isOpened()) {
//			this.setOpened(true);
//			this.lblObject.setIcon(this.getIiOpened());
//			this.getParent().lookupObject("FridgeDoor").open();
//		}
	}

	@Override
	public void close() {
//		if(this.isOpened) {
//			this.setOpened(false);
//			this.getParent().lookupObject("FridgeDoor").close();
//		}
		
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
