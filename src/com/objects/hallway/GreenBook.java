package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class GreenBook extends InteractableObject{
	
	private int viewCount;
	
	public GreenBook() {
		super(new String[]{"green book", "greenbook", "third book",
							"thirdbook", "3rd book", "book3", "book 3",
							"book three", "bookthree", "journal", "diary"});
		this.viewResponse = "A "+this.objectName+".";
		this.openResponse = "The "+this.objectName+" can't be opened.";
		this.closeResponse = "The "+this.objectName+" can't be closed.";
		this.objectName = this.getClass().getSimpleName();
		this.initComponents();
		this.setViewCount(0);
	}
	private void initComponents() {

		this.objectName = this.getClass().getSimpleName();
		this.lblObject = new JLabel();
		Game.initLabels(lblObject, this.objectName+"_default", null);
		
		this.iX = 278;
		this.iY = 404;
		
		this.setX(iX);
		this.setY(iY);

		this.setCenterX(this.lblObject.getWidth()/2);
		this.setCenterY(this.lblObject.getHeight()/2);
	}
	
	@Override
	public void view() {
		this.getParent().updateMessage("An unlabeled book. It looks like a journal.");		
	}

	@Override
	public void open() {
		if(this.getViewCount() == 0) {
			this.getParent().updateMessage("It looks like a personal journal. "+
											"There are entries on each page. "+
											"I should try reading some of it.");
		}
		else {
			switch(this.getViewCount()) {
				case 1:
					this.getParent().updateMessage(Game.DEFINED_SPACE+"\"I'm not good with remembering numbers. "+
							"I often forget my phone number so I always "+
							"keep a copy in my pocket. But it’s the same "+
							"for short numbers and it’s starting to be a problem.\"");
					break;
				case 2:
					this.getParent().updateMessage(Game.DEFINED_SPACE+"\"Recently I forgot the password to "+
								"my safe for the third time. I had to break it "+
								"open which was a shame ‘cause those things aren’t cheap.\"");
					break;
				case 3:
					this.getParent().updateMessage(Game.DEFINED_SPACE+"\"I learned my lesson from then. "+
								"I now keep a copy in my room, but I made sure to keep it hidden. "+
								"I keep important stuff in there after all.\"");

					break;
				default:
					this.getParent().updateMessage("Some of the pages are missing.");
					this.setViewCount(-1);
			}
		
		}
		this.setViewCount(this.getViewCount()+1);
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
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

}
