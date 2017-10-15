package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class LampLight extends InteractableObject{
	
	public LampLight() {
		super(new String[]{"lamplight"});
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
		
		this.iX = 484;
		this.iY = 158;
		
		this.setX(iX);
		this.setY(iY);

		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
		this.iiDefault = new ImageIcon("images/"+this.objectName+"_default.png");
		this.iiClosed = this.iiDefault;
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		this.lblObject.setIcon(this.iiOpened);
		this.setOpened(true);
	}

	@Override
	public void close() {
		this.lblObject.setIcon(this.iiClosed);
		this.setOpened(false);
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
