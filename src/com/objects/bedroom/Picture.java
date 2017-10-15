package com.objects.bedroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Picture extends InteractableObject{
	
	public Picture() {
		super(new String[]{"picture","painting","frame","flower","art"});
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
		this.iY = 341;
		
		this.setX(iX);
		this.setY(iY);
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
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
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.getParent().getParent().getInventory().addItem(this);
		this.lblObject.setVisible(false);
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
