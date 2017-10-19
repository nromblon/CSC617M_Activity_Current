package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BathroomNote extends InteractableObject{
	
	public BathroomNote() {
		super(new String[]{"note","paper","post-it","post"});
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
		
		this.iX = 268;
		this.iY = 415;
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiDefault = new ImageIcon("images/"+this.objectName+"_default.png");
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
		this.iiTaken = new ImageIcon("images/"+this.objectName+"_taken.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().getParent().openOverlayNote();
		this.parent.updateMessage("looks like two gigantic roses taking a bath.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't know what you want me to do.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't know what you want me to do.");
	}
	@Override
	public void update() {

	}

	@Override
	public void take() {
		if(!this.isTaken) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this,"A note that says something about a bath tub and roses.");
			this.lblObject.setVisible(false);
			this.parent.updateMessage("I took the note.");
		}
		else
			this.parent.updateMessage("I already took the note.");
	}
	@Override
	public void use() {
		view();
	}

}
