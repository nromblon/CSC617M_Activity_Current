package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;

public class DaisyBottle extends InteractableObject{
	
	public DaisyBottle() {
		super(new String[]{"daisy","Daisy bottle","center bottle","middle bottle","yellow bottle","second bottle","2nd bottle"});
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
		
		this.iX = 684;
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
					// TODO: I poured daisy essence in the bathttub
					this.getParent().updateMessage("I poured the Daisy essence in the bathtub."+
													"The room smells like Daisies.");
					this.setUsed(true);
					this.getParent().lookupObject("Bathtub").use();
					
					this.getParent().getParent().getInventory().removeItem(this);
					this.getParent().lookupObject("DaisyBubbles").open();
				}
			}
			else {
				// TODO: I should fill the bathtub with water first.
				this.getParent().updateMessage("I should fill the bathtub with water first.");	
			}
		}
	}

}
