package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class ToiletPaper extends InteractableObject{
	
	public ToiletPaper() {
		super(new String[]{"toilet paper","tissue paper","tissue","paper towel"});
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
		
		this.iX = 420;
		this.iY = 457;
		
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
		this.parent.updateMessage("At least they have the decency to stock up on toilet papers.");
		
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't know how would you open a toilet paper.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("How do you close a toilet paper?");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("It's rude to steal somebody's toilet paper... even if its from your kidnapper.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I'm not hearing the nature's call right now...");
	}

}
