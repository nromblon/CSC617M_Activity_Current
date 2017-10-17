package com.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.characters.Character;

import world.GameWorld;

public class GameTimer extends JPanel{
	private static final long serialVersionUID = 1L;
	private GameWorld parent;
	private Character player;
	
	private Timer timer;
	
	private JLabel timeLbl;
	private String time;
	
	public GameTimer(GameWorld parent, Character player, int minutes) {
		this.parent = parent;
		this.player = player;
		
		
		Game.initPanel(this, Game.clrTransparent, Stage.MAX_WIDTH, 70, parent.getWidth()-Stage.MAX_WIDTH, parent.getHeight());	
		this.initComponents();
		
		this.add(timeLbl);
		
		this.startTimer(minutes);
	}
	
	private void initComponents() {
		timeLbl = new JLabel();
		Game.initLabel(timeLbl, Game.fntGothamLight20, Game.clrTransparent, 0, 0, 316, 60);
		timeLbl.setHorizontalAlignment(JLabel.CENTER);
		timeLbl.setForeground(Color.WHITE);
		timeLbl.setFont(new Font("Gotham Nights", Font.PLAIN, 40));
	}
	
	private void startTimer(int minutes) {
		Time timeObj = new Time(minutes*60000);
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		time = sdf.format(timeObj);
		timeLbl.setText(time);
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timeObj.setTime(timeObj.getTime() - 1000);
				time = sdf.format(timeObj);
				timeLbl.setText(time);
				repaint();
				
				if(timeObj.getTime() == 0) {
					parent.endWorld(false);
				}
			}
		});

	    timer.start();
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}
	
}
