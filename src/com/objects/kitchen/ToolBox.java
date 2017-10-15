package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class ToolBox extends InteractableObject{
	
	public ToolBox() {
		super(new String[]{"box","tool box","toolbox"});
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
		
		this.iX = 268;
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
		if(this.getParent().lookupObject("ToolBoxKey").isTaken() &&
				!this.getParent().lookupObject("ToolBoxKey").isUsed()) {
			this.getParent().lookupObject("ToolBoxKey").use();
			this.getParent().updateMessage("It's locked. I used the toolbox key.");
			this.getParent().updateMessage("There's a car battery inside. It might be useful, I should take it.");
			this.setTaken(true);
			this.getParent().getParent().getInventory().addItem(this.getParent().lookupObject("CarBattery"));
		}
		else {
			this.getParent().updateMessage("It's locked.");
		}
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
