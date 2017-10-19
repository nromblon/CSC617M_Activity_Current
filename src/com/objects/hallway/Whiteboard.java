package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

public class Whiteboard extends InteractableObject{
	
	public Whiteboard() {
		super(new String[]{"whiteboard", "White board", "plans", "blueprint", "plan", "board"});
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
		
		this.iX = 397;
		this.iY = Stage.FLOOR-this.lblObject.getHeight();
		
		this.setX(iX);
		this.setY(iY);
		
		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		switch(this.getViewCount()) {
			case 0:
				this.getParent().updateMessage("The whiteboard contains the plans for making an improvised bomb using using an air compressor, timer, and some other stuff I don't understand. " +
							"There's a note at the bottom: \"I won't show you this for no reason\". Is there some sort of clue in here somewhere..?");
				break;
			case 1:
				this.getParent().updateMessage("These are complicated plans for developing a bomb. There are some messy equations on the side. I don't think I'll understand this even if I tried.");
				break;
			case 2:
				this.getParent().updateMessage("Some notes imply that the bomb should be handled with care. Shocking.");
				break;
			case 3:
				this.getParent().updateMessage("There are notes on how the bomb was wired. !!! It seems like there are two main wires inside the bomb. If I understood this correctly, cutting one immediately detonates the bomb while cutting the other defuses it. This must be the clue the kidnapper was talking about.");
				break;
			default:
				this.getParent().updateMessage("The plan implies that cutting the correct wire can defuse the bomb, but it doesn't say anything about which wire to cut. It looks like I still have some hope left to live. I should look around, there must be some other clue around the house.");
				

		}
	
		this.setViewCount(this.getViewCount()+1);
	}

	@Override
	public void open() {

		this.getParent().updateMessage("Just how am I supposed to open this?");
	}

	@Override
	public void close() {

		this.getParent().updateMessage("I don't think I can do that with this.");
	}
	@Override
	public void update() {
	}
	@Override
	public void take() {
		this.getParent().updateMessage("This is heavy, I don't want to take it along with  me.");
		
	}
	@Override
	public void use() {
		this.getParent().updateMessage("I can use this to develop a bomb-- if I can understand it, that is.");
	}

}
