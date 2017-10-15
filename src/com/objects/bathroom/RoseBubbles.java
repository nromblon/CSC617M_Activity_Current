package com.objects.bathroom;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class RoseBubbles extends InteractableObject{
	
	public RoseBubbles() {
		super(new String[]{"rose bubbles","pink bubbles","red bubbles","pink bubble","red bubble","bubbles","bubble"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.close();
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 886;
		this.iY = 467;
		
		this.setX(iX);
		this.setY(iY);

//		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
//		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
//		this.iiClosed = new ImageIcon("images/"+this.objectName+"_closed.png");
//		this.iiViewed = new ImageIcon("images/"+this.objectName+"_viewed.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void spawn() {
		lblObject.setLocation(iX, iY);
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		this.setOpened(true);
		this.lblObject.setVisible(true);
	}

	@Override
	public void close() {
		this.setOpened(false);
		this.lblObject.setVisible(false);
		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void take() {
		if(!this.isTaken) {
			this.getParent().getParent().getInventory().addItem(this);
			this.setTaken(true);
		}		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
