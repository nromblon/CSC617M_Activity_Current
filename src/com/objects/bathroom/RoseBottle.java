package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;

public class RoseBottle extends InteractableObject{
	
	public RoseBottle() {
		super(new String[]{"rose Bottle","red bottle","pink bottle","left bottle","first bottle","1st bottle"});
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
		
		this.iX = 661;
		this.iY = 405;
		
		this.setX(iX);
		this.setY(iY);

		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
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
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		
	}
	@Override
	public void take() {
		if(!this.isTaken) {
			this.lblObject.setVisible(false);
			this.getParent().getParent().getInventory().addItem(this);
			this.setTaken(true);
		}		
	}
	@Override
	public void use() {
		if(this.isTaken()) {
			if(this.getParent().lookupObject("Bathtub").isOpened()) {
				if(this.getParent().lookupObject("Bathtub").isUsed()) {
					// TODO: I should drain the bathtub first.
					this.getParent().updateMessage("I should drain the bathtub first.");
					}
				else {
					// TODO: I poured rose essence in the bathttub
					this.getParent().updateMessage("I poured the Rose essence in the bathtub."+
													"The room is filled with the scent of Roses.");
					this.setUsed(true);
					this.getParent().lookupObject("Bathtub").use();
					
					this.getParent().getParent().getInventory().removeItem(this);
					this.getParent().lookupObject("RoseBubbles").open();
				}
			}
			else {
				// TODO: I should fill the bathtub with water first.
				this.getParent().updateMessage("I should fill the bathtub with water first.");	
			}
				
		}
	}

}
