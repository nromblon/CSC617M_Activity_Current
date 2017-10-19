package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class LotusBottle extends InteractableObject{
	
	public LotusBottle() {
		super(new String[]{"lotus bottle", "violet bottle", "purple bottle",
							"third bottle", "right bottle", "last bottle", "3rd bottle",
							"bottle 3", "bottle3"});
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
		
		this.iX = 707;
		this.iY = 405;
		
		this.setX(iX);
		this.setY(iY);
		this.iiInventory = new ImageIcon("images/"+this.objectName+".png");
	
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("A lotus-flavored fragrance bottle. Could be used onto the bathtub.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("It has the scent of a lotus flower");
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
		if(!this.isTaken()) {
			this.lblObject.setVisible(false);
			this.getParent().getParent().getInventory().addItem(this);
			this.setTarget(this.getParent().lookupObject("LotusBubbles"));
			this.setTaken(true);
			this.parent.updateMessage("I took the lotus bottle.");
		}
		else
			this.parent.updateMessage("I already took it.");
	}
	@Override
	public void use() {
		if(this.isTaken()) {
			if(this.getParent().lookupObject("Bathtub").isOpened()) {
				if(this.getParent().lookupObject("Bathtub").isUsed()) {
					this.getParent().updateMessage("I should drain the bathtub first.");
				}
				else {
					this.getParent().updateMessage("I poured the Lotus essence in the bathtub."+
													"The room is filled with the scent of Lotus flowers.");
					this.setUsed(true);
					this.getParent().lookupObject("Bathtub").setUsed(true);
					
					this.getParent().getParent().getInventory().removeItem(this);
					this.getParent().lookupObject("LotusBubbles").open();
				}
			}
			else {
				this.getParent().updateMessage("I should fill the bathtub with water first.");
			}
				
		}
	}

}
