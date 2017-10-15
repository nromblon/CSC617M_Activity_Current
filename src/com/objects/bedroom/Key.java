package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;
import world.Room;

public class Key extends InteractableObject{
	
	public Key() {
		super(new String[]{"key"});
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
		
		this.iX = 910;
		this.iY = 607;
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiDefault = new ImageIcon("images/"+this.objectName+"_default.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		this.iiTaken = new ImageIcon("images/"+this.objectName+"_taken.png");
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.setTaken(true);
		this.getParent().getParent().getInventory().addItem(this);
		this.lblObject.setIcon(this.iiTaken);
	}
	@Override
	public void use() {
		this.getParent().getParent().getInventory().removeItem(this);
		
	}

}
