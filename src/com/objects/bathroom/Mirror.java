package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Mirror extends InteractableObject{
	
	public Mirror() {
		super(new String[]{"Mirror","glass"});
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
		
		this.iX = 204;
		this.iY = 351;
		
		this.setX(iX);
		this.setY(iY);
		
		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("RoseBottle").isUsed()) {
			this.getParent().updateMessage("A mirror with a rose enabled lock. This must be expensive");

		}
		else {
			this.getParent().updateMessage("A mirror. It seems like there's something behind it.");
		}
	}

	@Override
	public void open() {
		if(this.isOpened()) {

			this.getParent().getParent().openOverlayMedicineCabinet();
		}
		else if(this.getParent().lookupObject("RoseBottle").isUsed()) {
			
			this.getLblObject().setIcon(this.getIiOpened());			

			this.getParent().updateMessage("It opened!");
			this.getParent().updateMessage("It seems like the rose scented bath triggered the lock to open.");
			this.setOpened(true);
		}
		else {
			this.getParent().updateMessage("A mirror. It seems like I can open it, but it's stuck");
		}		
	}

	@Override
	public void close() {
		if(this.isOpened()) {
			this.getParent().updateMessage("I probably shouldn't close it, it might automatically get locked.");
		}
	}
	
	@Override
	public void update() {

	}
	
	@Override
	public void take() {
		this.getParent().updateMessage("It's stuck to the wall, I don't think I can take it off.");
	}
	
	@Override
	public void use() {
		if(this.isOpened()) {
			this.getParent().getParent().openOverlayMedicineCabinet();
		}
		else {
			this.getParent().updateMessage("Now's not the time to be staring at my reflection.");	
		}		
	}

}
