package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Bed extends InteractableObject{
	
	public Bed() {
		super(new String[]{"bed","bedsheet"});
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
		
		this.iX = Stage.CENTER_WIDTH-this.lblObject.getWidth()/2;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
//		this.iiTaken = new ImageIcon("images/"+this.objectName+"_taken.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("There's two pillows on this bed.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("I can try opening the mattress, but I don't see the reason why.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I don't know what you're talking about");
	}

	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't lift a whole bed.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I'm not really in the mood to sleep...");
	}

}
