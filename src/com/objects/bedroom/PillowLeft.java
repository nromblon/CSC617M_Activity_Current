package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class PillowLeft extends InteractableObject{
	
	public PillowLeft() {
		super(new String[]{"left pillow","1st pillow","first pillow"});
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
		this.iY = 430;
		
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
		this.parent.updateMessage("This pillow is light, like any other pillow.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I don't know why I should do that..");
	}

	@Override
	public void close() {
		this.parent.updateMessage("What?");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(!isTaken()) {
			this.setTaken(true);
			this.lblObject.setVisible(false);
			this.parent.updateMessage("There's a number engraved on the headrest.");
		}
		else
			this.parent.updateMessage("I already took the pillow.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't feel like sleeping...");
	}

}
