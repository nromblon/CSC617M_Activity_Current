package com.characters;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.elements.Game;
import com.elements.Stage;
import com.objects.InteractableObject;

import world.GameWorld;

public abstract class Character {
	protected String name;
	protected int direction;
	
	protected int iX;
	protected int iY;
	
	protected int x;
	protected int y;
	protected int centerX;
	protected int centerY;
	protected int stepWidth;
	protected int jumpHeight;
	protected int weight;
	
	protected int maxJumpHeight;
	protected int jumpSpan;
	

	protected boolean isMovingTo;
	protected boolean isInAction;
	protected InteractableObject moveToObject;
	protected boolean isAlive;
	protected boolean movLeft;
	protected boolean movRight;
	protected boolean movUp;
	protected boolean movDown;
	
	protected boolean isUp;
	protected boolean isDown;

	protected boolean isInOverlay;
	
	protected JLabel lblCharacter;
	protected Stage parent;
	
	
	protected ImageIcon iiDmgLeft;
	protected ImageIcon iiDmgRight;
	protected ImageIcon iiMovLeft;
	protected ImageIcon iiMovRight;
	protected ImageIcon iiMovUp;
	protected ImageIcon iiMovDown;
	
	protected ImageIcon iiBullet;
	
	public Character() {
		
		
		this.name = "Undefined";

		this.isInOverlay = false;
		this.isInAction = false;
		
		this.direction = 1;
		this.iX = 0;
		this.iY = 0;
		
		this.x = this.iX;
		this.y = this.iY;
		
		this.stepWidth = 3;
		this.jumpHeight = 2;
		this.jumpSpan = 0;
		this.weight = 2;
		
		this.maxJumpHeight = 100;
		this.isAlive = true;

		this.movLeft = false;
		this.movRight = false;
		this.movUp = false;
		this.movDown = false;
		this.isMovingTo = false;
		
		this.isUp = false;
		this.isDown = false;
		
		this.lblCharacter = new JLabel();
	}

	
	/** PLAYER ACTION FUNCTIONS
	 * These are the set of actions that the player can perform.
	 * @author Candy
	 */
	
//	public void attack() {
//		this.setAtkShoot(true);
//	}
	
//	public void switchWeapon() {
//		this.setShotType(this.getShotType()+1);
//	}
	
	public void jump() {
		this.setMovUp(true);
	}
	
	public void moveDown() {
		this.setMovDown(true);
	}
	
	public void moveLeft() {
		this.setMovLeft(true);
	}
	
	public void moveRight() {
		this.setMovRight(true);
	}
	
	public void turn() {
		this.direction = -this.direction;
	}

	public boolean isInFrontOf(InteractableObject object){
		int objectWidth = object.getLblObject().getWidth();
		int objectBound[] = { object.getX() , object.getX() + objectWidth };

		int playerCenter = this.x;
		if(playerCenter >= objectBound[0] && playerCenter <= objectBound[1])
			return true;
		else
			return false;
	}

	public void moveTo(InteractableObject object){
		isMovingTo = true;
		if(moveToObject == null)
			this.moveToObject = object;

		int objectCenter = object.getX() + (object.getLblObject().getWidth()/2);

		int playerCenter = this.x;

		if(objectCenter < playerCenter && isFacingRight())
			this.turn();
		else if(objectCenter > playerCenter && !isFacingRight())
			this.turn();


		if(isInFrontOf(object)){
			this.stop();
		}
		else{
			this.forward();
		}
	}

//	public void openNextDoor(World stage) {
//		isOpeningNextDoor = true;
//		
//		if(!isFacingRight())
//			this.turn();
//		
//		if(isInfrontOfNextDoor()) {
//			this.stop();
//			stage.setNextDoorOpened(true);
//		}
//		else {
//			this.forward();
//		}
//	}
	
//	public void openPrevDoor(World stage) {
//		stage.setPrevDoorOpened(true);
//	}
	
	public void forward() {
		if(isFacingRight())
			this.setMovRight(true);
		else
			this.setMovLeft(true);
	}
	
	public void stop() {
		this.setMovDown(false);
		this.setMovLeft(false);
		this.setMovRight(false);
		this.setMovUp(false);
//		this.setAtkShoot(false);


		isMovingTo = false;
//		isOpeningNextDoor = false;
//		isOpeningPrevDoor = false;

		moveToObject = null;
	}
	
	/**
	 * Returns true if the player is currently in the middle of doing an action.
	 * 
	 * i.e: The command "open door" may require the player to move forward until he
	 * reaches the door before being allowed to proceed to the next sub-stage.
	 * @return
	 */
	public boolean isBusy() {
		if(isMovingTo | isInOverlay | isInAction)
			return true;
		else
			return false;
	}

	public boolean isInAction() {
		return isInAction;
	}

	public void setInAction(boolean inAction) {
		isInAction = inAction;
	}

	public void setIsInOverlay(boolean isInOverlay){
		this.isInOverlay = isInOverlay;
	}

