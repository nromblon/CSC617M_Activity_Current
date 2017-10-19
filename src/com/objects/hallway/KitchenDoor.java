package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.Room;

public class KitchenDoor extends InteractableObject{
	
	public KitchenDoor() {
		super(new String[]{"kitchen", "kitchen door", "1st door",
							"first door", "red door", "left door",
							"leftmost door", "door 1", "door1"});
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
		
		this.iX = 33;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.isLocked()) {
			this.getParent().updateMessage("A door. It looks like it leads to the kitchen, but it's locked.");
			
		}
		else if(this.isOpened()) {
			this.getParent().updateMessage("The kitchen door.");
		}
		else {
			this.getParent().updateMessage("A previously locked door.");
		}
	}

	@Override
	public void open() {
		if(this.isLocked() && !this.getParent().getParent().getInventory().searchIfItemExists("KitchenKey")) {
			this.getParent().updateMessage("It's locked. Maybe there's a key in here somewhere.");
			
		}
		else if(this.isLocked() && this.getParent().getParent().getInventory().searchIfItemExists("KitchenKey")) {
			this.setLocked(false);
			this.getParent().getParent().getInventory().removeItem("KitchenKey");
			this.getParent().updateMessage("It's locked. I think this key should do the trick. There, it's open.");
			
		}
		else {

			this.setOpened(true);
			// Assumes that the gameWorld is an instance of Room
			this.getParent().getParent().toStage(Room.INDEX_KITCHEN,
					Room.INDEX_X, 1);

			this.parent.updateMessage("Plenty of things in this kitchen.");
		}		
	}

	@Override
	public void close() {
		if(this.isLocked()) {
			this.getParent().updateMessage("Guess what, it's locked.");	
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
		this.getParent().updateMessage("Yeah, maybe I should take this home. If I survive, that is.");
	}
	@Override
	public void use() {
		this.open();
	}

}
