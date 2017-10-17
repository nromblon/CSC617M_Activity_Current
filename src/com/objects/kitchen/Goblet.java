package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Goblet extends InteractableObject{
	
	public Goblet() {
		super(new String[]{"goblet","chalice","glass"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
	}
	private void initComponents() {
		this.setViewed(false);
		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 279;
		this.iY = 296;
		
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
		if(!this.getParent().lookupObject("ToolBoxKey").isTaken()) {
			this.getParent().updateMessage("Theres a key inside.");
			this.parent.lookupObject("ToolBoxKey").setTarget(parent.lookupObject("ToolBoxKey"));
//			this.getParent().lookupObject("ToolBoxKey").take();
			this.setViewed(true);
		}
		else
			this.parent.updateMessage("It's empty.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("There's nothing to open.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("There's nothing to close.");
	}
	@Override
	public void update() {

	}
	@Override
	public void take() {
		this.parent.updateMessage("I know it looks cool, but I don't think I have the time for that now.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I don't know what you want me to do.");
	}

}
