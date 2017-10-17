package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class StrawberryJam extends InteractableObject{
	
	public StrawberryJam() {
		super(new String[]{"strawberry jam","jam","strawbery","jar","redjar","red jar"});

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
		
		this.iX = 126;
		this.iY = 537;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.parent.updateMessage("An ordinary strawberry jam.");
		}
		else
			this.parent.updateMessage("...");
	}

	@Override
	public void open() {
		use();
	}

	@Override
	public void close() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.parent.updateMessage("It's already closed.");
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.parent.updateMessage("I don't need a strawberry jam.");
		}
		else
			this.parent.updateMessage("...");
	}
	@Override
	public void use() {
		if(this.getParent().lookupObject("FridgeDoor").isOpened()){
			this.parent.updateMessage("I have no use for this.");
		}
		else
			this.parent.updateMessage("...");
	}

}
