package com.objects.hallway;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Bomb extends InteractableObject{

	private static int resCount = 0;

	public Bomb() {
		super(new String[]{"gray thing", "grey thing", "bomb","explosives","explosive"});
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
		
		this.iX = 230;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
	
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		switch(++resCount) {
			case 1: this.parent.updateMessage("OH SHIT IS THAT A BOMB??");
				break;
			case 2: this.parent.updateMessage("WHAT SHOULD I DO TO STOP THIS BOMB.");
				break;
			case 3: this.parent.updateMessage("WHAT DID I DO TO DESERVE THIS.");
				break;
			case 4: this.parent.updateMessage("I need to calm down and find a way to stop this bomb...");
				break;
			case 5: this.parent.updateMessage("What an explosive start to my day.");
				break;
			default: this.getParent().updateMessage("Upon several inspection, it appears to be a bomb. There are explosives rigged on one side. The digital display says " +
					this.getParent().getParent().getTimer().getTimeLbl().getText() + ". Looks like that's how long I have left to live.");
			break;
		}
	}

	@Override
	public void open() {
		if(this.isOpened() &&
				this.getParent().getParent().getInventory().searchIfItemExists("WireCutter") &&
				this.getParent().getParent().getInventory().searchIfItemExists("BombClue")) {
			this.getParent().getParent().openBombWiring();
		}
		else if(this.isOpened() &&
				this.getParent().getParent().getInventory().searchIfItemExists("WireCutter") &&
				!this.getParent().getParent().getInventory().searchIfItemExists("BombClue")) {
			this.getParent().updateMessage("I can now cut the wires but I don't know which one to cut! I don't think I can leave this to guess work. There has to be a clue here somewhere.");
		}
		else if(this.isOpened() &&
				!this.getParent().getParent().getInventory().searchIfItemExists("WireCutter")) {
				this.getParent().updateMessage("The wires are exposed, but I'll need something to cut it with.");
		}
		else if(!this.isOpened() && this.getParent().getParent().getInventory().searchIfItemExists("Wrench")) {
			this.setOpened(true);
			this.lblObject.setIcon(this.getIiOpened());
			this.getParent().updateMessage("There, that should do it.");
		}
		else {
			this.getParent().updateMessage("I'll need a wrench if I want to look inside.");	
		}
		
	}

	@Override
	public void close() {
		this.getParent().updateMessage("There's no point trying to close this thing.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("I don't have a need to take this, I'm sure the explosion is enough to kill me no matter where I am in this house.");
	}
	@Override
	public void use() {
		this.getParent().updateMessage("It's currently being used-- to kill me, that is.");
	}

}
