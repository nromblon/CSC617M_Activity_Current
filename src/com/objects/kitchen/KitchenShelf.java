package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class KitchenShelf extends InteractableObject{
	
	public KitchenShelf() {
		super(new String[]{"shelf","rack","ledge","sill"});
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
		
		this.iX = 258;
		this.iY = 334;
		
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
		this.parent.updateMessage("The shelf features a tumbler, dishes, a jar of honey, and a goblet. The only thing that interests me is that goblet...");
	}

	@Override
	public void open() {
		this.parent.updateMessage("There's nothing to be opened.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("There's nothing to be closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("The shelf is screwed to the wall.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("What?");
	}

}
