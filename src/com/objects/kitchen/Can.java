package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Can extends InteractableObject{
	
	public Can() {
		super(new String[]{"can","soda","softdrinks","softdrink","drink", "redcan", "red can"});

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
		
		this.iX = 175;
		this.iY = 432;
		
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
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("A regular soda can.");
		}else
			this.parent.updateMessage("...");
	}

	@Override
	public void open() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("Open happiness... If I get out of here, I would be happy.");
		}else
			this.parent.updateMessage("...");
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("It's already closed.");
		}else
			this.parent.updateMessage("...");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("I don't think I need a soda right now.");
		}else
			this.parent.updateMessage("...");
	}
	@Override
	public void use() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.getParent().updateMessage("I'll probably die before I get thirsty.");
		}else
			this.parent.updateMessage("...");
	}

}
