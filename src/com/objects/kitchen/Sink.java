package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Sink extends InteractableObject{
	
	public Sink() {
		super(new String[]{"sink","faucet","hydrant","spigot","spout"});
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
		
		this.iX = 610;
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
		this.parent.updateMessage("A dry sink. The faucet is broken.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("No water is coming out.");
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
		this.parent.updateMessage("It's impossible to take this off.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("No water is coming out.");
	}

}
