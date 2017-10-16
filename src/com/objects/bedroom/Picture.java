package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Picture extends InteractableObject{
	
	public Picture() {
		super(new String[]{"picture","painting","frame","flower","art"});
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
		
		this.iX = 44;
		this.iY = 341;
		
		this.setX(iX);
		this.setY(iY);
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("The picture frame contains a slider puzzle of what seems like a flower.");
	}

	@Override
	public void open() {
		this.getParent().updateMessage("I can't open the frame.");
	}

	@Override
	public void close() {
		this.getParent().updateMessage("I don't know what you're talking about.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(!isTaken()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this);
			this.lblObject.setVisible(false);
			this.getParent().updateMessage("I should try solving this puzzle.");
		}
		else
			this.getParent().updateMessage("I already took the picture.");
	}
	@Override
	public void use() {
		if(!isTaken)
			this.getParent().updateMessage("To make things easier, I should take it first before trying to solve it.");
	}

}
