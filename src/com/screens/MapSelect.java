package com.screens;


import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.elements.Game;

public class MapSelect extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JPanel parent;
	private JLabel lblMap;
	
	private ImageIcon iiClassroom;
	private ImageIcon iiCafeteria;
	private ImageIcon iiLibrary;
	
	private int mapPointer;
	
	public MapSelect(JPanel parent) {
		this.parent = parent;
		this.mapPointer = 1;
		
		this.initComponents();
		this.add(lblMap);
	}
	public void initComponents() {
		Game.initPanel(this, Game.clrBlack70, 0, 0, Game.MAX_WIDTH, Game.MAX_WIDTH);
		this.setOpaque(true);
		this.lblMap = new JLabel();
		
		this.iiClassroom = Game.setIconToFit(new ImageIcon("images/Classroom.png"), new Dimension(650, 433));
		this.iiCafeteria = Game.setIconToFit(new ImageIcon("images/Cafeteria.png"), new Dimension(650, 433));
		this.iiLibrary = Game.setIconToFit(new ImageIcon("images/Library.png"), new Dimension(650, 433));
		
		Game.initLabels(this.lblMap, this.iiClassroom, null);
		this.lblMap.setLocation(358, 103);
	}
	
	public void nextMap() {
		this.setMapPointer(this.mapPointer+1);
		this.lblMap.setIcon(this.switchMap());
	}
	
	public void prevMap() {
		this.setMapPointer(this.mapPointer-1);
		this.lblMap.setIcon(this.switchMap());
	}
	
	public ImageIcon switchMap() {
		System.out.println("mappointer is "+this.mapPointer);
		switch(this.mapPointer) {
		case 1: return this.iiClassroom;
		case 2: return this.iiCafeteria;
		case 3: return this.iiLibrary;
		default: return this.iiClassroom;
		}
	}
	
	public JPanel getParent() {
		return parent;
	}

	public void setParent(JPanel parent) {
		this.parent = parent;
	}
	
	public int getMapPointer() {
		return mapPointer;
	}
	public void setMapPointer(int mapPointer) {
		if(mapPointer > 3) {
			mapPointer = 1;
		}
		else if(mapPointer < 1)
			mapPointer = 3;
		this.mapPointer = mapPointer;
	}
}
