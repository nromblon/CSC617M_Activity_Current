package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class PurpleBook extends InteractableObject{
	
	public PurpleBook() {
		super(new String[]{"purple book", "purplebook", "second book",
							"secondbook", "2nd book", "book2", "book 2",
							"book two", "booktwo"});
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
		
		this.iX = 267;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("A book about poisonous chemicals.");
	}

	@Override
	public void open() {
		if(!this.isOpened()) {
			this.setOpened(true);
			this.getParent().updateMessage("It contains information about various poisonous chemicals.");
			this.getParent().updateMessage("There's a recipe for sulfuric acid in between the pages, I should take it.");
			this.getParent().lookupObject("AcidRecipe").take();
		}
		else {
			this.getParent().updateMessage("It contains information about various poisonous chemicals.");
		}
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
		// TODO Auto-generated method stub
		
	}

}
