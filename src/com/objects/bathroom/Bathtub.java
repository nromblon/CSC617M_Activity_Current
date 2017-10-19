package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Bathtub extends InteractableObject{
	
	public Bathtub() {
		super(new String[]{"tub","bathtub","bath tub","bath"});
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
		
		this.iX = 768;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
		
		this.setUsed(false);
		this.setOpened(false);
	}
	
	@Override
	public void view() {
		if(this.isUsed()) {
			this.getParent().updateMessage("A scented bath.");
		}
		else if(this.isOpened) {
			this.getParent().updateMessage("A bathtub filled with water.");
		}
		else {
			this.getParent().updateMessage("An empty bathtub.");
		}
	}

	@Override
	public void open() {
		if(this.isUsed()) {
			this.getParent().updateMessage("I should drain the water first.");
		}
		else {
			this.getParent().updateMessage("I filled the bathtub with water.");
			this.setOpened(true);
		}
	}

	@Override
	public void close() {
		if(this.isUsed()) {
			this.getParent().updateMessage("I drained the bathtub. It's empty now.");
			this.getParent().lookupObject("RoseBubbles").close();
			this.getParent().lookupObject("DaisyBubbles").close();
			this.getParent().lookupObject("LotusBubbles").close();

			this.setOpened(false);
			this.setUsed(false);
		}
		else {
			this.getParent().updateMessage("An empty bathtub.");
		}		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void take() {
		this.parent.updateMessage("I think that's physically impossible");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't have time to take a bath. But on the bright side, I have enough time to open and close the bathtub.");
	}

}
