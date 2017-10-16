package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

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
		this.parent.updateMessage("The door leads back to the hallway.");
	}

	@Override
	public void open() {
		System.out.println("Entered "+this.objectName);
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_HALLWAY,
				Room.INDEX_BEDROOM_X, -1);
		this.parent.updateMessage("I'm back in the hallway.");
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
		this.parent.updateMessage("I can't carry a door around.");
	}
	@Override
	public void use() {
		System.out.println("Entered "+this.objectName);
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_HALLWAY,
				Room.INDEX_BEDROOM_X, -1);
		this.parent.updateMessage("I'm back in the hallway.");
	}

}