	public void continueAction() {
		if(isMovingTo){
			this.moveTo(moveToObject);
		}
	}
	
	
	public boolean isFacingRight() {
		if(this.direction > 0)
			return true;
		else
			return false;
	}
	public boolean isInfrontOfNextDoor() {
		System.out.println(x);
		if(this.x >= Game.NEXT_DOOR_X)
			return true;
		else
			return false;
	}
	
//	public class ShootTimer implements ActionListener {
//		public ShootTimer() {
////			time = bulletInterval;
//		}
//		@Override
//
//		public void actionPerformed(ActionEvent e) {
////			if(time == 0) {
////				time = bulletInterval;
////			tmrShoot.stop();
//			setAtkShoot(false); // TODO Remove this for continuous shot.
////			}
////			time -= 1;
//		}
//	}
//	
////	public class MagicGainTimer implements ActionListener {
////		public MagicGainTimer() {
////		}
////		@Override
////		public void actionPerformed(ActionEvent e) {
////			setMagic(magic+magicGain);
////		}
////	}
////	public class BlinkTimer implements ActionListener {
//////		private int time;
////		public BlinkTimer() {
//////			time = 2;
////		}
////		@Override
////		public void actionPerformed(ActionEvent e) {
//////			if(time == 0) {
//////				time = bulletInterval;
////			setCharacterImage(getName());
////			tmrIconBlink.stop();
//////			}
//////			time -= 1;
////		}
////	}
////	public class StunTimer implements ActionListener {
////		public StunTimer() {
////		}
////		@Override
////		public void actionPerformed(ActionEvent e) {
////			setStunned(false);
////			tmrStun.stop();
//////			}
//////			time -= 1;
////		}
////	}
////	public void shoot() {
////		if(isActive() && atkShoot && !tmrShoot.isRunning() && this.magic >= Projectile.BASIC_COST) {
////			this.projectiles.add(new Projectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, this.enemies));
////
////			tmrShoot.start();
////		}
////	}
	
	public boolean isActive() {
		if(!isAlive || GameWorld.IS_PAUSED) {
			return false;
		}
		else
			return true;
	}
	
	
	public void setCharacterImage() {
		if(this.direction > 0) {
//			if(isMoving) {
//				if(this.lblCharacter.getIcon().equals(this.iiMovRight1)) {
//					Game.initLabels(this.lblCharacter, this.iiMovRight2, null);
//				}
//				else {
//					Game.initLabels(this.lblCharacter, this.iiMovRight1, null);
//				}					
//			}
//			else {
				Game.initLabels(this.lblCharacter, this.iiMovRight, null);
//			}			
		}
		else {
//			if(isMoving) {
//				if(this.lblCharacter.getIcon().equals(this.iiMovLeft1)) {
//					Game.initLabels(this.lblCharacter, this.iiMovLeft2, null);
//				}
//				else {
//					Game.initLabels(this.lblCharacter, this.iiMovLeft1, null);
//				}					
//			}
//			else {
				Game.initLabels(this.lblCharacter, this.iiMovLeft, null);
//			}	
		}
	}
	
