package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Cheese extends InteractableObject{

	private final String[] cheeseResponses = {"Good ol' cheese...", "What do you call a cheese that isn't yours? NACHO CHEESE",
		"What music does cheese listen to? R & BRIE",
			"What's always the last piece of cheese left? FOREVER PROVOLONE",
			"Man, I had some bad cheese yesterday. It was a Feta worse than death.",
		"When a favourite lady cheese left the office they all sang \"For cheese a jolly good fellow.\""};

	private static int cheeseResponseCount = 0;

	public Cheese() {
		super(new String[]{"cheese","queso","yellow thing"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {

		this.setTarget(null);
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 128;
		this.iY = 440;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			if(cheeseResponseCount < cheeseResponses.length)
				this.getParent().updateMessage(cheeseResponses[cheeseResponseCount++]);
			else
				this.getParent().updateMessage("I should stop.");
		}
		else
			this.parent.updateMessage("...");
	}

	@Override
	public void open() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("I don't think that's productive.");
		}
		else
			this.parent.updateMessage("...");
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("What??");
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("I don't want my pockets to smell...");
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void use() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("No thanks, I'm goud(a).");
		}
		else
			this.parent.updateMessage("...");
	}

}
