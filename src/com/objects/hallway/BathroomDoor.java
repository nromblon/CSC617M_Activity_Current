package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.Room;

public class BathroomDoor extends InteractableObject{
	
	public BathroomDoor() {
		super(new String[]{"bathroom", "3rd door", "third door",
							"white door", "bathroom door", "last door",
							"right door", "rightmost door", "door 3",
							"door3", "blue door", "bluedoor"});
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
		
		this.iX = 839;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		
	}

	@Override
	public void open() {
		// Assumes that the gameWorld is an instance of Room
		this.getParent().getParent().toStage(Room.INDEX_BATHROOM,
				Room.INDEX_X, 1);
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
		
	}

}
