package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class HallwayShelfBottom extends InteractableObject{
	
	public HallwayShelfBottom() {
		super(new String[]{"shelf", "bottom shelf"});
		
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 252;
		this.iY = 439;
		
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
		this.parent.updateMessage("The shelf holds 6 books, each with their own color: yellow, purple, green, blue, pink, and red.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't think that's possible.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't think that's possible.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't think that's possible.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't think that's possible.");
	}

}
