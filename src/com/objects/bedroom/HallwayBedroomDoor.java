package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;
import world.Room;

public class HallwayBedroomDoor extends InteractableObject{
	
	public HallwayBedroomDoor() {
		super(new String[]{"door","hallway"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {
		
		this.objectName = "Door";
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = -(lblObject.getWidth()-20);
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
		this.lblObject.setVisible(false);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		System.out.println("Entered "+this.objectName);
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_HALLWAY,
				Room.INDEX_BEDROOM_X, -1);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
