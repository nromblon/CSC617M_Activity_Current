package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class RedBook extends InteractableObject{
	
	public RedBook() {
		super(new String[]{"red book", "redbook", "sixth book",
							"maroon book", "maroonbook", "last book",
							"sixthbook", "6th book", "book6", "book 6",
							"book six", "booksix"});
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
		
		this.iX = 314;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("The Code Book: The Science of Secrecy from Ancient Egypt to Quantum Cryptography "+
										"by Simon Singh.");	
		
	}

	@Override
	public void open() {
		this.getParent().updateMessage("It talks about the history of cryptography from Egyptian puzzles to modern day computer encryption.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("Why am I closing a closed book?");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("I don't think I'll want to spend my last minutes reading about cryptography."+
										"I should leave it be.");
		
	}
	@Override
	public void use() {
		this.getParent().updateMessage("Oh right! I can use this to defuse the bomb!... Not.");
		
	}

}
