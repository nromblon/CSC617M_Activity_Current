package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class DaisyBottle extends InteractableObject{
	
	public DaisyBottle() {
		super(new String[]{"daisy", "daisy bottle", "center bottle",
						"middle bottle", "yellow bottle", "second bottle",
						"2nd bottle", "bottle 2", "bottle2"});
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
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("A fragrance bottle that contains the scent of daisies. I could use this onto the bath tub.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("It sure does smell like daisies.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("It's already closed.");
	}
	@Override
	public void update() {
		
	}
	@Override
	public void take() {
		if(!this.isTaken) {
			this.lblObject.setVisible(false);
			this.getParent().getParent().getInventory().addItem(this, "Daisy fragrance. Usually used on bath tubs");
			this.setTarget(this.getParent().lookupObject("DaisyBubbles"));
			this.setTaken(true);
			this.parent.updateMessage("I took the daisy bottle.");
		}
		else
			this.parent.updateMessage("I already took the bottle.");
	}
	@Override
	public void use() {
		if(this.isTaken()) {
			if(this.getParent().lookupObject("Bathtub").isOpened()) {
				if(this.getParent().lookupObject("Bathtub").isUsed()) {
					this.getParent().updateMessage("I should drain the bathtub first.");
				}
				else {
					this.getParent().updateMessage("I poured the Daisy essence in the bathtub."+
													"The room smells like Daisies.");
					this.setUsed(true);
					this.getParent().lookupObject("Bathtub").setUsed(true);
					
					this.getParent().getParent().getInventory().removeItem(this);
					this.getParent().lookupObject("DaisyBubbles").open();
				}
			}
			else {
				this.getParent().updateMessage("I should fill the bathtub with water first.");	
			}
		}
	}

}
