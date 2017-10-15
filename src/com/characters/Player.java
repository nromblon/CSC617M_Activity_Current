package com.characters;

import javax.swing.ImageIcon;
import com.elements.Game;

public class Player extends Character {
	
	public Player() {
		super();
		
//		this.maxHealth = 1000;
//		this.maxMagic = 500;
		this.initComponents();
	}
	private void initComponents() {
		this.name = this.getClass().getSimpleName();
		Game.initLabels(lblCharacter, this.name+"_R0", null);
		
		this.iiMovLeft = new ImageIcon("images/"+this.name+"_L0.png");
		this.iiMovRight = new ImageIcon("images/"+this.name+"_R0.png");
		
		this.iiMovLeft1 = new ImageIcon("images/"+this.name+"_L1.png");
		this.iiMovRight1 = new ImageIcon("images/"+this.name+"_R1.png");
		
		this.iiMovLeft2 = new ImageIcon("images/"+this.name+"_L2.png");
		this.iiMovRight2 = new ImageIcon("images/"+this.name+"_R2.png");
		
		this.iiBullet = new ImageIcon("images/"+this.name+"_bullet.png");
		
		this.setCenterX(this.lblCharacter.getWidth()/2);
		this.setCenterY(this.lblCharacter.getHeight()/2);
		this.setMaxJumpHeight(this.lblCharacter.getHeight()/2);
	}
	
//	public void shoot() {
//		switch(this.shotType) {
//			case 1:
//				if(atkShoot && !tmrShoot.isRunning() && this.magic >= Projectile.MINE_COST) {
//					this.projectiles.add(new MineProjectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, 1000, this.enemies));
//					tmrShoot.start();
//				}
//				break;
//			case 2:
//				if(atkShoot && !tmrShoot.isRunning() && this.magic >= Projectile.HOMING_COST) {
//					this.projectiles.add(new HomingProjectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, this.enemies));
//					tmrShoot.start();
//				}
//				break;
//			case 3:
//				if(atkShoot && !tmrShoot.isRunning() && this.magic >= Projectile.TRAILING_COST) {
//					this.projectiles.add(new TrailingProjectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, this.enemies));
//					tmrShoot.start();
//				}
//				break;	
//			default:
//				if(atkShoot && !tmrShoot.isRunning() && this.magic >= Projectile.BASIC_COST) {
//					this.projectiles.add(new Projectile(this.parent, this, this.direction, this.x, this.y, this.bulletSpeed, this.magicDamage, this.enemies));
//					tmrShoot.start();
//				}
//		}		
//	}
//	public void cast() {
//		this.getProjectiles().add(new ProtonCannon(this.getParent(), this, this.getDirection(), this.getX(), this.getY(), this.getBulletSpeed(), this.getMagicDamage(), 12, this.getEnemies()));
//
//	}
}
