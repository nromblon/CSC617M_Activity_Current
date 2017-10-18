package com.elements;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.elements.parser.ActionParser;
import com.objects.InteractableObject;
import com.platforms.Platform;
import com.search.SearchPlatforms;

import world.GameWorld;
public class Stage extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int TILE_SIZE = 25; //50
	public static final int MAX_WIDTH = 1050;
	public static final int MAX_HEIGHT = 700;
	public static final int FLOOR = 600;
	public static final int CENTER_WIDTH = 525;
	public static final int LOWEST_FLOOR = 24;
	
	public static final String PLATFORM = "#";
	public static final String EMPTY = " ";
	public static final String DYNAMIC = "-";
	
	protected GameWorld parent;
	protected String[][] blueprint; // 21 x 14
	protected ArrayList<Platform> platforms;

	protected ArrayList<InteractableObject> objects;
	
	protected JLabel lblBackground;
	
	public Stage(GameWorld parent, String[][] blueprint, ArrayList<InteractableObject> objects, String icon) {
		this.parent = parent;
		Game.initPanel(this, Color.WHITE, 0, 0, Stage.MAX_WIDTH, Stage.MAX_WIDTH);

		this.platforms = new ArrayList<Platform>();
		
		this.setBlueprint(blueprint);
		this.lblBackground = new JLabel();
		Game.initLabels(lblBackground, icon, null);
		
		this.repaint();
		this.revalidate();
		
		this.setObjects(objects);
		this.generateObjects(objects);
		this.generateMap();
		
		this.setVisible(false);
	}
	
	public void generateMap() {
		if(this.blueprint != null) {
			for(int i = 0; i < blueprint.length; i++) {
				for(int j = 0; j < blueprint[i].length; j++) {
					if(blueprint[i][j].equals(Stage.PLATFORM)) {
						Platform platform = new Platform(Stage.TILE_SIZE*j, Stage.TILE_SIZE*i, Stage.TILE_SIZE, Stage.TILE_SIZE, false);
						this.platforms.add(platform);
						this.add(platform.getLblPlatform());
						this.repaint();
						this.revalidate();
					}
				}
			}
		}
	}

	public void generateObjects(ArrayList<InteractableObject> objects) {
		this.setObjects(objects);

		for(int i = 0; i < this.objects.size(); i++) {
			this.objects.get(i).setParent(this);
			this.add(this.objects.get(i).getLblObject());
		}
	}
	
	/**
	 * searches for the object in the stage with the specified name, regardless of case
	 * @param name the name of the object to be searched
	 * @return the game object if found, null if not found
	 */
	public InteractableObject lookupObject(String name){
		for (InteractableObject o : objects) {
			if (o.getObjectName().equalsIgnoreCase(name)) {
				return o;
			}
		}
		return null;
	}

	public InteractableObject slookupObject(int index, String[] tokens){
		for (InteractableObject o : objects) {
			for(String s : o.getSynonyms()) {
				String[] ntokens = s.split(" ");
				boolean isMismatch = false;
				int i = index, j = 0;
				while(j < ntokens.length && i < tokens.length){
					if(ntokens[j++].equalsIgnoreCase(tokens[i])) {
						i++;
					}
					else{
						isMismatch=true;
						break;
					}
				}

				if(j != ntokens.length)
					isMismatch = true;

				if(!isMismatch) {
					ActionParser.index = index + (i - index) - 1;
					return o;
				}
			}
		}

		return null;
	}

	/**
	 * 
	 */
	public void start() {
		parent.getPlayer().setParent(this);
		this.setVisible(true);
		for(int i = 0; i < this.objects.size(); i++) {
			this.objects.get(i).spawn();
		}
			
		this.add(parent.getPlayer().getLblCharacter(), 0);
		this.add(lblBackground);
	}
	
	
	public SearchPlatforms hasPlatform(int x, int y) {
		int row = y/Stage.TILE_SIZE;
		int col = x/Stage.TILE_SIZE;
		if(col < 0)
			col = 0;
		else if(col >= blueprint[row].length)
			col = blueprint[row].length-1;
		
		if(row < blueprint.length && col < blueprint[row].length && blueprint[row][col].equals(Stage.PLATFORM)) {
			return new SearchPlatforms(col*Stage.TILE_SIZE, row*Stage.TILE_SIZE, true);
		}
		return new SearchPlatforms(col*Stage.TILE_SIZE, row*Stage.TILE_SIZE, false);
	}

	public void updateMessage(String text) {
		this.getParent().getGamebar().addMsgQueue(text);
	}
	
	public String[][] getBlueprint() {
		return blueprint;
	}

	public void setBlueprint(String[][] blueprint) {
		this.blueprint = blueprint;
	}

	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(ArrayList<Platform> platforms) {
		this.platforms = platforms;
	}

	public ArrayList<InteractableObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<InteractableObject> objects) {
		this.objects = objects;
	}

	public GameWorld getParent() {
		return parent;
	}

	public void setParent(GameWorld parent) {
		this.parent = parent;
	}
}
