package com.objects.bathroom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class RoseBottle extends InteractableObject{
	
	public RoseBottle() {
		super(new String[]{"rose bottle", "red bottle", "pink bottle",
							"left bottle", "first bottle", "1st bottle",
							"bottle 1", "bottle1"});
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
	
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.parent.updateMessage("A Rose-scented fragrance bottle. Usually used for bathtubs.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("Definitely smells like roses.");
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
			this.getParent().getParent().getInventory().addItem(this);
			this.setTarget(this.getParent().lookupObject("RoseBubbles"));
			this.setTaken(true);
			this.parent.updateMessage("I took the rose bottle.");
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
					this.getParent().updateMessage("I poured the Rose essence in the bathtub."+
													"The room is filled with the scent of Roses.");
					this.getParent().updateMessage("... What was that noise? I think I heard something click.");

					this.setUsed(true);
					this.getParent().lookupObject("Bathtub").setUsed(true);
					
					this.getParent().getParent().getInventory().removeItem(this);
					this.getParent().lookupObject("RoseBubbles").open();
				}
			}
			else {
				this.getParent().updateMessage("I should fill the bathtub with water first.");	
			}
				
		}
	}

}
