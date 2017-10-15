package com.objects.kitchen;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class FridgeDoor extends InteractableObject{
	
	public FridgeDoor() {
		super(new String[]{"fridge", "fridge door"});
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
		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
		this.iiClosed = new ImageIcon("images/"+this.objectName+"_default.png");
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
		this.setOpened(true);
		this.lblObject.setVisible(false);
	}

	@Override
	public void close() {
		this.setOpened(false);
		this.lblObject.setVisible(true);
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