	public void move() {
		if(isActive()) {
			if(movLeft) {
				this.setX(this.x-this.stepWidth);
				this.direction = -1;
//				this.setCharacterImage(true);
			}
			else if(movRight) {
				this.setX(this.x+this.stepWidth);
				this.direction = 1;
//				this.setCharacterImage(true);
			}
//			else {
//				this.setCharacterImage(false);
//			}
			this.setCharacterImage();
			if(movUp) {
				if(!(this.isUp || this.isDown)) {
					this.isUp = true;
					this.movUp = false;
				}
			}
			else if(movDown) {
				if(!(this.isUp || this.isDown)) {
					this.setY(this.y+Stage.TILE_SIZE);
					this.isDown = true;
				}
			}
			
			if(isUp) {
				this.jumpSpan += this.jumpHeight;
				this.setY(this.y-this.jumpHeight);
				if(this.jumpSpan >= this.maxJumpHeight) {
					this.jumpSpan = 0;
					this.isUp = false;
					this.isDown = true;
				}
			}
		}
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

	public int getStepWidth() {
		return stepWidth;
	}

	public void setStepWidth(int stepWidth) {
		this.stepWidth = stepWidth;
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isMovLeft() {
		return movLeft;
	}

	public void setMovLeft(boolean movLeft) {
		this.movLeft = movLeft;
	}

	public boolean isMovRight() {
		return movRight;
	}

	public void setMovRight(boolean movRight) {
		this.movRight = movRight;
	}

	public boolean isMovUp() {
		return movUp;
	}

	public void setMovUp(boolean movUp) {
		if(movUp) {
			if(this.movUp || this.isUp || this.isDown)
				movUp = false;
		}
		this.movUp = movUp;
	}

	public boolean isMovDown() {
		return movDown;
	}

	public void setMovDown(boolean movDown) {
		if(this.getiY() < Stage.LOWEST_FLOOR)
			this.movDown = movDown;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

//	public ArrayList<Projectile> getProjectiles() {
//		return projectiles;
//	}
//
//	public void setProjectiles(ArrayList<Projectile> projectiles) {
//		this.projectiles = projectiles;
//	}

	public JLabel getLblCharacter() {
		return lblCharacter;
	}

	public void setLblCharacter(JLabel lblCharacter) {
		this.lblCharacter = lblCharacter;
	}
	
	public int getMaxJumpHeight() {
		return maxJumpHeight;
	}
	
	public void setMaxJumpHeight(int maxJumpHeight) {
		this.maxJumpHeight = maxJumpHeight;
	}
	
	public int getCenterX() {
		return this.lblCharacter.getWidth()/2;
	}
	
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	public int getCenterY() {
		return this.lblCharacter.getHeight()/2;
	}
	
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	public int getJumpSpan() {
		return jumpSpan;
	}
	
	public void setJumpSpan(int jumpSpan) {
		this.jumpSpan = jumpSpan;
	}
	
//	public boolean isAtkShoot() {
//		return atkShoot;
//	}
//	
//	public void setAtkShoot(boolean atkShoot) {
//		this.atkShoot = atkShoot;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getMaxBullets() {
//		return maxBullets;
//	}
//
//	public void setMaxBullets(int maxBullets) {
//		this.maxBullets = maxBullets;
//	}
//
//	public int getBulletSpeed() {
//		return bulletSpeed;
//	}
//
//	public void setBulletSpeed(int bulletSpeed) {
//		this.bulletSpeed = bulletSpeed;
//	}

//	public Timer getTmrShoot() {
//		return tmrShoot;
//	}
//
//	public void setTmrShoot(Timer tmrShoot) {
//		this.tmrShoot = tmrShoot;
//	}

//	public int getBulletInterval() {
//		return bulletInterval;
//	}
//
//	public void setBulletInterval(int bulletInterval) {
//		this.bulletInterval = bulletInterval;
//	}
//
//	public int getMaxHealth() {
//		return maxHealth;
//	}
//
//	public void setMaxHealth(int maxHealth) {
//		this.maxHealth = maxHealth;
//	}
//
//	public int getMaxMagic() {
//		return maxMagic;
//	}
//
//	public void setMaxMagic(int maxMagic) {
//		this.maxMagic = maxMagic;
//	}
//
//	public int getHealth() {
//		return health;
//	}
//
//	public void setHealth(int health) {
//		if(health > this.maxHealth)
//			health = this.maxHealth;
//		else if(health < 0)
//			health = 0;
//		
//		this.health = health;
//	}
//
//	public int getMagic() {
//		return magic;
//	}
//
//	public void setMagic(int magic) {
//		if(magic > this.maxMagic)
//			magic = this.maxMagic;
//		else if(magic < 0)
//			magic = 0;
//		this.magic = magic;
//	}
	
	public void setCharacterImage(String image) {
		this.iiMovLeft = new ImageIcon("images/"+image+"_L0.png");
		this.iiMovRight = new ImageIcon("images/"+image+"_R0.png");
		if(this.direction > 0) {
			Game.initLabels(this.lblCharacter, iiMovRight, null);
		}
		else {
			Game.initLabels(this.lblCharacter, iiMovLeft, null);
		}
	}
	
//	public ArrayList<Character> getEnemies() {
//		return enemies;
//	}
//
//	public void setEnemies(ArrayList<Character> enemies) {
//		this.enemies = enemies;
//	}
//
//	public int getMagicGain() {
//		return magicGain;
//	}
//
//	public void setMagicGain(int magicGain) {
//		this.magicGain = magicGain;
//	}
//
//	public int getMagicDamage() {
//		return magicDamage;
//	}
//
//	public void setMagicDamage(int magicDamage) {
//		this.magicDamage = magicDamage;
//	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

//	public Timer getTmrMagicGain() {
//		return tmrMagicGain;
//	}
//
//	public void setTmrMagicGain(Timer tmrMagicGain) {
//		this.tmrMagicGain = tmrMagicGain;
//	}

	public ImageIcon getIiMovLeft() {
		return iiMovLeft;
	}

	public void setIiMovLeft(ImageIcon iiMovLeft) {
		this.iiMovLeft = iiMovLeft;
	}

	public ImageIcon getIiMovRight() {
		return iiMovRight;
	}

	public void setIiMovRight(ImageIcon iiMovRight) {
		this.iiMovRight = iiMovRight;
	}

	public ImageIcon getIiMovUp() {
		return iiMovUp;
	}

	public void setIiMovUp(ImageIcon iiMovUp) {
		this.iiMovUp = iiMovUp;
	}

	public ImageIcon getIiMovDown() {
		return iiMovDown;
	}

	public void setIiMovDown(ImageIcon iiMovDown) {
		this.iiMovDown = iiMovDown;
	}

	public ImageIcon getIiBullet() {
		return iiBullet;
	}

	public void setIiBullet(ImageIcon iiBullet) {
		this.iiBullet = iiBullet;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Stage getParent() {
		return parent;
	}

	public void setParent(Stage parent) {
		this.parent = parent;
	}
}
