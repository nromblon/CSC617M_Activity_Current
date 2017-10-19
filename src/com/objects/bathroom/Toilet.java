package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Toilet extends InteractableObject{
	
	public Toilet() {
		super(new String[]{"throne","toilet","toilet seat","privy","lavatory","loo"});
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
		
		this.iX = 482;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
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
		this.parent.updateMessage("A regular toilet.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("Even though it looks clean, I still don't want to touch that.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("Even though it looks clean, I still don't want to touch that.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.parent.updateMessage("Carrying a toilet around... seems like a good plan.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I'm not hearing the nature's call right now...");
	}

}
