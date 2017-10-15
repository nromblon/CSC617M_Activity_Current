package com.objects;


import javax.swing.JLabel;


import com.elements.Game;
import com.elements.Stage;

public class Drawer extends InteractableObject{
	
	public Drawer() {
		super(new String[]{"drawer"});
		this.viewResponse = "A basic drawer.";
		this.openResponse = "You opened the drawer.";
		this.closeResponse = "You closed the drawer";
		this.objectName = "Drawer";
		this.initComponents();
	}
	private void initComponents() {
		
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 0;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use() {

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void take() {

	}

	@Override
	public void update() {
//		System.out.println("Drawer update");
	}

}
