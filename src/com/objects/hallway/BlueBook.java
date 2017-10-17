package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class BlueBook extends InteractableObject{
	
	public BlueBook() {
		super(new String[]{"blue book", "bluebook", "fourth book",
							"fourthbook", "4th book", "book4", "book 4",
							"book four", "bookfour"});
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
		
		this.iX = 290;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("The All-New Puzzle Book by Mensa.");
	}

	@Override
	public void open() {
		this.getParent().updateMessage("The pages contain puzzles that have been created by the intelligence experts at Mensa. "+
										"The puzzles seem difficult, but all the pages have answers.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("It's already closed.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("I don't need to take this. There's no time to answer it, and besides, all of the pages have been answered anyway.");
	}
	@Override
	public void use() {
		this.getParent().updateMessage("What am I supposed to use this for?");
	}

}
