package com.objects.kitchen;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class Honey extends InteractableObject{
	
	public Honey() {
		super(new String[]{"hoeny","yellow jar","yellow bottle","jar"});
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
		
		this.iX = 368;
		this.iY = 364;
		
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
		this.parent.updateMessage("The label reads '100% Natural Honey', like they all do.");
	}

	@Override
	public void open() {
		this.parent.updateMessage("The lid is stuck.");
	}

	@Override
	public void close() {
		this.parent.updateMessage("It's already closed.");
	}
	@Override
	public void update() {
//		System.out.println("Drawer update");
	}
	@Override
	public void take() {
		this.parent.updateMessage("I'd love to however, it's nothing but dead weight.");
	}
	@Override
	public void use() {
		this.parent.updateMessage("I'd love a taste of that, if the lid wasn't stuck.");
	}

}
