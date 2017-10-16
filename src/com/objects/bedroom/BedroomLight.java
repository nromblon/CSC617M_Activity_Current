package com.objects.bedroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class BedroomLight extends InteractableObject{
	
	public BedroomLight() {
		super(new String[]{"hanging lamp","ceiling lamp","lights","light","bulb","lightbulb"});
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
		this.iY = 138;
		
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
		this.parent.updateMessage("This bulb lights up the room.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("The light is already opened. Also, I can't reach it.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("I can't reach it and there's no switch nearby");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I can't reach it.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I can't reach it.");
	}

}
