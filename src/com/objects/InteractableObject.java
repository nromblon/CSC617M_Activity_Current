package com.objects;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Stage;

import com.characters.Character;
/**
 * Parent class of all game objects that the player can interact with.
 * This does not include the Player class.
 * @author Candy
 *
 */
public abstract class InteractableObject {

	protected final String[] synonyms;
	
	protected InteractableObject target;
	
	protected int iX;
	protected int iY;
	
	protected int x;
	protected int y;
	protected int centerX;
	protected int centerY;
	
	protected JLabel lblObject;
	protected Stage parent;
	
	protected ImageIcon iiDefault;	
	protected ImageIcon iiInventory;
	protected ImageIcon iiOpened;
	protected ImageIcon iiViewed;
	protected ImageIcon iiClosed;
	protected ImageIcon iiTaken;
	/**
	 * 
	 */
	protected ImageIcon iiUsed;
	
	public ImageIcon getIiUsed() {
		return iiUsed;
	}

	public void setIiUsed(ImageIcon iiUsed) {
		this.iiUsed = iiUsed;
	}

	protected boolean isDefault;	
	protected boolean isInventory;
	protected boolean isOpened;
	protected boolean isUsed;
	protected boolean isViewed;
	protected boolean isTaken;
	protected boolean isLocked;
	
	public String viewResponse = "";
	public String openResponse = "";
	public String closeResponse = "";
	public String useResponse = "";
	public String takeResponse = "";
	
	public String getUseResponse() {
		return useResponse;
	}

	public void setUseResponse(String useResponse) {
		this.useResponse = useResponse;
	}

	public String getTakeResponse() {
		return takeResponse;
	}

	public void setTakeResponse(String takeResponse) {
		this.takeResponse = takeResponse;
	}

	protected String objectName;
	
	public abstract void update();
	
	public abstract void view();
	public abstract void open();
	public abstract void use();
	public abstract void close();
	public abstract void take();
	
	public InteractableObject(String[] synonyms) {
		this.synonyms = synonyms;
		this.setTarget(this);
	}
	
	public void spawn() {
		lblObject.setVisible(true);
		lblObject.setLocation(iX, iY);
	}
	
	public Character getPlayer() {
		return this.parent.getParent().getPlayer();
	}
	
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
	public int getiX() {
		return iX;
	}

	public void setiX(int iX) {
		this.iX = iX;
	}

	public int getiY() {
		return iY;
	}

	public void setiY(int iY) {
		this.iY = iY;
	}

	public int getX() {
		return x;
	}
//	public int getWeight() {
//		return weight;
//	}

//	public boolean isUp() {
//		return isUp;
//	}

//	public void setUp(boolean isUp) {
//		this.isUp = isUp;
//	}

	
	public void setX(int x) {
		if(x < 0)
			x = 0;
		else if (x > Stage.MAX_WIDTH)
			x = Stage.MAX_WIDTH;
		
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {	
		if(y > Stage.MAX_HEIGHT-Stage.TILE_SIZE)
			y = Stage.MAX_HEIGHT-Stage.TILE_SIZE;
		this.y = y;
	}
	public int getCenterX() {
		return this.lblObject.getWidth()/2;
	}
	
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	public int getCenterY() {
		return this.lblObject.getHeight()/2;
	}
	
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public JLabel getLblObject() {
		return lblObject;
	}

	public void setLblObject(JLabel lblObject) {
		this.lblObject = lblObject;
	}

//	public boolean isDown() {
//		return isDown;
//	}

	public Stage getParent() {
		return parent;
	}

	public void setParent(Stage parent) {
		this.parent = parent;
	}

	public ImageIcon getIiDefault() {
		return iiDefault;
	}

	public void setIiDefault(ImageIcon iiDefault) {
		this.iiDefault = iiDefault;
	}

	public ImageIcon getIiInventory() {
		return iiInventory;
	}

	public void setIiInventory(ImageIcon iiInventory) {
		this.iiInventory = iiInventory;
	}

	public ImageIcon getIiOpened() {
		return iiOpened;
	}

	public void setIiOpened(ImageIcon iiOpened) {
		this.iiOpened = iiOpened;
	}

	public ImageIcon getIiViewed() {
		return iiViewed;
	}

	public void setIiViewed(ImageIcon iiViewed) {
		this.iiViewed = iiViewed;
	}

	public ImageIcon getIiClosed() {
		return iiClosed;
	}

	public void setIiClosed(ImageIcon iiClosed) {
		this.iiClosed = iiClosed;
	}

	public ImageIcon getIiTaken() {
		return iiTaken;
	}

	public void setIiTaken(ImageIcon iiTaken) {
		this.iiTaken = iiTaken;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isInventory() {
		return isInventory;
	}

	public void setInventory(boolean isInventory) {
		this.isInventory = isInventory;
	}

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public boolean isViewed() {
		return isViewed;
	}

	public void setViewed(boolean isViewed) {
		this.isViewed = isViewed;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public InteractableObject getTarget() {
		return target;
	}

	public void setTarget(InteractableObject target) {
		this.target = target;
	}

	public String[] getSynonyms() {
		return synonyms;
	}

	public String getViewResponse() {
		return viewResponse;
	}

	public void setViewResponse(String viewResponse) {
		this.viewResponse = viewResponse;
	}

	public String getOpenResponse() {
		return openResponse;
	}

	public void setOpenResponse(String openResponse) {
		this.openResponse = openResponse;
	}

	public String getCloseResponse() {
		return closeResponse;
	}

	public void setCloseResponse(String closeResponse) {
		this.closeResponse = closeResponse;
	}
}
