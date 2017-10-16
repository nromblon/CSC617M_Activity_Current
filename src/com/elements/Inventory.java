package com.elements;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import com.characters.Character;

import com.frame.Frame;
import com.objects.InteractableObject;

import world.GameWorld;

public class Inventory extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private GameWorld parent;
	private Character player;
	
	private int keyPointer;
	private boolean isSuccessful;
	
//	private JTextField txtfControls;
	private JLabel lblTitle;
	private JPanel pnlInventory;
	private JScrollPane scrlInventory;
	
	private int widthPnlScroll;
	private ArrayList<String> listInventory;
//	private ArrayList<String> strControlLog;
	public Inventory(GameWorld parent, Character player) {
		this.parent = parent;
		this.player = player;
		this.isSuccessful = false;
		
		int offsetW = 30;
		int offsetX = offsetW/2;
		int width = parent.getWidth()-Stage.MAX_WIDTH-offsetW;
		Game.initPanel(this, Game.clrTransparent, Stage.MAX_WIDTH+offsetX, 150, width, width);	
		this.initComponents();

//		this.add(txtfControls);

		this.add(lblTitle);
		this.add(scrlInventory);
		this.setVisible(true);

		scrlInventory.setLocation(scrlInventory.getX(), 500);
		this.widthPnlScroll = scrlInventory.getWidth();
		
		this.listInventory = new ArrayList<String>();
//	  	this.txtfControls.addKeyListener(new TAdapter());
	}
	
	public void initComponents() {
		this.setLayout(new FlowLayout());
//		this.strControlLog = new ArrayList<String>();
//		this.txtfControls = new JTextField();
//		Game.initTextField(txtfControls, 0, 0, this.getWidth()-50, 25, Game.fntDefault11, Game.clrAutomatic);
		
		
		this.pnlInventory = new JPanel();
		pnlInventory.setBackground(Color.LIGHT_GRAY);
		pnlInventory.setLayout(new BoxLayout(pnlInventory, BoxLayout.Y_AXIS));

//		pnlInventory.setLayout(new GridBagLayout());
		
		int offsetH = 30;
		this.scrlInventory = new JScrollPane(pnlInventory);
		Frame.initScrollPane(scrlInventory, pnlInventory, 0, 0, this.getWidth(), this.getHeight()-offsetH);
		scrlInventory.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		

		this.lblTitle = new JLabel();
		lblTitle.setText("Inventory");
		Game.initLabel(lblTitle, Game.fntGothamLight20, Game.clrTransparent, 0, 0, this.getWidth(), offsetH);
		lblTitle.setForeground(Color.WHITE);
		scrlInventory.setLocation(0, lblTitle.getHeight());
	}
	
//	public void cast() {
//		if(isSuccessful && player.getMagic() >= player.getSkillCost() && player.isActive()) {
//			this.cutIn();
//			player.setMagic(player.getMagic()-player.getSkillCost());
//			player.cast();
////			player.getProjectiles().add(new NyancatLaser(player.getParent(), player, player.getDirection(), player.getX(), player.getY(), player.getBulletSpeed(), player.getMagicDamage(), player.getEnemies()));
//			this.setSuccessful(false);
//		}
//		else {
//			this.setSuccessful(false);
//		}
//
////		this.projectiles.add(new MineProjectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, 1000, this.enemies));
//		
//	}
	
