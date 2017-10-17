package com.objects.hallway;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Bomb extends InteractableObject{

	private String[] responses = new String[]{""};
	private static int resCount = 0;

	public Bomb() {
		super(new String[]{"bomb","explosives","explosive"});
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
		// TODO Responses
		this.getParent().updateMessage("It appears to be bomb. There are explosives rigged on one side. The digital display says "+
										this.getParent().getParent().getTimer().getTimeLbl().getText()+". Looks like that's how long I have left to live.");
	
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
