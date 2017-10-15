package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;

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
			// TODO:  A Rose/Daisy/Lotus bath.
			this.getParent().updateMessage("A scented bath.");
		}
		else if(this.isOpened) {
			// TODO: A bathtub filled with water.
			this.getParent().updateMessage("A bathtub filled with water.");
		}
		else {
			// TODO: An empty bathtub.
			this.getParent().updateMessage("An empty bathtub.");
		}
	}

	@Override
	public void open() {
		if(this.isUsed()) {
			// TODO: I should drain the water first.
			this.getParent().updateMessage("I should drain the water first.");
		}
		else {
			// TODO: I filled the tub with water
			this.getParent().updateMessage("I filled the bathtub with water.");
			this.setOpened(true);
		}
	}

	@Override
	public void close() {
		// <drain>
		if(this.isUsed()) {
			// TODO: I drained the bathtub.
			this.getParent().updateMessage("I drained the bathtub. It's empty now.");
			this.getParent().lookupObject("RoseBubbles").close();
			this.getParent().lookupObject("DaisyBubbles").close();
			this.getParent().lookupObject("LotusBubbles").close();
			
			this.setOpened(false);
			this.setUsed(false);
		}
		else {
			// The bathtub is empty.
			this.getParent().updateMessage("An empty bathtub.");
		}		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void take() {
		
	}
	@Override
	public void use() {
		this.setUsed(true);
	}

}
