package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class OrangeBook extends InteractableObject{
	
	public OrangeBook() {
		super(new String[]{"orange book", "orangebook", "first book",
							"firstbook", "1st book", "book1", "book 1",
							"book one", "bookone"});
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
		
		this.iX = 255;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);

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
		
	}
	@Override
	public void use() {
		
	}

}
