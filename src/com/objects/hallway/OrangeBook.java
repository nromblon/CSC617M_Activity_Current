package com.objects.hallway;

import javax.swing.JLabel;
import com.elements.Game;
import com.objects.InteractableObject;

public class OrangeBook extends InteractableObject{
	
	public OrangeBook() {
		super(new String[]{"yellow book", "yellowbook", "orange book", "orangebook", "first book",
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
		this.getParent().updateMessage("A thick notebook. It looks like a scrapbook of some sorts.");
	}

	@Override
	public void open() {
		
		switch(this.getViewCount()) {
		case 0:
			this.getParent().updateMessage("There are various newspaper clippings on each page. I should try reading some of them.");
		
			break;
		case 1:
		
			this.getParent().updateMessage("Criminal Profiler Explains the Mind of a Kidnapper - "+
					"\"The kidnappers may not be mentally ill, in "+
					"the medical sense, but they are still sick people, "+
					"whose feelings of powerlessness drive those weaker than them to suffer"+
					"It's being in control, being the one who's on top, who can call the shots.\"");
			break;
		case 2:
			this.getParent().updateMessage("How Does a Kidnapper Choose his Victim - "+
					"\"Kidnappers tend to develop a profile of their likely target "+
					"before making an abduction based upon their overall "+
					"goals, which usually falls into one of three categories: "+
					"financial gain, extremism or emotional disturbance.\"");
			break;
		default:
			this.getParent().updateMessage("This is disturbing.");
			this.setViewCount(-1);
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

}
