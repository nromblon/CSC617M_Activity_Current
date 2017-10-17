package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Table extends InteractableObject{
	
	public Table() {
		super(new String[]{"table","right table","dining table","main table"});
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
		
		this.iX = 769;
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
		this.parent.updateMessage("The table has a pot of coffee and a mug on it.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("There's nothing to open.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("There's nothing to close.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't take a table this heavy.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't know what you're talking about.");
	}

}
