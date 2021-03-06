package com.objects.kitchen;

import javax.swing.ImageIcon;
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
		this.iiOpened = new ImageIcon("images/"+this.objectName+"_opened.png");
		this.iiClosed = new ImageIcon("images/"+this.objectName+"_default.png");
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	public void showContents() {
		this.getParent().lookupObject("CarBattery").open();
		this.getParent().lookupObject("WireCutter").open();
		this.getParent().lookupObject("Wrench").open();
	}
	
	public void hideContents() {
		this.getParent().lookupObject("CarBattery").close();
		this.getParent().lookupObject("WireCutter").close();
		this.getParent().lookupObject("Wrench").close();
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("ToolBoxKey").isTaken() && this.isOpened()) {
			this.getParent().updateMessage("A toolbox that contains a car battery, wire cutter, and wrench.");
		}
		else {
			this.getParent().updateMessage("A locked toolbox. It's heavy.");

		}
	}

	@Override
	public void open() {
		if(this.getParent().lookupObject("ToolBoxKey").isTaken()) {
			this.getParent().updateMessage("It's locked. I used the toolbox key. "+
											"There's a car battery, wire cutter, and wrench inside. "+
											"These might be useful.");
			
			this.setOpened(true);
			this.getLblObject().setIcon(this.iiOpened);
			this.showContents();
		}
		else {
			this.getParent().updateMessage("It's locked.");
		}
	}

	@Override
	public void close() {
		this.lblObject.setIcon(this.getIiClosed());
		this.setOpened(false);
		this.hideContents();
		
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.getParent().updateMessage("This is heavy, I don't think I need to take the whole thing.");
	}
	@Override
	public void use() {
		this.getParent().updateMessage("I can use this to knock my kidnapper out, "+
										"but since he or she isn't here, I have no use for it right now.");
	}
}
