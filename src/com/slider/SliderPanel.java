package com.slider;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.overlay.SliderGame;

public class SliderPanel implements ActionListener {
	
	private SliderModel sliderModel;
	private JPanel pnlSlider;
	private ImageSplitter img;
	private ImageIcon blankSlot;
	private Tile[][] tiles;
	private SliderGame parent;

	public SliderPanel(SliderGame parent) {
		this.setParent(parent);
		this.sliderModel = new SliderModel();		
		
		this.pnlSlider = new JPanel();
		this.pnlSlider.setLayout(new GridBagLayout());
		this.pnlSlider.setBackground(Color.WHITE);
		this.pnlSlider.isOpaque();
		
		this.img = new ImageSplitter();
		this.createTiles();
	}
	
	private void createTiles() {
		this.tiles = new Tile[4][4];
		GridBagConstraints gbc;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int mapID = this.sliderModel.getMap()[i][j];
				int x_img = mapID/4;
				int y_img = mapID%4;
				
				if(mapID == 15) {
					this.blankSlot = new ImageIcon("images/BlankSlot.png");
					this.tiles[i][j] = new Tile(this.blankSlot, true, i, j);
					this.tiles[i][j].getBtnTile().setEnabled(false);
				}
				else {
					ImageIcon icon = new ImageIcon(this.img.getImages()[x_img][y_img]);
					this.tiles[i][j] = new Tile(icon, false, i, j);
				}
				
				gbc = new GridBagConstraints();
				gbc.gridx = i;
				gbc.gridy = j;
				
				this.tiles[i][j].getBtnTile().addActionListener(this);
				this.pnlSlider.add(this.tiles[i][j].getBtnTile(), gbc);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {				
				if(arg0.getSource().equals(this.tiles[i][j].getBtnTile())) {
					int x = this.tiles[i][j].getX();
					int y = this.tiles[i][j].getY();
					
					switch(this.nextMove(x, y)) {
						case UP: {
							this.swapTiles(this.tiles[i][j], this.tiles[i][j-1]);
							this.sliderModel.updateMap(Movement.UP, i, j);
							break;
						}
						case RIGHT: {
							this.swapTiles(this.tiles[i][j], this.tiles[i+1][j]);
							this.sliderModel.updateMap(Movement.RIGHT, i, j);
							break;
						}
						case DOWN: {
							this.swapTiles(this.tiles[i][j], this.tiles[i][j+1]);
							this.sliderModel.updateMap(Movement.DOWN, i, j);
							break;
						}
						case LEFT: {
							this.swapTiles(this.tiles[i][j], this.tiles[i-1][j]);
							this.sliderModel.updateMap(Movement.LEFT, i, j);
							break;
						}
						default:
							break;
					}
				}
			}
		}
		
		for(int m = 0; m < 4; m++) {
			for(int n = 0; n < 4; n++)
				System.out.print(this.sliderModel.getMap()[n][m]+"\t");
			System.out.println();
		}
		
		if(this.sliderModel.isGameOver()) {
			for(int o = 0; o < 4; o++) {
				for(int p = 0; p < 4; p++)
					this.tiles[o][p].getBtnTile().setBorderPainted(false);
			}
			this.getParent().getParent().addPictureNote();
		}
	}
	
	private void swapTiles(Tile currTile, Tile nextTile) {
		nextTile.getBtnTile().setIcon(currTile.getBtnTile().getIcon());
		nextTile.getBtnTile().setEnabled(true);
		nextTile.setIsFree(false);
		
		currTile.getBtnTile().setIcon(this.blankSlot);
		currTile.getBtnTile().setEnabled(false);
		currTile.setIsFree(true);
	}
	
	private boolean isOutOfBounds(int coordinate) {
		if(coordinate > 3 || coordinate < 0)
			return true;
		else
			return false;
	}
	
	private Movement nextMove(int x, int y) {
		if(!this.isOutOfBounds(y-1) && this.tiles[x][y-1].isFree())
			return Movement.UP;
		else if(!this.isOutOfBounds(x+1) && this.tiles[x+1][y].isFree())
			return Movement.RIGHT;
		else if(!this.isOutOfBounds(y+1) && this.tiles[x][y+1].isFree())
			return Movement.DOWN;
		else if(!this.isOutOfBounds(x-1) && this.tiles[x-1][y].isFree())
			return Movement.LEFT;
		else
			return Movement.NONE;
	}
	
	public JPanel getUI() {
		return this.pnlSlider;
	}
	
	public Tile[][] getTiles() {
		return this.tiles;
	}

	public SliderGame getParent() {
		return parent;
	}

	public void setParent(SliderGame parent) {
		this.parent = parent;
	}

}
