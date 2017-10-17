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
		this.setLocked(true);
		this.setOpened(false);
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
		if(this.isLocked()) {
			this.getParent().updateMessage("A door. It looks like it leads to the bathroom, but it's chained shut. The chain looks weak, I think it's made of cheap metal.");
			
		}
		else if(this.isOpened()) {
			this.getParent().updateMessage("The bathroom door.");
		}
		else {
			this.getParent().updateMessage("A previously locked door.");
		}
	}

	@Override
	public void open() {
		if(this.isLocked() && !this.getParent().getParent().getInventory().searchIfItemExists("SulfuricAcid")) {
			this.getParent().updateMessage("It's chained shut. The chain looks weak, I think I can break it.");
			
		}
		else if(this.isLocked() && this.getParent().getParent().getInventory().searchIfItemExists("SulfuricAcid")) {
			this.setLocked(false);
			this.getParent().getParent().getInventory().removeItem("SulfuricAcid");
			this.getParent().updateMessage("I think I can break the chain using sulfuric acid. There! that should do it.");
			
		}
		else {
			this.setOpened(true);
			// Assumes that the gameWorld is an instance of Room
			this.getParent().getParent().toStage(Room.INDEX_BATHROOM,
					Room.INDEX_X, 1);
		}
	}

	@Override
	public void close() {
		if(this.isLocked()) {
			this.getParent().updateMessage("Nevermind closing it, it's already chained shut.");	
		}
		else {
			this.getParent().updateMessage("It's already closed.");
		}
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("I can't take this even if I wanted to.");		
	}
	@Override
	public void use() {
		this.open();
	}
}
