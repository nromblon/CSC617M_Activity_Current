package com.objects.hallway;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class AcidRecipe extends InteractableObject{
	
	public AcidRecipe() {
		super(new String[]{"acid recipe", "recipe", "sulfuric acid recipe",
							"acid instructions"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setTaken(false);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 267;
		this.iY = 404;
		
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
	}

	@Override
	public void open() {
	}

	@Override
	public void close() {
		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		if(!this.isTaken()) {
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this);
			this.lblObject.setVisible(false);
		}		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