//	public void autoCast(GameObject enemy) {
//		if(enemy.isActive() && !enemy.isCasting()) {
//			if(enemy.isSuccessful() && enemy.getMagic() >= enemy.getSkillCost()) {
//				this.cutIn();
//				enemy.setCasting(true);
//				enemy.setMagic(enemy.getMagic()-enemy.getSkillCost());
//				enemy.cast();
////				enemy.getProjectiles().add(new Equalizer(enemy.getParent(), enemy, -enemy.getDirection(), enemy.getX(), enemy.getY(), enemy.getBulletSpeed(), enemy.getMagicDamage(), enemy.getEnemies()));
////				enemy.getProjectiles().add(new Equalizer(enemy.getParent(), enemy, enemy.getDirection(), enemy.getX(), enemy.getY(), enemy.getBulletSpeed(), enemy.getMagicDamage(), enemy.getEnemies()));
//				
////				enemy.getProjectiles().add(new NyancatLaser(enemy.getParent(), enemy, enemy.getDirection(), enemy.getX(), enemy.getY(), enemy.getBulletSpeed(), enemy.getMagicDamage(), enemy.getEnemies()));
//				enemy.setSuccessful(false);
//			}
//			else
//				enemy.setSuccessful(false);
////			this.projectiles.add(new MineProjectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, 1000, this.enemies));
//			
//		}
//	}
	// TODO
	public void cutIn() {
//		this.parent.getStage().add(this.lblCutIn, 0);
//		this.parent.setComponentZOrder(this.lblCutIn, 1);
//		this.lblCutIn.setVisible(true);
//		this.lblCutIn.setLocation(this.iX, this.iY);
//		this.tmrCutIn.start();
	}
	
	public void action(String strAction) {
		
		endAction();
		
		//TODO START :: Remove
		if(strAction.contains("bedroom")) {
			//TODO properly locate object to interact with
			player.getParent().getObjects().get(1).open();
		}
		if(strAction.contains("bathroom")) {
			//TODO properly locate object to interact with
			player.getParent().getObjects().get(2).open();
		}
		if(strAction.contains("kitchen")) {
			//TODO properly locate object to interact with
			player.getParent().getObjects().get(0).open();
		}
		if(strAction.contains("hallway")) {
			//TODO properly locate object to interact with
			player.getParent().getObjects().get(0).open();
		}
		// END
		
		if(strAction.contains("turn")) {
			player.turn();
		}
		if(strAction.contains("forward")) {
			player.forward();
		}
		if(strAction.contains("left")) {
			player.moveLeft();
		}
		if(strAction.contains("right")) {
			player.moveRight();
		}
		if(strAction.contains("jump")) {
			player.jump();
		}
		if(strAction.contains("down")) {
			player.moveDown();
		}
//		if(strAction.contains("shoot")) {
//			player.attack();
//		}
//		if(strAction.contains("change weapon")) {
////			player.setAtkShoot(true);
//			player.switchWeapon();
//		}
//		if(strAction.contains("special")) {
//			player.cast();
//		}

		if(strAction.contains("pause")) {
			parent.pause();
		}
//		if(strAction.contains("open door")) {
//			player.openNextDoor(parent);
//		}
//		else if(strAction.contains("go back")) {
//			player.openPrevDoor(parent);
//		}
	}
	
	public void endAction() {
		player.stop();
	}
	
	public void addItem(InteractableObject item) {
		pnlInventory.add(createItem(item, pnlInventory), null, 0);
		
	}
	
	public void removeItem(InteractableObject item) {
		this.removeItem(item.getObjectName());
	}
	
	public void removeItem(String itemName) {
		this.pnlInventory.remove(searchItem(itemName));
	}

	public Component searchItem(String text) {
		for(Component component : pnlInventory.getComponents()) {
			
			if(text.trim().equals(component.getName())){
				return component;
			}
		}
		return null;
	}
	
	public boolean searchIfItemExists(String text) {
		for(Component component : pnlInventory.getComponents()) {
			if(text.trim().equals(component.getName())){
				return true;
			}
		}
		return false;
	}

	public JLabel createItem(InteractableObject item, JPanel parent) {
		
		this.listInventory.add(item.getObjectName());
		
		JLabel lblImage = new JLabel();
		JLabel lblDescriptionBorder = new JLabel();
		JLabel lblDescription = new JLabel();

		JLabel lblTitle = new JLabel(item.getObjectName());

		JLabel lblDescriptionText = new JLabel();

		JLabel label = new JLabel();
		JLabel labelBorder = new JLabel();


		int width = 70;

		Frame.initLabel(lblImage, Frame.fntDefault13, Frame.clrAutomatic, Color.WHITE, width, width);
		lblImage.setIcon(item.getIiInventory());
		Frame.initLabel(lblDescriptionBorder, Frame.fntDefault13, Frame.clrAutomatic, Color.WHITE, this.widthPnlScroll-width, width);

		int offset = 6;
		int offsetLocation = offset/2;
		Frame.initLabel(lblDescription, Frame.fntDefault13, Frame.clrAutomatic, Game.clrTransparent, lblDescriptionBorder.getWidth()-offset, lblDescriptionBorder.getHeight()-offset);
		lblDescription.setVerticalAlignment(JLabel.TOP);

		int titleHeight = width/3;
		Frame.initLabel(lblTitle, Frame.fntDefault16, Frame.clrAutomatic, Color.WHITE, lblDescription.getWidth(), titleHeight);
		Frame.initLabel(lblDescriptionText, Frame.fntDefault13, Frame.clrAutomatic, Color.WHITE, width, titleHeight);
		lblDescription.add(lblTitle);
		lblDescription.add(lblDescriptionText);

		lblDescriptionBorder.add(lblDescription);
		lblDescription.setLocation(offsetLocation, offsetLocation);
		Frame.initLabel(label, Frame.fntDefault13, Frame.clrAutomatic, Frame.clrLightGray, this.widthPnlScroll, width);
//		label.addMouseListener(this);
		Frame.initLabel(labelBorder, Frame.fntDefault13, Frame.clrAutomatic, pnlInventory.getBackground(), this.widthPnlScroll, width+1);
		
		label.setLayout(new BoxLayout(label, BoxLayout.X_AXIS));
		label.add(lblImage);
		label.add(lblDescriptionBorder);
		
//		Frame.initButtons(button, label.getBackground(), label.getWidth()-63, 0, 50, label.getHeight(), this);
//		button.setBorder(Frame.brdrEmpty);
//		button.setVisible(false);
//		label.add(button);
		labelBorder.add(label);
		labelBorder.setName(item.getObjectName());
		labelBorder.addMouseListener(this);
		return labelBorder;
	}
	
	public GameWorld getParent() {
		return parent;
	}

	public void setParent(GameWorld parent) {
		this.parent = parent;
	}

	public int getKeyPointer() {
		return keyPointer;
	}
	
	public void setKeyPointer(int keyPointer) {
		this.keyPointer = keyPointer;
	}
	
	public KeyListener getKeyListener() {
		return this.getKeyListener();
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public JPanel getPnlControlLog() {
		return pnlInventory;
	}

	public void setPnlControlLog(JPanel pnlControlLog) {
		this.pnlInventory = pnlControlLog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() instanceof Component) {
			Component component = (Component)e.getSource();
			String name = component.getName();
			
			if(name.equals("Vault")) {
				this.getParent().openOverlayVault();
			}
			
			if(name.equals("BathroomNote")) {
				this.getParent().openOverlayNote();
			}
			
			if(name.equals("Picture")) {
				this.getParent().openSliderGame();
			}
			
			if(name.equals("PictureNote")) {
				this.getParent().openPictureNoteOverlay();
			}
		}
	}
}
