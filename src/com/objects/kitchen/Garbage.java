package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Garbage extends InteractableObject{
	
	public Garbage() {
		super(new String[]{"garbage","trash","trash can","recycling bin","can","bin"});
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
		
		this.iX = 356;
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
		this.parent.updateMessage("For a kitchen with a lot of things, the garbage can is surprisingly empty.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I've opened it and there's nothing inside it.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("It's already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I don't want to be seen walking around with a garbage can around my arms.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I have nothing to throw in it. I'm sorry trash can, looks like you're nothing but garbage right now.");
	}

}
