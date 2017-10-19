package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class BathroomCabinet extends InteractableObject{
	
	public BathroomCabinet() {
		super(new String[]{"Cabinet","bathroom cabinet","bathroomcabinet"});
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
		parent.updateMessage("A bathroom cabinet. Looks pretty sturdy.");
	}

	@Override
	public void open() {
		parent.updateMessage("A stack of clean towels is placed inside it.");
	}

	@Override
	public void close() {
		parent.updateMessage("It's already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		parent.updateMessage("Sure, the towels inside it are light but I doubt that I could carry the cabinet itself.");
	}
	@Override
	public void use() {
		open();
	}

}
