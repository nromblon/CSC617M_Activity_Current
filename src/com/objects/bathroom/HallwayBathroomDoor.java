package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.Room;

public class HallwayBathroomDoor extends InteractableObject{
	
	public HallwayBathroomDoor() {
		super(new String[]{"Door","hallway"});
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

		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("This door leads back to the hallway.");
	}

	@Override
	public void open() {
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_HALLWAY,
				Room.INDEX_BATHROOM_X, -1);
		this.parent.updateMessage("I'm back in the hallway.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("It's already closed.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't think it's productive to carry a door around.");
	}
	@Override
	public void use() {
		open();
	}

}
