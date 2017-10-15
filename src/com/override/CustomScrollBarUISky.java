package com.override;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
public class CustomScrollBarUISky extends BasicScrollBarUI {
	@Override 
	public JButton createDecreaseButton(int orientation) {
		JButton btnDecrease = new JButton();
		btnDecrease.setBorder(null);
		btnDecrease.setContentAreaFilled(false);
	
	    return btnDecrease;
	}
	
	@Override    
	public JButton createIncreaseButton(int orientation) {
		JButton btnIncrease = new JButton();
		btnIncrease.setBorder(null);
		btnIncrease.setContentAreaFilled(false);
		
		return btnIncrease;
	}
	@Override 
	public void configureScrollBarColors() {
		this.thumbColor = new Color(32, 227, 255, 200);
		this.trackColor = Color.WHITE;

	}
}
