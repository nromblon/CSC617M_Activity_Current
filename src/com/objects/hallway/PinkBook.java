package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class PinkBook extends InteractableObject{
	
	public PinkBook() {
		super(new String[]{"pink book", "pinkbook", "fifth book",
							"fifthbook", "5th book", "book5", "book 5",
							"book five", "bookfive"});
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
		
		this.iX = 302;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("Digital Scent Technology: Developing an Electronic Nose. It looks like a self-published book.");	
	}

	@Override
	public void open() {
		this.getParent().updateMessage("It talks about various ways to digitally record and distinguish scent.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("It's not even open.");		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("There's no point in taking this, I don't have time to read it.");		
	}
	@Override
	public void use() {
		this.getParent().updateMessage("Just how am I supposed to use this?");		
	}

}
