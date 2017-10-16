package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.Room;

public class BedroomDoor extends InteractableObject{
	
	public BedroomDoor() {
		super(new String[]{"middle door", "center door", "2nd door",
							"second door", "brown door", "wooden door",
							"bedroom door", "bedroom", "door 2", "door2"});
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
		
		this.iX = 632;
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
		this.getParent().updateMessage("This door appears to be made of wood. It is also unlocked.");
	}

	@Override
	public void open() {
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_BEDROOM,
				Room.INDEX_X, 1);

		this.getParent().updateMessage("This seems like the bedroom.");
	}


	@Override
	public void close() {
		this.getParent().updateMessage("The door is already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.getParent().updateMessage("I can't lift a door that heavy.");
	}

	@Override
	public void use() {
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_BEDROOM,
				Room.INDEX_X, 1);

		this.getParent().updateMessage("This seems like the bedroom.");
	}

}
